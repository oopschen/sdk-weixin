import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.client.utils.URIBuilder;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.BinaryBody;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sdk.weixin.APIUtils;
import sdk.weixin.Result;
import sdk.weixin.req.BaseFormRequest;
import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;
import sdk.weixin.req.auth.AccessTokenRequest;
import sdk.weixin.res.auth.AccessTokenResponse;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

/**
 * apiutils 单元测试
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class APIUtilsTest {
    private static final Integer SERVER_PORT = 1200;
    private static final Integer PROXY_PORT = 1201;
    private static final String TEST_HOST = "127.0.0.1";
    private APIUtils apiUtils;
    private ClientAndProxy proxy;
    private ClientAndServer server;


    @BeforeMethod public void setUp() {
        proxy = ClientAndProxy.startClientAndProxy(PROXY_PORT);
        server = ClientAndServer.startClientAndServer(SERVER_PORT);
        apiUtils = APIUtils.getInstance(10, 10);
    }

    @AfterMethod public void cleanUp() {
        proxy.stop();
        server.stop();
    }

    @Test public void request() throws URISyntaxException {
        MockServerClient mockServerClient = new MockServerClient(TEST_HOST, SERVER_PORT);
        HttpResponse httpResponse = HttpResponse.response().withStatusCode(200)
            .withHeader("content-type", "application/json").withBody("{\"a\": 1}");
        final String reqURI =
            new URIBuilder().setScheme("http").setHost(TEST_HOST).setPort(SERVER_PORT)
                .setPath("/test.json").build().toString();

        // get
        mockServerClient.when(HttpRequest.request().withMethod("GET").withPath("/test.json"))
            .respond(httpResponse);

        BaseRequest get = new BaseRequest() {
            {
                setMethod(RequestMethod.GET);
                setRequestURI(reqURI);
            }
        };


        Result a = apiUtils.request(get, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));

        // post
        mockServerClient.when(HttpRequest.request().withMethod("POST").withPath("/test.json")
            .withBody("{\"a\":1,\"b\":\"4\"}")).respond(httpResponse);
        BaseRequest post = new BaseRequest() {
            private Integer a;
            private String b;

            {
                setMethod(RequestMethod.POST);
                setRequestURI(reqURI);
                setA(1);
                setB("4");
            }

            public Integer getA() {
                return a;
            }

            public void setA(Integer a) {
                this.a = a;
            }

            public String getB() {
                return b;
            }

            public void setB(String b) {
                this.b = b;
            }
        };

        a = apiUtils.request(post, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));

        // https
        mockServerClient
            .when(HttpRequest.request().withSecure(true).withMethod("GET").withPath("/test.json"))
            .respond(httpResponse);

        BaseRequest httpsGet = new BaseRequest() {
            {
                setMethod(RequestMethod.GET);
                setRequestURI(
                    new URIBuilder().setScheme("https").setHost(TEST_HOST).setPort(SERVER_PORT)
                        .setPath("/test.json").build().toString());
            }
        };

        a = apiUtils.request(httpsGet, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));
    }



    @Test public void requestForm() throws URISyntaxException, IOException {
        MockServerClient mockServerClient = new MockServerClient(TEST_HOST, SERVER_PORT);
        HttpResponse httpResponse = HttpResponse.response().withStatusCode(200)
            .withHeader("content-type", "application/json").withBody("{\"a\": 1}");
        final String reqURI =
            new URIBuilder().setScheme("http").setHost(TEST_HOST).setPort(SERVER_PORT)
                .setPath("/test.json").build().toString();

        // get
        mockServerClient.when(HttpRequest.request().withMethod("GET").withPath("/test.json")
            .withQueryStringParameter("a", "b c")).respond(httpResponse);

        BaseRequest get = new BaseFormRequest() {
            {
                setMethod(RequestMethod.GET);
                setRequestURI(reqURI);
                addParam("a", "b c");
            }
        };


        Result a = apiUtils.request(get, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));

        // post
        mockServerClient.when(HttpRequest.request().withMethod("POST").withPath("/test.json")
            .withBody(new BinaryBody("b=4+c&a=1".getBytes()))).respond(httpResponse);
        BaseRequest post = new BaseFormRequest() {
            {
                setMethod(RequestMethod.POST);
                setRequestURI(reqURI);
                setA(1);
                setB("4 c");
            }

            public Integer getA() {
                return Integer.valueOf(getParams().get("a"));
            }

            public void setA(Integer a) {
                addParam("a", String.valueOf(a));
            }

            public String getB() {
                return getParams().get("b");
            }

            public void setB(String b) {
                addParam("b", b);
            }
        };

        a = apiUtils.request(post, Result.class);
        Assert.assertNotNull(a);
        Assert.assertEquals(a.getA(), new Integer(1));
    }

    @Test public void objectMapper() throws IOException {
        String json =
            "{\n" + "\"component_access_token\":\"abc\", \n" + "\"expires_in\":7200\n" + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.setPropertyNamingStrategy(
            PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        AccessTokenResponse accessTokenResponse =
            objectMapper.readValue(json, AccessTokenResponse.class);

        Assert.assertNotNull(accessTokenResponse);
        Assert.assertEquals(accessTokenResponse.getComponentAccessToken(), "abc");
        Assert.assertEquals(accessTokenResponse.getExpiresIn(), new Integer(7200));

        // serialize
        AccessTokenRequest tokenRequest = new AccessTokenRequest();
        tokenRequest.setComponentAppid("1");
        tokenRequest.setComponentAppsecret("2");
        tokenRequest.setComponentVerifyTicket("3");
        StringWriter result = new StringWriter();
        objectMapper.writeValue(result, tokenRequest);

        Assert.assertEquals(result.toString(), "{\"component_appid\":\"1\",\"component_appsecret\":\"2\",\"component_verify_ticket\":\"3\"}");
    }
}
