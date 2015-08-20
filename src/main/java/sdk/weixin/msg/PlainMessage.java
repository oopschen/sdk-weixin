package sdk.weixin.msg;

/**
 * <p>普通消息</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public abstract class PlainMessage extends BaseContentMessage {
    protected Long msgID;

    public Long getMsgID() {
        return msgID;
    }

    public void setMsgID(Long msgID) {
        this.msgID = msgID;
    }

}
