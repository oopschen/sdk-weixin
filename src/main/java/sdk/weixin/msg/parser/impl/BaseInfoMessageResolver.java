package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.BaseInfoMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 信息类的消息推送
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseInfoMessageResolver extends BaseMessageResolver {
    @Override protected boolean parseExtElement(Element element) {
        BaseInfoMessage msg = castMessage(BaseInfoMessage.class);
        switch (element.getName()) {
            case Constants.ELE_INFO_MSG_APPID:
                msg.setAppID(element.getValue());
                return true;

            default:
                break;
        }

        return false;
    }
}
