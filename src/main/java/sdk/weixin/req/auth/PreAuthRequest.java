package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * 预授权请求
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.PreAuthResponse
 * @since 1.0
 */
public class PreAuthRequest extends BaseRequest {
    private String componentAppid;

    public PreAuthRequest(String accessToken) {
        super();
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="
                + accessToken);
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }
}
