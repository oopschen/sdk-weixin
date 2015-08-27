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
    private String preAuthCode;
    private Integer expiresIn;

    public PreAuthResponse() {
    }

    public String getPreAuthCode() {
        return preAuthCode;
    }

    public void setPreAuthCode(String preAuthCode) {
        this.preAuthCode = preAuthCode;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
