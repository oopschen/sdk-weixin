package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * authCode request
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.AuthCodeResponse
 * @since 1.0
 */
public class AuthCodeRequest extends BaseRequest {
    private String componentAppid;
    private String authorizationCode;

    public AuthCodeRequest() {
    }

    public AuthCodeRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="
                + accessToken);
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }
}
