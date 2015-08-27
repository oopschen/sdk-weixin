package sdk.weixin.res.auth;

/**
 * accessRefresh response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AccessRefreshRequest
 * @since 1.0
 */
public class AccessRefreshResponse {
    private String authorizerAccessToken;
    private String authorizerTefreshToken;
    private Integer expiresIn;

    public AccessRefreshResponse() {
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public String getAuthorizerTefreshToken() {
        return authorizerTefreshToken;
    }

    public void setAuthorizerTefreshToken(String authorizerTefreshToken) {
        this.authorizerTefreshToken = authorizerTefreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
