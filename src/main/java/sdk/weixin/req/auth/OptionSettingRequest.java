package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * option setting request
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.CommonResponse
 * @since 1.0
 */
public class OptionSettingRequest extends BaseRequest {
    private String componentAppid;
    private String authorizerAppid;
    private String optionName;
    private String optionValue;

    public OptionSettingRequest() {
    }

    public OptionSettingRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/ api_set_authorizer_option?component_access_token="
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

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
