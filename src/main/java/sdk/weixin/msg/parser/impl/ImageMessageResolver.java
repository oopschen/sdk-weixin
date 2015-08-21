package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.ImageMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 图片解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class ImageMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new ImageMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        ImageMessage msg = castMessage(ImageMessage.class);
        switch (element.getName()) {
            case Constants.ELE_IMG_ID:
                msg.setMediaID(element.getValue());
                return true;
            case Constants.ELE_IMG_URL:
                msg.setPicURL(element.getValue());
                return true;
            default:
                break;

        }
        return false;
    }
}
