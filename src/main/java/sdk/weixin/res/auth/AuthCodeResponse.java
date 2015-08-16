package sdk.weixin.res.auth;

import java.util.List;

/**
 * authCode response
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthCodeResponse {
    private AuthInfo authorization_info;
    private List<FuncInfo> func_info;

    public AuthCodeResponse() {
    }

    public AuthInfo getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(AuthInfo authorization_info) {
        this.authorization_info = authorization_info;
    }

    public List<FuncInfo> getFunc_info() {
        return func_info;
    }

    public void setFunc_info(List<FuncInfo> func_info) {
        this.func_info = func_info;
    }
}
