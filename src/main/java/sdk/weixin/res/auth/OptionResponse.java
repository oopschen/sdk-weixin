package sdk.weixin.res.auth;

import sdk.weixin.res.CommonResponse;

/**
 * option response
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.req.auth.OptionRequest
 * @since 1.0
 */
public class OptionResponse extends CommonResponse {
    private String authorizerAppid;
    private String optionName;
    private String optionValue;

    public OptionResponse() {
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
