package sdk.weixin.res;

/**
 * common response
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class CommonResponse {
    protected Integer errcode;
    private String errmsg;

    public CommonResponse() {
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
