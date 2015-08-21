package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 默认的消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class DefaultMessageResolver extends BaseMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        return false;
    }

    @Override protected boolean parseExtElement(Element element) {
        return false;
    }
}
