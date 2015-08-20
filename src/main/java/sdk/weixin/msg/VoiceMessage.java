package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>语音消息</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class VoiceMessage extends PlainMessage {
    private String format;
    private String mediaID;
    private String transTextFromVoice;

    public String getTransTextFromVoice() {
        return transTextFromVoice;
    }

    public void setTransTextFromVoice(String transTextFromVoice) {
        this.transTextFromVoice = transTextFromVoice;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    @Override protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            return null;
        }

        appendMsgType(document, "voice");

        if (!StringUtils.isBlank(mediaID)) {
            Element voice = document.createElement("Voice");

            Element ele = document.createElement("MediaId");
            ele.appendChild(document.createCDATASection(mediaID));

            voice.appendChild(ele);
            append2Root(document, voice);
        }

        return document;
    }
}
