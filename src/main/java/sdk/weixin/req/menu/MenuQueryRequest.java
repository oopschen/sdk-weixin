package sdk.weixin.req.menu;

import sdk.weixin.req.BaseRequest;

/**
 * query menu button request
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.menu.MenuQueryResponse
 * @since 1.0
 */
public class MenuQueryRequest extends BaseRequest {
    public MenuQueryRequest() {
    }

    public MenuQueryRequest(String accessToken) {
        setRequestURI("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken);
    }

}
