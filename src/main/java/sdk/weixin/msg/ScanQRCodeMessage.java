package sdk.weixin.msg;

/**
 * <p>扫描二维码事件</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class ScanQRCodeMessage extends BaseMessage {
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
