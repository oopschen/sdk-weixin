package sdk.weixin.req.menu;

import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;
import sdk.weixin.res.menu.Button;

import java.util.List;

/**
 * menu creation request
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class MenuCreationRequest extends BaseRequest {
    private List<Button> button;

    public MenuCreationRequest() {
    }

    public MenuCreationRequest(String accessToken) {
        setMethod(RequestMethod.POST);
        setRequestURI(" https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
