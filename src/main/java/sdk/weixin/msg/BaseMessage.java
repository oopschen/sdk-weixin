package sdk.weixin.msg;

import java.util.Date;

/**
 * <p>消息基类</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public abstract class BaseMessage {
    protected String toUserName;
    protected String fromUserName;
    protected String msgType;
    protected Date createTime;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
