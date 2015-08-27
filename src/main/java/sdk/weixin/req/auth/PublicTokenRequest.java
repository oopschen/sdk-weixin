package sdk.weixin.req.auth;

import sdk.weixin.req.BaseFormRequest;

/**
 * 公众帐号获取token
 *
 * @author work
 * @version %I%, %G%
 * @see sdk.weixin.res.auth.PublicTokenResponse
 * @since 1.0
 */
public class PublicTokenRequest extends BaseFormRequest {
    private static final String GRANT_TYPE = "grant_type";
    private static final String APP_ID = "appid";
    private static final String APP_SECRET = "secret";

    public String getGrant_type() {
        return getParams().get(GRANT_TYPE);
    }

    public void setGrant_type(String grant_type) {
        addParam(GRANT_TYPE, grant_type);
    }

    public String getAppid() {
        return getParams().get(APP_ID);
    }

    public void setAppid(String appid) {
        addParam(APP_ID, appid);
    }

    public String getSecret() {
        return getParams().get(APP_SECRET);
    }

    public void setSecret(String secret) {
        addParam(APP_SECRET, secret);
    }
}
