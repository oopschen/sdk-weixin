package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.LinkMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 链接消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class LinkMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new LinkMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        LinkMessage msg = castMessage(LinkMessage.class);
        switch (element.getName()) {
            case Constants.ELE_LINK_DESC:
                msg.setDescription(element.getValue());
                return true;
            case Constants.ELE_LINK_URL:
                msg.setUrl(element.getValue());
                return true;
            case Constants.ELE_LINK_TITLE:
                msg.setTitle(element.getValue());
                return true;
            default:
                break;
        }

        return false;
    }
}
