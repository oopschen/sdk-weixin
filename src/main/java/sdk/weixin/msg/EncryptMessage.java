package sdk.weixin.msg;

/**
 * <p>加密的消息</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class EncryptMessage extends BaseMessage {
    private String encryptMessage;

    public String getEncryptMessage() {
        return encryptMessage;
    }

    public void setEncryptMessage(String encryptMessage) {
        this.encryptMessage = encryptMessage;
    }
}
