package sdk.weixin.msg;

/**
 * 事件消息基类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class EventMessage extends BaseMessage {
    protected String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
