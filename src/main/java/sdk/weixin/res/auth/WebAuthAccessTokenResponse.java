package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * 网页授权返回
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.WebAuthAccessTokenRequest
 * @since 1.0
 */
public class WebAuthAccessTokenResponse extends CommonResponse {
    private String accessToken;
    private String refreshToken;
    private String openid;
    private String scope;
    private Integer expiresIn;

    public WebAuthAccessTokenResponse() {
        super();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
