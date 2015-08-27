package sdk.weixin.req.customer;

/**
 * 客户文本消息实例
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 * @see CustomerTextMessageRequest
 */
public class CustomerText {
    private String content;

    public CustomerText() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
