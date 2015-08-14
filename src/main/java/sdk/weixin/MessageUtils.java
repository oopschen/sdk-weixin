package sdk.weixin;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import org.apache.commons.lang3.StringUtils;

import sdk.weixin.msg.BaseMessage;

/**
 * <p>消息工具类</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public abstract class MessageUtils {
    private MessageUtils() {
    }


    /**
     * <p>加密消息</p>
     *
     * @param msg            消息
     * @param token          公众平台上，开发者设置的token
     * @param encodingAesKey 公众平台上，开发者设置的EncodingAESKey
     * @param appID          公众平台appid
     * @param timeStamp      时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce          随机串，可以自己生成，也可以用URL参数的nonce
     */
    public static final String encryptMessage(String msg, String token, String encodingAesKey, String appID, String timeStamp, String nonce) throws AesException {
        WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appID);
        return pc.encryptMsg(msg, timeStamp, nonce);
    }

    /**
     * <p>解密消息，如无加密则解析消息</p>
     *
     * @param msg 公众平台推送的消息
     * @return 消息实体
     */
    public static final BaseMessage decryptAndValidationMessage(String msg) {
        if (StringUtils.isBlank(msg)) {
            return null;
        }

        // TODO
        return null;
    }
}
