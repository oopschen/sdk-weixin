package sdk.weixin.res.auth;

/**
 * auth account info response
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthAccInfoResponse {
    private AuthAccInfo authorizer_info;
    private String qrcode_url;
    private AuthAccAuthInfo authorization_info;

    public AuthAccInfoResponse() {
    }

    public AuthAccInfo getAuthorizer_info() {
        return authorizer_info;
    }

    public void setAuthorizer_info(AuthAccInfo authorizer_info) {
        this.authorizer_info = authorizer_info;
    }

    public String getQrcode_url() {
        return qrcode_url;
    }

    public void setQrcode_url(String qrcode_url) {
        this.qrcode_url = qrcode_url;
    }

    public AuthAccAuthInfo getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(AuthAccAuthInfo authorization_info) {
        this.authorization_info = authorization_info;
    }
}
