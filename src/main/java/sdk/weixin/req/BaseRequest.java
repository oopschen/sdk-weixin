package sdk.weixin.req;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请求基类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseRequest {
    protected RequestMethod method;
    protected Map<String, Object> params;
    protected String requestURI;

    public BaseRequest() {
        method = RequestMethod.GET;
    }

    public void addParam(String name, Object value) {
        if (null == params) {
            params = new LinkedHashMap<String, Object>();
        }
        params.put(name, value);

    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
