package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * auth account info response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AuthAccInfoRequest
 * @since 1.0
 */
public class AuthAccInfoResponse extends CommonResponse {
    private AuthAccInfo authorizerInfo;
    private String qrcodeUrl;
    private AuthAccAuthInfo authorizationInfo;

    public AuthAccInfoResponse() {
    }

    public AuthAccInfo getAuthorizerInfo() {
        return authorizerInfo;
    }

    public void setAuthorizerInfo(AuthAccInfo authorizerInfo) {
        this.authorizerInfo = authorizerInfo;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public AuthAccAuthInfo getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(AuthAccAuthInfo authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }
}
