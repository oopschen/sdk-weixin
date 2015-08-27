package sdk.weixin.req;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 请求基类, 会将类json化传给server
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

    protected void setMethod(RequestMethod method) {
        this.method = method;
    }

    @JsonIgnore public String getRequestURI() {
        return requestURI;
    }

    protected void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

}
