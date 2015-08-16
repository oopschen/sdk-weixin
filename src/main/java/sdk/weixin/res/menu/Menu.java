package sdk.weixin.res.menu;

import java.util.List;

/**
 * menu entity
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class Menu {
    private List<Button> button;

    public Menu() {
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
