package sdk.weixin.msg.parser;

import sdk.weixin.msg.BaseMessage;

import java.io.InputStream;

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
     * <p>获取解析后的消息对象</p>
     *
     * @return instance of message
     */
    BaseMessage getMessage();
}
