package sdk.weixin.helper;

import org.testng.Assert;
import org.testng.annotations.Test;

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

    }
}
