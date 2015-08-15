package sdk.weixin.msg.parser;

import sdk.weixin.msg.BaseMessage;

import java.io.InputStream;

/**
 * <p>sax 方式的消息解析器</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public interface MessageParser {
    /**
     * <p>是否加密的消息</p>
     *
     * @return true | false
     */
    boolean isEncryptMessage();

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
