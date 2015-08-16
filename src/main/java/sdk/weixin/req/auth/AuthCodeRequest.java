package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * authCode request
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthCodeRequest extends BaseRequest {
    private String component_appid;
    private String authorization_code;

    public AuthCodeRequest() {
    }

    public AuthCodeRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="
                + accessToken);
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }
}
