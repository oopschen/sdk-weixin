package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.VideoMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 视频消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class VideoMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new VideoMessage(false));
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        VideoMessage msg = castMessage(VideoMessage.class);
        switch (element.getName()) {
            case Constants.ELE_IMG_ID:
                msg.setMediaID(element.getValue());
                return true;
            case Constants.ELE_VIDEO_THUMB:
                msg.setThumbMediaID(element.getValue());
                return true;
            default:
                break;
        }

        return false;
    }
}
