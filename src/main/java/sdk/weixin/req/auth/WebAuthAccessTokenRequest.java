package sdk.weixin.req.auth;

import sdk.weixin.req.BaseFormRequest;

/**
 * 网页授权获取accessToken
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.WebAuthAccessTokenResponse
 * @since 1.0
 */
public class WebAuthAccessTokenRequest extends BaseFormRequest {
    public WebAuthAccessTokenRequest(String appID, String code, String authorizationCode,
        String componentID, String componentAccessToken) {
        super();
        StringBuilder uri =
            new StringBuilder("https://api.weixin.qq.com/sns/oauth2/component/access_token?appid=");
        uri.append(appID);
        uri.append("code=");
        uri.append(code);
        uri.append("grant_type=");
        uri.append(authorizationCode);
        uri.append("component_appid=");
        uri.append(componentID);
        uri.append("component_access_token=");
        uri.append(componentAccessToken);
        setRequestURI(uri.toString());
    }
}
