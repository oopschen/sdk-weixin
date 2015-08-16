package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>加密的消息</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class EncryptMessage extends BaseMessage {
    private String encryptMessage;
    // 发送专用
    private String signature;
    private String timeStamp;
    private String nonce;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptMessage() {
        return encryptMessage;
    }

    public void setEncryptMessage(String encryptMessage) {
        this.encryptMessage = encryptMessage;
    }

    @Override protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            document = createDoc();
        }

        if (null == document) {
            return null;
        }

        if (!StringUtils.isBlank(encryptMessage)) {
            Element ele = document.createElement("Encrypt");
            ele.appendChild(document.createCDATASection(encryptMessage));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(signature)) {
            Element ele = document.createElement("MsgSignature");
            ele.appendChild(document.createCDATASection(signature));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(timeStamp)) {
            Element ele = document.createElement("TimeStamp");
            ele.appendChild(document.createTextNode(timeStamp));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(nonce)) {
            Element ele = document.createElement("Nonce");
            ele.appendChild(document.createTextNode(nonce));
            append2Root(document, ele);
        }
        return document;
    }

}
