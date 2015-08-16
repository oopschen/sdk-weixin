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
    private List<FuncCategory> func_info;

    public AuthAccAuthInfo() {
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public List<FuncCategory> getFunc_info() {
        return func_info;
    }

    public void setFunc_info(List<FuncCategory> func_info) {
        this.func_info = func_info;
    }
}