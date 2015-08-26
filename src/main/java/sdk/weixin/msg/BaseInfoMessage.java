package sdk.weixin.msg;

/**
 * info 类型的消息基类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseInfoMessage extends BaseMessage {
    protected String appID;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }
}
