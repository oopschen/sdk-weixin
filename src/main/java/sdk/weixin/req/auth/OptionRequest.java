package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * option request
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 * @see sdk.weixin.res.auth.OptionResponse
 */
public class OptionRequest extends BaseRequest {
    private String componentAppid;
    private String authorizerAppid;
    private String optionName;

    public OptionRequest(String accessToken) {
        super();
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/ api_get_authorizer_option?component_access_token="
                + accessToken);
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
