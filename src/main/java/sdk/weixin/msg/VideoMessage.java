package sdk.weixin.msg;

/**
 * <p>视频消息或小视频消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class VideoMessage extends PlainMessage {
    private String mediaID;
    private String thumbMediaID;
    private Boolean isShort;

    public VideoMessage(Boolean isShort) {
        this.isShort = isShort;
    }

    public Boolean getIsShort() {
        return isShort;
    }

    public void setIsShort(Boolean isShort) {
        this.isShort = isShort;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    public String getThumbMediaID() {
        return thumbMediaID;
    }

    public void setThumbMediaID(String thumbMediaID) {
        this.thumbMediaID = thumbMediaID;
    }
}
