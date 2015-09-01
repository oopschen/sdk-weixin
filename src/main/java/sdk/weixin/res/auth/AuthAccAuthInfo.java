package sdk.weixin.res.auth;

import java.util.List;

/**
 * auth account auth info
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthAccAuthInfo {
    private String authorizerAppid;
    private List<FuncCategory> funcInfo;

    public AuthAccAuthInfo() {
    }

    public List<FuncCategory> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncCategory> funcInfo) {
        this.funcInfo = funcInfo;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }
}
