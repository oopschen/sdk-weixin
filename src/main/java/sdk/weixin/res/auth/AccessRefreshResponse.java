package sdk.weixin.res.auth;

/**
 * accessRefresh response
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AccessRefreshResponse {
    private String authorizer_access_token;
    private String authorizer_refresh_token;
    private Integer expires_in;

    public AccessRefreshResponse() {
    }

    public String getAuthorizer_access_token() {
        return authorizer_access_token;
    }

    public void setAuthorizer_access_token(String authorizer_access_token) {
        this.authorizer_access_token = authorizer_access_token;
    }

    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
