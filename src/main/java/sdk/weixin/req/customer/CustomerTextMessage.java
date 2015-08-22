package sdk.weixin.req.customer;

/**
 * 客服消息接口
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class CustomerTextMessage extends CustomerBaseMessage {
    private CustomerText text;

    public CustomerTextMessage(String accessToken) {
        super(accessToken);
    }


    public CustomerText getText() {
        return text;
    }

    public void setText(CustomerText text) {
        this.text = text;
    }
}
