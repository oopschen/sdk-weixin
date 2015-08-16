package sdk.weixin.req.auth;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * accessToken请求
 *
 * @author ray
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.AccessTokenResponse
 * @since 1.0
 */
public class AccessTokenRequest extends BaseRequest {
    private String component_appid;
    private String component_appsecret;
    private String component_verify_ticket;


    public AccessTokenRequest() {
        super();
        setMethod(RequestMethod.POST);
        setRequestURI("https://api.weixin.qq.com/cgi-bin/component/api_component_token");
    }

    public String getComponent_appid() {

        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getComponent_appsecret() {
        return component_appsecret;
    }

    public void setComponent_appsecret(String component_appsecret) {
        this.component_appsecret = component_appsecret;
    }

    public String getComponent_verify_ticket() {
        return component_verify_ticket;
    }

    public void setComponent_verify_ticket(String component_verify_ticket) {
        this.component_verify_ticket = component_verify_ticket;
    }
}
