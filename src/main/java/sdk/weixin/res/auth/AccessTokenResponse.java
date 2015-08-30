package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * accessToken response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AccessTokenRequest
 * @since 1.0
 */
public class AccessTokenResponse extends CommonResponse {
    private String componentAccessToken;
    private Integer expiresIn;

    public AccessTokenResponse() {
    }

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
