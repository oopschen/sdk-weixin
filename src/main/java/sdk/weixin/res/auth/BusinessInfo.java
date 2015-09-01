package sdk.weixin.res.auth;

/**
 * 未知数据类型，接口无说明
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class BusinessInfo {
    private Integer openPay;
    private Integer openShake;
    private Integer openScan;
    private Integer openCard;
    private Integer openStore;

    public BusinessInfo() {
    }

    public Integer getOpenPay() {
        return openPay;
    }

    public void setOpenPay(Integer openPay) {
        this.openPay = openPay;
    }

    public Integer getOpenShake() {
        return openShake;
    }

    public void setOpenShake(Integer openShake) {
        this.openShake = openShake;
    }

    public Integer getOpenScan() {
        return openScan;
    }

    public void setOpenScan(Integer openScan) {
        this.openScan = openScan;
    }

    public Integer getOpenCard() {
        return openCard;
    }

    public void setOpenCard(Integer openCard) {
        this.openCard = openCard;
    }

    public Integer getOpenStore() {
        return openStore;
    }

    public void setOpenStore(Integer openStore) {
        this.openStore = openStore;
    }
}
