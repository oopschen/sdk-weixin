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
    private String componentAppid;
    private String componentAppsecret;
    private String componentVerifyTicket;


    public AccessTokenRequest() {
        super();
        setMethod(RequestMethod.POST);
        setRequestURI("https://api.weixin.qq.com/cgi-bin/component/api_component_token");
    }

    public String getComponentAppid() {
        return componentAppid;
    }

    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    public String getComponentAppsecret() {
        return componentAppsecret;
    }

    public void setComponentAppsecret(String componentAppsecret) {
        this.componentAppsecret = componentAppsecret;
    }

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }
}
