package sdk.weixin.req.auth;

import org.apache.commons.lang3.StringUtils;

/**
 * 网页授权scope值
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public enum WebAuthScope {
    SCOPE_BASE("snsapi_base"),
    SCOPE_INFO("snsapi_userinfo");

    private String value;

    WebAuthScope(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return StringUtils.isBlank(value) ? StringUtils.EMPTY : value;
    }
}
