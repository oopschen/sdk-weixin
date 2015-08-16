package sdk.weixin.res.auth;

/**
 * 预授权response
 *
 * @author ray*
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.PreAuthRequest
 * @since 1.0
 */
public class PreAuthResponse {
    private String pre_auth_code;
    private Integer expires_in;

    public PreAuthResponse() {
    }

    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
