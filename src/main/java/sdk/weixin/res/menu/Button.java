package sdk.weixin.res.menu;

import java.util.List;

/**
 * 菜单按钮基类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class Button {
    protected List<Button> subButton;
    protected String type;
    protected String name;
    protected String key;
    protected String url;
    protected String mediaId;

    public Button() {
    }

    public List<Button> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<Button> subButton) {
        this.subButton = subButton;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
