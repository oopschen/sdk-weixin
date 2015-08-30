package sdk.weixin.helper;

import org.testng.Assert;
import org.testng.annotations.Test;
import sdk.weixin.req.auth.WebAuthScope;

/**
 * {@Link sdk.weixin.helper.URIHelpers} 单元测试
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class URIHelpersTest {
    @Test public void preAuthURI() {
        Assert.assertEquals(URIHelpers.preAuthURI("a", "b", "http://localhost"),
            "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=a&pre_auth_code=b&redirect_uri=http://localhost");

        Assert.assertEquals(
            URIHelpers.webAuthURI("a", "http://localhost", null, "c", WebAuthScope.SCOPE_BASE),
            "https://open.weixin.qq.com/connect/oauth2/authorize?appid=a&redirect_uri=http://localhost&response_type=code&scope=snsapi_base&state=&component_appid=c#wechat_redirect");
        Assert.assertEquals(URIHelpers
                .webAuthURI("a", "http://localhost", "tt", "c", WebAuthScope.SCOPE_INFO,
                    WebAuthScope.SCOPE_BASE),
            "https://open.weixin.qq.com/connect/oauth2/authorize?appid=a&redirect_uri=http://localhost&response_type=code&scope=snsapi_userinfo,snsapi_base&state=tt&component_appid=c#wechat_redirect");
    }
}
