package sdk.weixin.msg;

/**
 * <p>自定义菜单事件</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class MenuMessage extends EventMessage {
    private String menuKey;

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }
}
