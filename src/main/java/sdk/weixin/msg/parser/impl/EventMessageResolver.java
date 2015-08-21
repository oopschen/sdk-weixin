package sdk.weixin.msg.parser.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import sdk.weixin.msg.*;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 时间消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class EventMessageResolver extends BaseContentMessageResolver {
    private static final String EVENT_KEY_PREFIX = "qrscene_";

    @Override protected boolean initMessage(ResolveParam param) {
        Element eventElement =
            CollectionUtils.find(param.getElementList(), new Predicate<Element>() {
                @Override public boolean evaluate(Element object) {
                    return Constants.ELE_EVT.equals(object.getName());
                }
            });

        if (null == eventElement) {
            return false;
        }

        // check subscribe | qc
        boolean hasParsed = false;
        switch (eventElement.getValue().toLowerCase()) {
            case "subscribe":
                Element eventKey =
                    CollectionUtils.find(param.getElementList(), new Predicate<Element>() {
                        @Override public boolean evaluate(Element object) {
                            return Constants.ELE_QR_KEY.equals(object.getName());
                        }
                    });

                if (null == eventKey) {
                    // subscribe
                    SubscribeMessage msg = new SubscribeMessage();
                    msg.setIsSubscribe(true);
                    setMessage(msg);

                } else {
                    // qr
                    setMessage(new ScanQRCodeMessage());

                }
                hasParsed = true;
                break;

            case "unsubscribe":
                SubscribeMessage msg = new SubscribeMessage();
                msg.setIsSubscribe(false);
                setMessage(msg);
                hasParsed = true;
                break;

            case "scan":
                setMessage(new ScanQRSubscribeMessage());
                hasParsed = true;
                break;

            case "location":
                setMessage(new LocationUploadMessage());
                hasParsed = true;
                break;

            case "click":
                setMessage(new MenuMessage());
                hasParsed = true;
                break;

            default:
                break;
        }

        if (hasParsed) {
            castMessage(EventMessage.class).setEvent(eventElement.getValue());
        }

        return hasParsed;
    }

    @Override public boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        if (message instanceof ScanQRSubscribeMessage) {
            return parseScanQRSubElement(element);

        } else if (message instanceof ScanQRCodeMessage) {
            return parseScanQRElement(element);

        } else if (message instanceof LocationUploadMessage) {
            return parseLocationUploadElement(element);

        } else if (message instanceof MenuMessage) {
            return parseMenuElement(element);
        }

        return false;
    }

    private boolean parseMenuElement(Element e) {
        MenuMessage msg = castMessage(MenuMessage.class);
        switch (e.getName()) {
            case Constants.ELE_QR_KEY:
                msg.setMenuKey(e.getValue());
                return true;
            default:
                break;
        }

        return false;
    }

    private boolean parseLocationUploadElement(Element e) {
        LocationUploadMessage msg = castMessage(LocationUploadMessage.class);
        switch (e.getName()) {
            case Constants.ELE_LOCU_LAT:
                msg.setLatitude(e.getValue());
                return true;

            case Constants.ELE_LOCU_LONG:
                msg.setLongitude(e.getValue());
                return true;

            case Constants.ELE_LOCU_PRECISION:
                msg.setPrecision(e.getValue());
                return true;

            default:
                break;
        }
        return false;
    }

    private boolean parseScanQRElement(Element e) {
        ScanQRCodeMessage msg = castMessage(ScanQRCodeMessage.class);
        switch (e.getName()) {
            case Constants.ELE_QR_KEY:
                // remove prefix qrscene_
                String val = e.getValue();
                int prefixPos = val.indexOf(EVENT_KEY_PREFIX);
                if (-1 < prefixPos) {
                    msg.setEventKey(val.substring(prefixPos + EVENT_KEY_PREFIX.length()));

                } else {
                    msg.setEventKey(val);

                }
                return true;

            case Constants.ELE_QR_TICKET:
                msg.setTicket(e.getValue());
                return true;

            default:
                break;
        }
        return false;
    }

    private boolean parseScanQRSubElement(Element e) {
        ScanQRSubscribeMessage msg = castMessage(ScanQRSubscribeMessage.class);
        switch (e.getName()) {
            case Constants.ELE_QR_KEY:
                msg.setEventKey(e.getValue());
                return true;

            case Constants.ELE_QR_TICKET:
                msg.setTicket(e.getValue());
                return true;

            default:
                break;

        }

        return false;
    }
}
