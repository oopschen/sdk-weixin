package sdk.weixin.res.auth.util;

/**
 * option contants
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class OptionConstants {
    // names
    public static final String OPT_NAME_LOCATION_UPLOAD = "location_report";
    public static final String OPT_NAME_VOICE_RECOG = "voice_recognize";
    public static final String OPT_NAME_CUST_SRV = "customer_service";

    // vals
    public static final String OPT_VAL_LOCATION_NO = "0";
    public static final String OPT_VAL_LOCATION_YES = "1";
    public static final String OPT_VAL_LOCATION_EVERY_FIVE_SEC = "2";
    public static final String OPT_VAL_VOICE_RECOG_NO = "0";
    public static final String OPT_VAL_VOICE_RECOG_YES = "1";
    public static final String OPT_VAL_CUST_SRV_NO = "0";
    public static final String OPT_VAL_CUST_SRV_YES = "1";

    private OptionConstants() {
    }
}
