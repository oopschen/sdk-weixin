package sdk.weixin.msg.parser.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import sdk.weixin.msg.*;
import sdk.weixin.msg.parser.MessageParser;
import sdk.weixin.msg.parser.SubscribeMessage;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
            Constants.ELE_CREATE_DATE, Constants.ELE_MSG_ID, Constants.ELE_MSG_TYPE,
            Constants.ELE_CONTENT, Constants.ELE_IMG_ID, Constants.ELE_IMG_URL,
            Constants.ELE_VOICE_FORMAT, Constants.ELE_VOICE_RECOGNITION, Constants.ELE_VIDEO_THUMB,
            Constants.ELE_LOC_LABEL, Constants.ELE_LOC_LAT, Constants.ELE_LOC_LONG,
            Constants.ELE_LOC_SCALE, Constants.ELE_LINK_DESC, Constants.ELE_LINK_TITLE,
            Constants.ELE_LINK_URL, Constants.ELE_EVT, Constants.ELE_QR_KEY,
            Constants.ELE_QR_TICKET, Constants.ELE_LOCU_LAT, Constants.ELE_LOCU_LONG,
            Constants.ELE_LOCU_PRECISION, Constants.ELE_ENCRYPT));
    private final Map<String, MessageTypeParser> MSG_TYPE2PARSER =
        Collections.unmodifiableMap(new HashMap<String, MessageTypeParser>() {
            {
                put("text", new TextMessageParser());
                put("image", new ImageMessageParser());
                put("voice", new VoiceMessageParser());
                put("video", new VideoMessageParser());
                put("shortvideo", new TinyVideoMessageParser());
                put("location", new LocationMessageParser());
                put("link", new LinkMessageParser());
                // event
                put("event", new EventMessageParser());
            }
        });

    private boolean isParseSuccess;
    private boolean goCapture;
    private String tagName;
    private String msgType;
    private BaseMessage message;
    private List<Element> elementList;
    private MessageTypeParser encryptTypeParser;

    public MessageSaxParser() {
        isParseSuccess = true;
        goCapture = false;
        elementList = new LinkedList<>();
        encryptTypeParser = new EncryptMessageParser();
    }

    public boolean parse(InputStream msg) {
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

        if (isParseSuccess) {
            if (CollectionUtils.isEmpty(elementList)) {
                isParseSuccess = false;

            } else if (StringUtils.isBlank(msgType)) {
                // check encrypt message
                message = encryptTypeParser.parse();

            } else {
                MessageTypeParser messageTypeParser = MSG_TYPE2PARSER.get(msgType);
                if (null == messageTypeParser) {
                    isParseSuccess = false;
                    LOGGER.error("message type not found: {}", msgType);
                } else {
                    message = messageTypeParser.parse();
                }

            }

        }

        return isParseSuccess;
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

        String value = String.valueOf(ch, start, length);
        // deal with msgType
        if (tagName.equals(Constants.ELE_MSG_TYPE)) {
            msgType = value.toLowerCase();
            return;
        }

        Element element = new Element(tagName, value);
        elementList.add(element);
    }

    @Override public void endElement(String uri, String localName, String qName)
        throws SAXException {
        tagName = null;
        goCapture = false;
    }

    /**
     * <p>元素内部表示</p>
     *
     * @author ray
     * @version %I%, %G%
     * @since 1.0
     */
    class Element {
        private String name;
        private String value;

        public Element(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }


    class Constants {
        // tag names
        public static final String ELE_TO_USER_NAME = "tousername";
        public static final String ELE_FROM_USER_NAME = "fromusername";
        public static final String ELE_CREATE_DATE = "createtime";
        public static final String ELE_MSG_TYPE = "msgtype";
        // plain
        public static final String ELE_MSG_ID = "msgid";
        // text
        public static final String ELE_CONTENT = "content";
        // image
        public static final String ELE_IMG_URL = "picurl";
        public static final String ELE_IMG_ID = "mediaid";

        // voice
        public static final String ELE_VOICE_FORMAT = "format";
        public static final String ELE_VOICE_RECOGNITION = "recognition";

        // video
        public static final String ELE_VIDEO_THUMB = "thumbmediaid";

        // location
        public static final String ELE_LOC_LAT = "location_x";
        public static final String ELE_LOC_LONG = "location_y";
        public static final String ELE_LOC_SCALE = "scale";
        public static final String ELE_LOC_LABEL = "label";

        // link
        public static final String ELE_LINK_URL = "url";
        public static final String ELE_LINK_DESC = "description";
        public static final String ELE_LINK_TITLE = "title";

        // event
        public static final String ELE_EVT = "event";

        // qr
        public static final String ELE_QR_KEY = "eventkey";
        public static final String ELE_QR_TICKET = "ticket";

        // location
        public static final String ELE_LOCU_LAT = "latitude";
        public static final String ELE_LOCU_LONG = "longitude";
        public static final String ELE_LOCU_PRECISION = "precision";

        // encrypt
        public static final String ELE_ENCRYPT = "encrypt";

    }


    abstract class MessageTypeParser {
        public BaseMessage parse() {
            if (CollectionUtils.isEmpty(elementList)) {
                return null;
            }

            initMessage(elementList);

            for (Element element : elementList) {
                switch (element.name) {
                    case Constants.ELE_TO_USER_NAME:
                        message.setToUserName(element.value);
                        break;
                    case Constants.ELE_FROM_USER_NAME:
                        message.setFromUserName(element.value);
                        break;
                    case Constants.ELE_CREATE_DATE:
                        try {
                            message.setCreateTime(new Date(Long.valueOf(element.value)));
                        } catch (NumberFormatException e) {
                            LOGGER.error("format date: val={}", element.value);
                        }
                        break;
                    case Constants.ELE_MSG_TYPE:
                        break;
                    case Constants.ELE_MSG_ID:
                        try {
                            ((PlainMessage) message).setMsgID(Long.valueOf(element.value));

                        } catch (NumberFormatException e) {
                            LOGGER.error("format message id: val={}", element.value);
                        }
                        break;
                    default:
                        parserElement(element);
                        break;

                }
            }

            return message;
        }

        abstract public void initMessage(List<Element> elementList);

        abstract public void parserElement(Element e);

    }


    class TextMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new TextMessage();
        }

        @Override public void parserElement(Element e) {
            ((TextMessage) message).setContent(e.value);

        }
    }


    class ImageMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new ImageMessage();
        }

        @Override public void parserElement(Element e) {
            ImageMessage msg = (ImageMessage) message;
            switch (e.name) {
                case Constants.ELE_IMG_ID:
                    msg.setMediaID(e.value);
                    break;
                case Constants.ELE_IMG_URL:
                    msg.setPicURL(e.value);
                    break;


            }

        }
    }


    class VoiceMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new VoiceMessage();
        }

        @Override public void parserElement(Element e) {
            VoiceMessage msg = (VoiceMessage) message;
            switch (e.name) {
                case Constants.ELE_VOICE_FORMAT:
                    msg.setFormat(e.value);
                    break;
                case Constants.ELE_IMG_ID:
                    msg.setMediaID(e.value);
                    break;
                case Constants.ELE_VOICE_RECOGNITION:
                    msg.setTransTextFromVoice(e.value);
                    break;
            }

        }
    }


    class VideoMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new VideoMessage(false);
        }

        @Override public void parserElement(Element e) {
            VideoMessage msg = (VideoMessage) message;
            switch (e.name) {
                case Constants.ELE_IMG_ID:
                    msg.setMediaID(e.value);
                    break;
                case Constants.ELE_VIDEO_THUMB:
                    msg.setThumbMediaID(e.value);
                    break;
            }
        }
    }


    class TinyVideoMessageParser extends VideoMessageParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new VideoMessage(true);
        }
    }


    class LocationMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new LocationMessage();
        }

        @Override public void parserElement(Element e) {
            LocationMessage msg = (LocationMessage) message;
            switch (e.name) {
                case Constants.ELE_LOC_LABEL:
                    msg.setLabel(e.value);
                    break;
                case Constants.ELE_LOC_SCALE:
                    msg.setScale(e.value);
                    break;
                case Constants.ELE_LOC_LAT:
                    msg.setLatitude(e.value);
                    break;
                case Constants.ELE_LOC_LONG:
                    msg.setLongitude(e.value);
                    break;
            }

        }
    }


    class LinkMessageParser extends MessageTypeParser {

        @Override public void initMessage(List<Element> elementList) {
            message = new LinkMessage();
        }

        @Override public void parserElement(Element e) {
            LinkMessage msg = (LinkMessage) message;
            switch (e.name) {
                case Constants.ELE_LINK_DESC:
                    msg.setDescription(e.value);
                    break;
                case Constants.ELE_LINK_URL:
                    msg.setUrl(e.value);
                    break;
                case Constants.ELE_LINK_TITLE:
                    msg.setTitle(e.value);
                    break;
            }
        }
    }


    class EventMessageParser extends MessageTypeParser {
        private static final String EVENT_KEY_PREFIX = "qrscene_";

        @Override public void initMessage(List<Element> elementList) {
            Element eventElement = CollectionUtils.find(elementList, new Predicate<Element>() {
                @Override public boolean evaluate(Element object) {
                    return Constants.ELE_EVT.equals(object.name);
                }
            });

            if (null == eventElement) {
                return;
            }

            // check subscribe | qc
            switch (eventElement.value.toLowerCase()) {
                case "subscribe":
                    Element eventKey = CollectionUtils.find(elementList, new Predicate<Element>() {
                        @Override public boolean evaluate(Element object) {
                            return Constants.ELE_QR_KEY.equals(object.name);
                        }
                    });

                    if (null == eventKey) {
                        // subscribe
                        message = new SubscribeMessage();

                        // set content
                        ((SubscribeMessage) message).setIsSubscribe(true);
                    } else {
                        // qr
                        message = new ScanQRCodeMessage();
                    }

                    break;
                case "unsubscribe":
                    message = new SubscribeMessage();
                    ((SubscribeMessage) message).setIsSubscribe(false);
                    break;
                case "scan":
                    message = new ScanQRSubscribeMessage();
                    break;
                case "location":
                    message = new LocationUploadMessage();
                    break;
                case "click":
                    message = new MenuMessage();
                    break;
            }
        }

        @Override public void parserElement(Element e) {
            if (message instanceof ScanQRSubscribeMessage) {
                parseScanQRSubElement(e);

            } else if (message instanceof ScanQRCodeMessage) {
                parseScanQRElement(e);

            } else if (message instanceof LocationUploadMessage) {
                parseLocationUploadElement(e);

            } else if (message instanceof MenuMessage) {
                parseMenuElement(e);
            }

        }

        private void parseMenuElement(Element e) {
            MenuMessage msg = (MenuMessage) message;
            switch (e.name) {
                case Constants.ELE_QR_KEY:
                    msg.setMenuKey(e.value);
                    break;
            }
        }

        private void parseLocationUploadElement(Element e) {
            LocationUploadMessage msg = (LocationUploadMessage) message;
            switch (e.name) {
                case Constants.ELE_LOCU_LAT:
                    msg.setLatitude(e.value);
                    break;
                case Constants.ELE_LOCU_LONG:
                    msg.setLongitude(e.value);
                    break;
                case Constants.ELE_LOCU_PRECISION:
                    msg.setPrecision(e.value);
                    break;
            }
        }

        private void parseScanQRElement(Element e) {
            ScanQRCodeMessage msg = (ScanQRCodeMessage) message;
            switch (e.name) {
                case Constants.ELE_QR_KEY:
                    // remove prefix qrscene_
                    int prefixPos = e.value.indexOf(EVENT_KEY_PREFIX);
                    if (-1 < prefixPos) {
                        msg.setEventKey(e.value.substring(prefixPos + EVENT_KEY_PREFIX.length()));

                    } else {
                        msg.setEventKey(e.value);

                    }
                    break;
                case Constants.ELE_QR_TICKET:
                    msg.setTicket(e.value);
                    break;

            }
        }

        private void parseScanQRSubElement(Element e) {
            ScanQRSubscribeMessage msg = (ScanQRSubscribeMessage) message;
            switch (e.name) {
                case Constants.ELE_QR_KEY:
                    msg.setEventKey(e.value);
                    break;
                case Constants.ELE_QR_TICKET:
                    msg.setTicket(e.value);
                    break;

            }
        }
    }


    class EncryptMessageParser extends MessageTypeParser {
        @Override public void initMessage(List<Element> elementList) {
            message = new EncryptMessage();
        }

        @Override public void parserElement(Element e) {
            EncryptMessage encryptMessage = (EncryptMessage) message;
            switch (e.name) {
                case Constants.ELE_ENCRYPT:
                    encryptMessage.setEncryptMessage(e.value);
                    break;
            }
        }
    }

}
