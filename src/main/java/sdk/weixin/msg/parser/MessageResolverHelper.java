package sdk.weixin.msg.parser;

import org.apache.commons.lang3.StringUtils;
import sdk.weixin.msg.parser.impl.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息解析帮助类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class MessageResolverHelper {
    public static final String RESOLVER_DEF = "__default";
    public static final String RESOLVER_ENCRYPT = "__encrypt";

    private static final Map<String, MessageResolver> MSG_TYPE2PARSER =
        Collections.unmodifiableMap(new HashMap<String, MessageResolver>() {
            {
                // default
                put(RESOLVER_DEF, new DefaultMessageResolver());
                put(RESOLVER_ENCRYPT, new EncryptMessageResolver());
                put("text", new TextMessageResolver());
                put("image", new ImageMessageResolver());
                put("voice", new VoiceMessageResolver());
                put("video", new VideoMessageResolver());
                put("shortvideo", new TinyVideoMessageResolver());
                put("location", new LocationMessageResolver());
                put("link", new LinkMessageResolver());
                // event
                put("event", new EventMessageResolver());
                put("component_verify_ticket", new ComponentVerifyTicketMessageResolver());
            }
        });

    private MessageResolverHelper() {
    }

    public static final MessageResolver getMessageResolver(ResolveParam param) {
        String key;

        if (param.isEncrypt()) {
            key = RESOLVER_ENCRYPT;

        } else if (!StringUtils.isBlank(param.getInfoTyp())) {
            key = param.getInfoTyp().toLowerCase();

        } else if (!StringUtils.isBlank(param.getMsgTyp())) {
            key = param.getMsgTyp().toLowerCase();

        } else {
            key = RESOLVER_DEF;
        }

        return MSG_TYPE2PARSER.get(key);
    }
}
