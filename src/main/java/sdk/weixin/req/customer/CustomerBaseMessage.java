package sdk.weixin.req.customer;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * 客服消息基类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class CustomerBaseMessage extends BaseRequest {

    public static final String MSG_TYP_TEXT = "text";
    public static final String MSG_TYP_IMG = "image";
    public static final String MSG_TYP_VOICE = "voice";
    public static final String MSG_TYP_VIDEO = "video";
    public static final String MSG_TYP_MUSIC = "music";
    public static final String MSG_TYP_NEWS = "news";
    public static final String MSG_TYP_CARD = "wxcard";

    protected String touser;
    protected String msgtype;

    public CustomerBaseMessage(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(
            "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken);
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
