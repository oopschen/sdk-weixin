package sdk.weixin.msg;

import sdk.weixin.msg.BaseInfoMessage;

/**
 * component_verify_ticket
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class ComponentVerificationTicketMessage extends BaseInfoMessage {
    private String appID;
    private String componentVerifyTicket;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }
}