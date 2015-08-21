package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.VideoMessage;
import sdk.weixin.msg.parser.ResolveParam;

/**
 * 小视频解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class TinyVideoMessageResolver extends VideoMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new VideoMessage(true));
        return true;
    }
}
