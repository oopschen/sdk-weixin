package sdk.weixin.msg;

/**
 * component_verify_ticket
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class ComponentVerificationTicketMessage extends BaseInfoMessage {
    private String componentVerifyTicket;

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }
}
