package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    // 发送
    private String title;
    private String description;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            document = createDoc();
        }

        if (null == document) {
            return null;
        }

        appendMsgType(document, "video");

        if (!StringUtils.isBlank(mediaID)) {
            Element ele = document.createElement("MediaId");
            ele.appendChild(document.createCDATASection(mediaID));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(title)) {
            Element ele = document.createElement("Title");
            ele.appendChild(document.createCDATASection(title));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(description)) {
            Element ele = document.createElement("Description");
            ele.appendChild(document.createCDATASection(description));
            append2Root(document, ele);
        }

        return document;
    }
}
