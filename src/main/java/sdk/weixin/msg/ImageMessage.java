package sdk.weixin.msg;

/**
 * <p>图片消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class ImageMessage extends PlainMessage {
    private String picURL;

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    private String mediaID;

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
}
