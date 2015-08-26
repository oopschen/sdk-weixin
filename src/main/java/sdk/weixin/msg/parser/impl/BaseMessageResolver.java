package sdk.weixin.msg.parser.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sdk.weixin.msg.BaseMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.MessageResolver;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

import java.util.Date;

/**
 * 基础消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseMessageResolver implements MessageResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMessageResolver.class);
    protected BaseMessage message;

    @Override public BaseMessage resolve(ResolveParam param) {
        if (!initMessage(param)) {
            return null;
        }

        for (Element element : param.getElementList()) {
            switch (element.getName()) {
                case Constants.ELE_CREATE_DATE:
                    try {
                        message.setCreateTime(new Date(Long.parseLong(element.getValue())));
                    } catch (NumberFormatException e) {
                        LOGGER.error("format date: val={}", element.getValue());
                    }
                    break;
                default:
                    parseExtElement(element);
                    break;

            }
        }

        return message;
    }

    /**
     * 初始化message实例
     *
     * @param param 参数
     * @return true | false
     */
    protected abstract boolean initMessage(ResolveParam param);

    /**
     * 解析其他消息元素
     *
     * @param element 解析的元素
     * @return true | false
     */
    protected abstract boolean parseExtElement(Element element);

    protected <T extends BaseMessage> T castMessage(Class<T> clz) {
        return (T) message;
    }

    public void setMessage(BaseMessage message) {
        this.message = message;
    }
}
