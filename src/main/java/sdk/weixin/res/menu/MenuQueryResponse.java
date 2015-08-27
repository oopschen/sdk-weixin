package sdk.weixin.res.menu;

/**
 * menu response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.menu.MenuQueryRequest
 * @since 1.0
 */
public class MenuQueryResponse {
    private Menu menu;

    public MenuQueryResponse() {
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
