package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * get auth account info
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.AuthAccInfoResponse
 * @since 1.0
 */
public class AuthAccInfoRequest extends BaseRequest {
    private String componentAppid;
    private String authorizerAppid;

    public AuthAccInfoRequest() {
    }

    public AuthAccInfoRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token="
                + accessToken);
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }
}
