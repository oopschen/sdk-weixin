package sdk.weixin.req;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * form类型的请求，遵循application/x-www-form-urlencoded
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseFormRequest extends BaseRequest {
    private Map<String, String> params;

    public BaseFormRequest() {
        super();
        params = new HashMap<>();
    }

    public void addParam(String name, String val) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(val)) {
            return;
        }

        params.put(name, val);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
