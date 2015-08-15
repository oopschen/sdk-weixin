package sdk.weixin.msg;

/**
 * <p>语音消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class VoiceMessage extends PlainMessage {
    private String format;
    private String mediaID;

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
