package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * option request
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class OptionRequest extends BaseRequest {
    private String component_appid;
    private String authorizer_appid;
    private String option_name;

    public OptionRequest() {
    }

    public OptionRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/component/ api_get_authorizer_option?component_access_token="
                + accessToken);
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }
}
