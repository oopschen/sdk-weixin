package sdk.weixin.res.menu;

import sdk.weixin.res.CommonResponse;

/**
 * menu response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.menu.MenuQueryRequest
 * @since 1.0
 */
public class MenuQueryResponse extends CommonResponse {
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
