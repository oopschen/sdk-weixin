package sdk.weixin.req.auth;

import sdk.weixin.req.BaseFormRequest;

/**
 * 网页授权刷新类
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.WebAuthRefreshAccessTokenResponse
 * @since 1.0
 */
public class WebAuthRefreshAccessTokenRequest extends BaseFormRequest {
    public WebAuthRefreshAccessTokenRequest(String appID, String refreshToken, String componentID,
        String componentAccessToken) {
        super();
        StringBuilder uri = new StringBuilder(
            "https://api.weixin.qq.com/sns/oauth2/component/refresh_token?appid=");
        uri.append(appID);
        uri.append("&grant_type=refresh_token");
        uri.append("&component_appid=");
        uri.append(componentID);
        uri.append("&component_access_token=");
        uri.append(componentAccessToken);
        uri.append("&refresh_token=");
        uri.append(refreshToken);
        setRequestURI(uri.toString());
    }
}
