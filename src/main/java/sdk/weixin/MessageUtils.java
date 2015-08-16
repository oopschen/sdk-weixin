package sdk.weixin;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sdk.weixin.msg.BaseMessage;
import sdk.weixin.msg.EncryptMessage;
import sdk.weixin.msg.parser.MessageParser;
import sdk.weixin.msg.parser.impl.MessageSaxParser;

import java.io.InputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>消息工具类</p>
 *
 * @author chenl
 * @version %I%, %G%
 */
public class MessageUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageUtils.class);
    private static final ReentrantReadWriteLock INS_LOCK = new ReentrantReadWriteLock();
    private static MessageUtils INS;
    private String token;
    private String encodingAesKey;
    private String appID;
    private WXBizMsgCrypt enDeCrypter;

    private MessageUtils(String token, String encodingAesKey, String appID) {
        this.token = token;
        this.encodingAesKey = encodingAesKey;
        this.appID = appID;
        try {
            this.enDeCrypter = new WXBizMsgCrypt(token, encodingAesKey, appID);
        } catch (AesException e) {
            LOGGER.error("init enDecrypter", e);
        }
    }

    /**
     * get instance of MessageUtils
     *
     * @param token          开发者设置token
     * @param encodingAesKey 开发者设置的EncodingAESKey
     * @param appID          开发者APPID
     * @return
     */
    public static final MessageUtils getInstance(String token, String encodingAesKey,
        String appID) {
        ReentrantReadWriteLock.ReadLock readLock = INS_LOCK.readLock();
        readLock.lock();
        if (null != INS) {
            readLock.unlock();
            return INS;
        }

        readLock.unlock();
        ReentrantReadWriteLock.WriteLock writeLock = INS_LOCK.writeLock();
        writeLock.lock();
        if (null != INS) {
            writeLock.unlock();
            return INS;
        }
        INS = new MessageUtils(token, encodingAesKey, appID);
        writeLock.unlock();
        return INS;
    }

    /**
     * <p>加密消息</p>
     *
     * @param msg       消息实体
     * @param timeStamp 时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce     随机串，可以自己生成，也可以用URL参数的nonce
     */
    public String encryptMessage(BaseMessage msg, String timeStamp, String nonce)
        throws AesException {
        if (null == msg || StringUtils.isBlank(timeStamp) || StringUtils.isBlank(nonce)
            || null == enDeCrypter) {
            return null;
        }

        return enDeCrypter.encryptMsg(msg.toString(), timeStamp, nonce);
    }

    /**
     * <p>解密消息，如无加密则解析消息</p>
     *
     * @param msg 公众平台推送的消息
     * @return 消息实体
     */
    public BaseMessage decryptAndValidationMessage(EncryptMessage msg) throws AesException {
        if (null == msg || StringUtils.isBlank(msg.getNonce()) || StringUtils
            .isBlank(msg.getTimeStamp()) || StringUtils.isBlank(msg.getSignature())) {
            return null;
        }

        String decodedMsg = enDeCrypter
            .decryptMsg(msg.getSignature(), msg.getTimeStamp(), msg.getNonce(), msg.toString());
        if (StringUtils.isBlank(decodedMsg)) {
            return null;
        }

        return parseMessage(decodedMsg);
    }

    /**
     * 自动解析消息为实体
     *
     * @param msg 消息流
     * @return
     */
    public BaseMessage parseMessage(InputStream msg) {
        if (null == msg) {
            return null;
        }

        MessageParser messageParser = new MessageSaxParser();
        if (!messageParser.parse(msg)) {
            return null;
        }
        return messageParser.getMessage();
    }

    /**
     * 自动解析消息为实体
     *
     * @param msg 消息流
     * @return
     */
    public BaseMessage parseMessage(String msg) {
        if (null == msg) {
            return null;
        }

        MessageParser messageParser = new MessageSaxParser();
        if (!messageParser.parse(msg)) {
            return null;
        }
        return messageParser.getMessage();
    }

}
