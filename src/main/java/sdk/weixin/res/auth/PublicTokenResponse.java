package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * 公众号token返回
 *
 * @author work
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.PublicTokenRequest
 * @since 1.0
 */
public class PublicTokenResponse extends CommonResponse {
    private String accessToken;
    private Integer expiresIn;

    public PublicTokenResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
