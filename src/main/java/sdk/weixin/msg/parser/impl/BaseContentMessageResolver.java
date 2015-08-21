package sdk.weixin.msg.parser.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sdk.weixin.msg.BaseContentMessage;
import sdk.weixin.msg.PlainMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.xml.Element;

/**
 * base content message resolver
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseContentMessageResolver extends BaseMessageResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseContentMessageResolver.class);

    protected boolean parseExtElement(Element element) {
        BaseContentMessage msg = castMessage(BaseContentMessage.class);
        switch (element.getName()) {
            case Constants.ELE_TO_USER_NAME:
                msg.setToUserName(element.getValue());
                return true;
            case Constants.ELE_FROM_USER_NAME:
                msg.setFromUserName(element.getValue());
                return true;
            case Constants.ELE_MSG_ID:
                try {
                    ((PlainMessage) message).setMsgID(Long.parseLong(element.getValue()));

                } catch (NumberFormatException e) {
                    LOGGER.error("format message id: val={}", element.getValue());
                }
                break;
            default:
                break;

        }

        return false;
    }
}
