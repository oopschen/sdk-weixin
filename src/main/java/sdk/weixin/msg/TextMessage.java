package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>文本消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class TextMessage extends PlainMessage {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            document = createDoc();
        }

        if (null == document) {
            return null;
        }

        appendMsgType(document, "text");

        if (!StringUtils.isBlank(content)) {
            Element ele = document.createElement("Content");
            ele.appendChild(document.createCDATASection(content));
            append2Root(document, ele);
        }

        return document;
    }
}
