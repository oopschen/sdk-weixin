package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * authCode response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AuthCodeRequest
 * @since 1.0
 */
public class AuthCodeResponse extends CommonResponse {
    private AuthInfo authorizationInfo;

    public AuthCodeResponse() {
    }

    public AuthInfo getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(AuthInfo authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }

}
