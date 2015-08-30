package sdk.weixin.helper;

import org.apache.commons.lang3.StringUtils;
import sdk.weixin.req.auth.WebAuthScope;

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

    public static final String webAuthURI(String appID, String redirectURI, String state,
        String componentID, WebAuthScope... scopes) {
        StringBuilder uri =
            new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        uri.append(appID);
        uri.append("&redirect_uri=");
        uri.append(redirectURI);
        uri.append("&response_type=code&scope=");
        if (null != scopes && 0 < scopes.length) {
            uri.append(StringUtils.join(scopes, ","));
        }
        uri.append("&state=");
        if (StringUtils.isNotBlank(state)) {
            uri.append(state);
        }
        uri.append("&component_appid=");
        uri.append(componentID);
        uri.append("#wechat_redirect");
        return uri.toString();

    }
}
