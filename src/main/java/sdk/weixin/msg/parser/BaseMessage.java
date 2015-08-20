package sdk.weixin.msg.parser;

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
 * 消息基类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMessage.class);

    protected Date createTime;
    protected Document document;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    protected Document toElements() {
        Document document = getDocument();
        if (null == document) {
            return null;
        }

        if (null != createTime) {
            Element ele = document.createElement("CreateTime");
            ele.appendChild(document.createTextNode(String.valueOf(createTime.getTime())));
            append2Root(document, ele);
        }

        return document;

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

    protected Document getDocument() {
        if (null == document) {
            document = createDoc();
        }
        return document;
    }
}
