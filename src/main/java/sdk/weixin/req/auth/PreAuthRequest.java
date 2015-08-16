package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;
import sdk.weixin.res.auth.PreAuthResponse;

/**
 * 预授权请求
 *
 * @author ray
 * @version %I%, %G%
 * @see PreAuthResponse
 * @since 1.0
 */
public class PreAuthRequest extends BaseRequest {
    private String component_appid;

    public PreAuthRequest() {

    }

    public PreAuthRequest(String accessToken) {
        super();
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="
                + accessToken);
    }

    public String getComponent_appid() {

        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }
}
