package sdk.weixin.msg;

/**
 * 授权消息
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthMessage extends BaseInfoMessage {
    private String actionAppID;

    public String getActionAppID() {
        return actionAppID;
    }

    public void setActionAppID(String actionAppID) {
        this.actionAppID = actionAppID;
    }
}
