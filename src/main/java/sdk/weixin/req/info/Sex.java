package sdk.weixin.req.info;

import org.apache.commons.lang3.StringUtils;

/**
 * 性别enum类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public enum Sex {
    MAN("1"),
    FEMALE("2");
    private String value;

    Sex(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return StringUtils.isBlank(value) ? StringUtils.EMPTY : value;
    }
}
