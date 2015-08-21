package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.VoiceMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 语音消息
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class VoiceMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new VoiceMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        VoiceMessage msg = castMessage(VoiceMessage.class);
        switch (element.getName()) {
            case Constants.ELE_VOICE_FORMAT:
                msg.setFormat(element.getValue());
                return true;
            case Constants.ELE_IMG_ID:
                msg.setMediaID(element.getValue());
                return true;
            case Constants.ELE_VOICE_RECOGNITION:
                msg.setTransTextFromVoice(element.getValue());
                return true;
            default:
                break;
        }

        return false;
    }
}
