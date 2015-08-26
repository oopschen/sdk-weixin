package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;

/**
 * 默认消息
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class DefaultMessage extends BaseMessage {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override public String toString() {
        return null == getMessage() ? StringUtils.EMPTY : getMessage();
    }
}
