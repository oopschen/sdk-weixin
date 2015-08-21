package sdk.weixin.msg;

/**
 * info 类型的消息基类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseInfoMessage extends BaseMessage {
    protected String typ;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
