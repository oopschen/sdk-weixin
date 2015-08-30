package sdk.weixin.helper;

/**
 * 跳转相关的帮助类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class URIHelpers {
    private URIHelpers() {
    }

    /**
     * 预授权掉转url
     *
     * @param componentID 第三方平台id
     * @param preAuthCode 预授权码
     * @param redirectURI 授权后跳转的uri
     * @return
     */
    public static final String preAuthURI(String componentID, String preAuthCode,
        String redirectURI) {
        StringBuilder preAuthURL = new StringBuilder(
            "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=");
        preAuthURL.append(componentID);
        preAuthURL.append("&pre_auth_code=");
        preAuthURL.append(preAuthCode);
        preAuthURL.append("&redirect_uri=");
        preAuthURL.append(redirectURI);

        return preAuthURL.toString();
    }
}
