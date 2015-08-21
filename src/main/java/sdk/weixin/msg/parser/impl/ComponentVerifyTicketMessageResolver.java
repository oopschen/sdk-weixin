package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.ComponentVerificationTicketMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class ComponentVerifyTicketMessageResolver extends BaseMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new ComponentVerificationTicketMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        ComponentVerificationTicketMessage msg =
            castMessage(ComponentVerificationTicketMessage.class);
        switch (element.getName()) {
            case Constants.ELE_COMP_APPID:
                msg.setAppID(element.getValue());
                return true;

            case Constants.ELE_COMP_TICKET:
                msg.setComponentVerifyTicket(element.getValue());
                return true;

            case Constants.ELE_MSG_TYPE_INFO:
                msg.setTyp(element.getValue());
                return true;

            default:
                break;

        }
        return false;
    }
}
