package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

import java.util.List;

/**
 * authCode response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.AuthCodeRequest
 * @since 1.0
 */
public class AuthCodeResponse extends CommonResponse {
    private AuthInfo authorizationInfo;
    private List<FuncCategory> funcInfo;

    public AuthCodeResponse() {
    }

    public AuthInfo getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(AuthInfo authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }

    public List<FuncCategory> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncCategory> funcInfo) {
        this.funcInfo = funcInfo;
    }
}
