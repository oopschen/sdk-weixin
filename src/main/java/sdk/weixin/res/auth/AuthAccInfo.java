package sdk.weixin.res.auth;

/**
 * auth account info
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthAccInfo {
    private String nick_name;
    private String head_img;
    private String user_name;
    private String alias;
    private VerifyTypeInfo verify_type_info;
    private ServiceTypeInfo service_type_info;

    public AuthAccInfo() {
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public VerifyTypeInfo getVerify_type_info() {
        return verify_type_info;
    }

    public void setVerify_type_info(VerifyTypeInfo verify_type_info) {
        this.verify_type_info = verify_type_info;
    }

    public ServiceTypeInfo getService_type_info() {
        return service_type_info;
    }

    public void setService_type_info(ServiceTypeInfo service_type_info) {
        this.service_type_info = service_type_info;
    }
}
