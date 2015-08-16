package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Date;

/**
 * <p>消息基类</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public abstract class BaseMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMessage.class);
    protected String toUserName;
    protected String fromUserName;
    protected Date createTime;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Date getCreateTime() {
        return null == createTime ? null : new Date(createTime.getTime());
    }

    public void setCreateTime(Date createTime) {
        this.createTime = null == createTime ? null : new Date(createTime.getTime());
    }

    /**
     * 实现实体转成xml
     *
     * @return dom 对象
     */
    protected Document toElements() {
        Document document = createDoc();
        if (null == document) {
            return null;
        }

        if (!StringUtils.isBlank(toUserName)) {
            Element ele = document.createElement("ToUserName");
            ele.appendChild(document.createCDATASection(toUserName));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(fromUserName)) {
            Element ele = document.createElement("FromUserName");
            ele.appendChild(document.createCDATASection(fromUserName));
            append2Root(document, ele);
        }

        if (null != createTime) {
            Element ele = document.createElement("CreateTime");
            ele.appendChild(document.createTextNode(String.valueOf(createTime.getTime())));
            append2Root(document, ele);
        }
        return document;
    }

    protected void append2Root(Document document, Element element) {
        Node root = document.getFirstChild();
        if (null == root) {
            root = document.createElement("xml");
            document.appendChild(root);
        }
        root.appendChild(element);
    }

    protected void appendMsgType(Document document, String msgType) {
        if (StringUtils.isBlank(msgType)) {
            return;
        }

        Element element = document.createElement("MsgType");
        element.appendChild(document.createCDATASection(msgType));
        append2Root(document, element);
    }

    protected Document createDoc() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            LOGGER.error("create doc", e);
        }
        return null;
    }

    @Override public String toString() {
        Document document = this.toElements();
        if (null != document) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            try {
                Transformer transformer = transformerFactory.newTransformer();
                StringWriter stringWriter = new StringWriter();
                transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
                return stringWriter.toString();
            } catch (TransformerConfigurationException e) {
                LOGGER.error("toXML", e);

            } catch (TransformerException e) {
                LOGGER.error("toXML", e);
            }

            return StringUtils.EMPTY;
        }
        return super.toString();
    }

}
