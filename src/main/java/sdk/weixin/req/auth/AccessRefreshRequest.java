package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * accessRefresh request
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.AccessRefreshResponse
 * @since 1.0
 */
public class AccessRefreshRequest extends BaseRequest {
    private String componentAppid;
    private String authorizerAppid;
    private String authorizerRefreshToken;

    public AccessRefreshRequest() {
    }

    public AccessRefreshRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https:// api.weixin.qq.com /cgi-bin/component/api_authorizer_token?component_access_token="
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

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }
}
