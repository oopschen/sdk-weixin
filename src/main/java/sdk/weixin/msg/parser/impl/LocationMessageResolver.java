package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.LocationMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 位置消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class LocationMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new LocationMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        LocationMessage msg = castMessage(LocationMessage.class);
        switch (element.getName()) {
            case Constants.ELE_LOC_LABEL:
                msg.setLabel(element.getValue());
                return true;
            case Constants.ELE_LOC_SCALE:
                msg.setScale(element.getValue());
                return true;
            case Constants.ELE_LOC_LAT:
                msg.setLatitude(element.getValue());
                return true;
            case Constants.ELE_LOC_LONG:
                msg.setLongitude(element.getValue());
                return true;
            default:
                break;
        }

        return false;
    }
}
