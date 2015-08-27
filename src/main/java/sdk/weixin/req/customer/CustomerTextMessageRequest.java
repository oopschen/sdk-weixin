package sdk.weixin.req.customer;

/**
 * 返送文本客服消息请求
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class CustomerTextMessageRequest extends CustomerBaseMessage {
    private CustomerText text;

    public CustomerTextMessageRequest(String accessToken) {
        super(accessToken);
    }


    public CustomerText getText() {
        return text;
    }

    public void setText(CustomerText text) {
        this.text = text;
    }
}
