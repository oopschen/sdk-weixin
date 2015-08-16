package sdk.weixin.req;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 请求基类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class BaseRequest {
    protected RequestMethod method;
    protected String requestURI;

    public BaseRequest() {
        method = RequestMethod.GET;
    }

    @JsonIgnore public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    @JsonIgnore public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

}
