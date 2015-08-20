package sdk.weixin.msg;

/**
 * <p>已关注扫描二维码事件</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class ScanQRSubscribeMessage extends EventMessage {
    private String eventKey;
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
