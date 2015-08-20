package sdk.weixin.msg.parser;

import sdk.weixin.msg.BaseContentMessage;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * <p>sax 方式的消息解析器</p>
 *
 * @author chenl
 * @version %I%, %G%
 */
public interface MessageParser {
    /**
     * <p>解析必须调用的函数</p>
     *
     * @param message 消息内容
     * @return true | false
     */
    boolean parse(InputStream message);

    /**
     * 解析必须调用的函数, 同{@link MessageParser#parse(InputStream)}
     *
     * @param message 消息内容, encoded in {@link java.nio.charset.StandardCharsets#UTF_8}
     * @return true | false
     */
    boolean parse(String message);

    /**
     * 解析必须调用的函数, 同{@link MessageParser#parse(InputStream)}
     *
     * @param message 消息内容
     * @param charset charset
     *
     * @return true | false
     */
    boolean parse(String message, Charset charset);


    /**
     * <p>获取解析后的消息对象</p>
     *
     * @return instance of message
     */
    BaseContentMessage getMessage();
}
