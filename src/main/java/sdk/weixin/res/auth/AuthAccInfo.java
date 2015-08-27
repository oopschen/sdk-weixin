package sdk.weixin.res.auth;

/**
 * auth account info
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class AuthAccInfo {
    private String nickName;
    private String headImg;
    private String userName;
    private String alias;
    private VerifyTypeInfo verifyTypeInfo;
    private ServiceTypeInfo serviceTypeInfo;

    public AuthAccInfo() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public VerifyTypeInfo getVerifyTypeInfo() {
        return verifyTypeInfo;
    }

    public void setVerifyTypeInfo(VerifyTypeInfo verifyTypeInfo) {
        this.verifyTypeInfo = verifyTypeInfo;
    }

    public ServiceTypeInfo getServiceTypeInfo() {
        return serviceTypeInfo;
    }

    public void setServiceTypeInfo(ServiceTypeInfo serviceTypeInfo) {
        this.serviceTypeInfo = serviceTypeInfo;
    }
}
