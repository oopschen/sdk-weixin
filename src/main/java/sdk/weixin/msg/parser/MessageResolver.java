package sdk.weixin.msg.parser;

import sdk.weixin.msg.BaseMessage;

/**
 * 消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public interface MessageResolver {
    /**
     * 根据参数解析
     *
     * @param param 解析的参数
     * @return 消息对象
     */
    BaseMessage resolve(ResolveParam param);
}
