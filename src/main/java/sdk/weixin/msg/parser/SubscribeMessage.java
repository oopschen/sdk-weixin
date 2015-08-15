package sdk.weixin.msg.parser;

import sdk.weixin.msg.BaseMessage;

/**
 * <p>关注或取消事件消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class SubscribeMessage extends BaseMessage {
    private boolean isSubscribe;

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
}