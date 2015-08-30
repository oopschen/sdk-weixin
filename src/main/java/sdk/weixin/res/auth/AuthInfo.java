package sdk.weixin.res.auth;

import java.util.List;

/**
 * auth info
 *
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthInfo {
    private String authorizerAppid;
    private String authorizerAccessToken;
    private String authorizerRefreshToken;
    private Integer expiresIn;
    private List<FuncCategory> funcInfo;

    public AuthInfo() {
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public List<FuncCategory> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncCategory> funcInfo) {
        this.funcInfo = funcInfo;
    }
}
