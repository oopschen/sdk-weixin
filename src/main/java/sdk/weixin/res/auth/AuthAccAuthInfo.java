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
    private String appid;
    private List<FuncCategory> funcInfo;

    public AuthAccAuthInfo() {
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public List<FuncCategory> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncCategory> funcInfo) {
        this.funcInfo = funcInfo;
    }
}
