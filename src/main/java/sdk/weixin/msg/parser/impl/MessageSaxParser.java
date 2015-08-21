package sdk.weixin.msg.parser.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import sdk.weixin.msg.BaseMessage;
import sdk.weixin.msg.parser.*;
import sdk.weixin.msg.parser.xml.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>sax 方式的消息解析器</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class MessageSaxParser extends DefaultHandler implements MessageParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSaxParser.class);
    private static final List<String> CAPTURE_ELEMENT_NAMES_LOWER_CASE = Collections
        .unmodifiableList(Arrays.asList(Constants.ELE_TO_USER_NAME, Constants.ELE_FROM_USER_NAME,
            Constants.ELE_CREATE_DATE, Constants.ELE_MSG_ID, Constants.ELE_MSG_TYPE_CONTENT,
            Constants.ELE_CONTENT, Constants.ELE_IMG_ID, Constants.ELE_IMG_URL,
            Constants.ELE_VOICE_FORMAT, Constants.ELE_VOICE_RECOGNITION, Constants.ELE_VIDEO_THUMB,
            Constants.ELE_LOC_LABEL, Constants.ELE_LOC_LAT, Constants.ELE_LOC_LONG,
            Constants.ELE_LOC_SCALE, Constants.ELE_LINK_DESC, Constants.ELE_LINK_TITLE,
            Constants.ELE_LINK_URL, Constants.ELE_EVT, Constants.ELE_QR_KEY,
            Constants.ELE_QR_TICKET, Constants.ELE_LOCU_LAT, Constants.ELE_LOCU_LONG,
            Constants.ELE_LOCU_PRECISION, Constants.ELE_ENCRYPT, Constants.ELE_ENCRYPT_NONCE,
            Constants.ELE_ENCRYPT_TS, Constants.ELE_ENCRYPT_SIGNATURE, Constants.ELE_MSG_TYPE_INFO,
            Constants.ELE_COMP_APPID, Constants.ELE_COMP_TICKET));


    private boolean goCapture;
    private ResolveParam resolveParam;
    private String tagName;
    private BaseMessage message;

    public MessageSaxParser() {
        goCapture = false;
        resolveParam = new ResolveParam();
        resolveParam.setElementList(new LinkedList<Element>());
    }

    public boolean parse(InputStream msg) {
        boolean isParseSuccess = true;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(false);
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(this);
            InputSource inputSource = new InputSource();
            inputSource.setByteStream(msg);
            xmlReader.parse(inputSource);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.error("parser message", e);
            isParseSuccess = false;
        }

        if (!isParseSuccess) {
            return false;
        }

        if (CollectionUtils.isEmpty(resolveParam.getElementList())) {
            return false;

        }

        MessageResolver messageResolver = MessageResolverHelper.getMessageResolver(resolveParam);
        message = messageResolver.resolve(resolveParam);

        return null != message;
    }

    @Override public boolean parse(String message) {
        return parse(message, null);
    }

    @Override public boolean parse(String message, Charset charset) {
        if (StringUtils.isBlank(message)) {
            return false;
        }
        Charset ct = null != charset ? charset : StandardCharsets.UTF_8;
        return parse(new ByteArrayInputStream(message.getBytes(ct)));
    }

    public BaseMessage getMessage() {
        return message;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        tagName = qName.toLowerCase();
        goCapture = CAPTURE_ELEMENT_NAMES_LOWER_CASE.contains(tagName);
    }

    @Override public void characters(char[] ch, int start, int length) throws SAXException {
        if (!goCapture || 1 > length) {
            return;
        }

        String value = StringUtils.trimToNull(String.valueOf(ch, start, length));
        if (null == value) {
            return;
        }

        // deal with msgType
        switch (tagName) {
            case Constants.ELE_MSG_TYPE_CONTENT:
                resolveParam.setMsgTyp(value);
                return;

            case Constants.ELE_MSG_TYPE_INFO:
                resolveParam.setInfoTyp(value);
                return;

            case Constants.ELE_ENCRYPT:
                resolveParam.setIsEncrypt(true);

            default:
                break;
        }

        Element element = new Element(tagName, value);
        resolveParam.getElementList().add(element);
    }

    @Override public void endElement(String uri, String localName, String qName)
        throws SAXException {
        tagName = null;
        goCapture = false;
    }

}
