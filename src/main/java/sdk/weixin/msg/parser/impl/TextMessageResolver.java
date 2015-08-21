package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.TextMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 文本消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class TextMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new TextMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        TextMessage msg = castMessage(TextMessage.class);
        switch (element.getName()) {
            case Constants.ELE_CONTENT:
                msg.setContent(element.getValue());
                return true;
            default:
                break;
        }
        return false;
    }
}
