package sdk.weixin.msg;

/**
 * <p>链接消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class LinkMessage extends PlainMessage {
    private String title;
    private String description;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
