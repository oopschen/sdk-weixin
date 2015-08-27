package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.AuthMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 授权信息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthMessageResolver extends BaseInfoMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new AuthMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        AuthMessage msg = castMessage(AuthMessage.class);
        switch (element.getName()) {
            case Constants.ELE_AUTH_FROM_APP_ID:
                msg.setActionAppID(element.getValue());
                break;
            default:
                break;
        }
        return false;
    }
}
