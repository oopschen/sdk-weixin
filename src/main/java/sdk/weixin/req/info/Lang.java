package sdk.weixin.req.info;

import org.apache.commons.lang3.StringUtils;

/**
 * 语言枚举类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public enum Lang {
    ZH_CN("zh_CN"),
    zh_TW("zh_TW"),
    EN("en");

    private String value;

    Lang(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return StringUtils.isBlank(value) ? StringUtils.EMPTY : value;
    }
}
