package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * accessRefresh request
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AccessRefreshRequest extends BaseRequest {
    private String component_appid;
    private String authorizer_appid;
    private String authorizer_refresh_token;

    public AccessRefreshRequest() {
    }

    public AccessRefreshRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https:// api.weixin.qq.com /cgi-bin/component/api_authorizer_token?component_access_token="
                + accessToken);
    }

    public String getComponent_appid() {

        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }
}
