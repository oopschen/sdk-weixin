package sdk.weixin.msg.parser.impl;

import org.apache.commons.collections4.CollectionUtils;
import sdk.weixin.msg.DefaultMessage;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

import java.util.Collection;
import java.util.List;

/**
 * 默认的消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class DefaultMessageResolver extends BaseMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new DefaultMessage());
        if (CollectionUtils.isEmpty(param.getElementList())) {
            return true;
        }
        StringBuilder message = new StringBuilder();
        for (Element element : param.getElementList()) {
            message.append("<");
            message.append(element.getRawName());
            message.append(">");
            message.append(element.getValue());
            message.append("</");
            message.append(element.getRawName());
            message.append(">");
        }

        DefaultMessage defaultMessage = castMessage(DefaultMessage.class);
        defaultMessage.setMessage(message.toString());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        return true;
    }
}
