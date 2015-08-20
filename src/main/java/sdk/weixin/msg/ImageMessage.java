package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>图片消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class ImageMessage extends PlainMessage {
    private String mediaID;
    private String picURL;

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }


    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    @Override protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            return null;
        }

        appendMsgType(document, "image");

        if (!StringUtils.isBlank(mediaID)) {
            Element ele = document.createElement("MediaId");
            ele.appendChild(document.createCDATASection(mediaID));
            append2Root(document, ele);
        }

        return document;
    }
}
