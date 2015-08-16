package sdk.weixin.res.auth;

/**
 * accessToken response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AccessTokenRequest
 * @since 1.0
 */
public class AccessTokenResponse {
    private String component_access_token;
    private Integer expires_in;

    public AccessTokenResponse() {
    }

    public String getComponent_access_token() {
        return component_access_token;
    }

    public void setComponent_access_token(String component_access_token) {
        this.component_access_token = component_access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
