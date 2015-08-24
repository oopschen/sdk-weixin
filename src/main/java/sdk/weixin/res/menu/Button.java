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
    protected List<Button> sub_button;
    protected String type;
    protected String name;
    protected String key;
    protected String url;
    protected String media_id;

    public Button() {
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
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

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
