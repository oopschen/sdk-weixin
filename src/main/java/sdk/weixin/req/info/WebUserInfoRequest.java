package sdk.weixin.req.info;

import sdk.weixin.req.BaseRequest;

/**
 * 网页授权用户信息拉取请求
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.info.WebUserInfoResponse
 * @since 1.0
 */
public class WebUserInfoRequest extends BaseRequest {
    public WebUserInfoRequest(String accessToken, String openID, Lang lang) {
        super();
        StringBuilder uri =
            new StringBuilder("https://api.weixin.qq.com/sns/userinfo?access_token=");
        uri.append(accessToken);
        uri.append("openid=");
        uri.append(openID);
        uri.append("lang=");
        uri.append(null == lang ? Lang.ZH_CN.toString() : lang.toString());
        setRequestURI(uri.toString());
    }
}
