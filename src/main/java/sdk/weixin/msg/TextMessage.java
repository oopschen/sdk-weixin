package sdk.weixin.msg;

/**
 * <p>文本消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class TextMessage extends PlainMessage {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
