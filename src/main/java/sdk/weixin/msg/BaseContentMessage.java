package sdk.weixin.msg;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <p>有内容的消息基类</p>
 *
 * @author chenl
 * @date 2015.08.14
 */
public abstract class BaseContentMessage extends BaseMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseContentMessage.class);
    protected String toUserName;
    protected String fromUserName;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }


    /**
     * 实现实体转成xml
     *
     * @return dom 对象
     */
    protected Document toElements() {
        Document document = super.toElements();
        if (null == document) {
            return null;
        }

        if (!StringUtils.isBlank(toUserName)) {
            Element ele = document.createElement("ToUserName");
            ele.appendChild(document.createCDATASection(toUserName));
            append2Root(document, ele);
        }

        if (!StringUtils.isBlank(fromUserName)) {
            Element ele = document.createElement("FromUserName");
            ele.appendChild(document.createCDATASection(fromUserName));
            append2Root(document, ele);
        }

        return document;
    }
}
