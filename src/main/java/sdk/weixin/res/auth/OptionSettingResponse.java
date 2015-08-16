package sdk.weixin.res.auth;

/**
 * option setting reponse
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class OptionSettingResponse {
    private String errcode;
    private String errmsg;

    public OptionSettingResponse() {
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
