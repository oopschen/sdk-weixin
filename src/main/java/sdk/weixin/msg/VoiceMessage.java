package sdk.weixin.msg;

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

    public String getTransTextFromVoice() {
        return transTextFromVoice;
    }

    public void setTransTextFromVoice(String transTextFromVoice) {
        this.transTextFromVoice = transTextFromVoice;
    }

    private String transTextFromVoice;

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
}
