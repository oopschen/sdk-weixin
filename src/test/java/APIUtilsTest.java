import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sdk.weixin.APIUtils;
import sdk.weixin.Result;
import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

/**
 * apiutils 单元测试
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class APIUtilsTest {
    private APIUtils apiUtils;

    @BeforeTest public void setUp() {
        apiUtils = APIUtils.getInstance(10);
    }

    @Test public void request() {
        BaseRequest get = new BaseRequest() {
            {
                setMethod(RequestMethod.GET);
                setRequestURI("http://localhost:13000/test.json");
            }
        };


        Result a = apiUtils.request(get, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));

        // post
        BaseRequest post = new BaseRequest() {
            {
                setMethod(RequestMethod.POST);
                setRequestURI("http://localhost:13000/test.json");
                addParam("a", 1);
                addParam("b", 4);
            }
        };

        a = apiUtils.request(post, Result.class);
        Assert.assertNull(a);

    }


}
