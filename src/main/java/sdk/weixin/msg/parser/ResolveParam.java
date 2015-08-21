package sdk.weixin.msg.parser;

import sdk.weixin.msg.parser.xml.Element;

import java.util.List;

/**
 * 解析参数
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class ResolveParam {
    private String msgTyp;
    private String infoTyp;
    private boolean isEncrypt;
    private List<Element> elementList;

    public String getMsgTyp() {
        return msgTyp;
    }

    public void setMsgTyp(String msgTyp) {
        this.msgTyp = msgTyp;
    }

    public String getInfoTyp() {
        return infoTyp;
    }

    public void setInfoTyp(String infoTyp) {
        this.infoTyp = infoTyp;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }
}
