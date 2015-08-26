package sdk.weixin.msg.parser;

/**
 * 常量类
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class Constants {
    private Constants() {
    }


    // tag names
    public static final String ELE_TO_USER_NAME = "tousername";
    public static final String ELE_FROM_USER_NAME = "fromusername";
    public static final String ELE_CREATE_DATE = "createtime";
    public static final String ELE_MSG_TYPE_CONTENT = "msgtype";
    public static final String ELE_MSG_TYPE_INFO = "infotype";
    // plain
    public static final String ELE_MSG_ID = "msgid";
    // text
    public static final String ELE_CONTENT = "content";
    // image
    public static final String ELE_IMG_URL = "picurl";
    public static final String ELE_IMG_ID = "mediaid";

    // voice
    public static final String ELE_VOICE_FORMAT = "format";
    public static final String ELE_VOICE_RECOGNITION = "recognition";

    // video
    public static final String ELE_VIDEO_THUMB = "thumbmediaid";

    // location
    public static final String ELE_LOC_LAT = "location_x";
    public static final String ELE_LOC_LONG = "location_y";
    public static final String ELE_LOC_SCALE = "scale";
    public static final String ELE_LOC_LABEL = "label";

    // link
    public static final String ELE_LINK_URL = "url";
    public static final String ELE_LINK_DESC = "description";
    public static final String ELE_LINK_TITLE = "title";

    // event
    public static final String ELE_EVT = "event";

    // qr
    public static final String ELE_QR_KEY = "eventkey";
    public static final String ELE_QR_TICKET = "ticket";

    // location
    public static final String ELE_LOCU_LAT = "latitude";
    public static final String ELE_LOCU_LONG = "longitude";
    public static final String ELE_LOCU_PRECISION = "precision";

    // encrypt
    public static final String ELE_ENCRYPT = "encrypt";
    public static final String ELE_ENCRYPT_SIGNATURE = "msgsignature";
    public static final String ELE_ENCRYPT_TS = "timestamp";
    public static final String ELE_ENCRYPT_NONCE = "nonce";

    // info type message
    public static final String ELE_INFO_MSG_APPID = "appid";

    // component
    public static final String ELE_COMP_TICKET = "componentverifyticket";

    // auth message
    public static final String ELE_AUTH_FROM_APP_ID = "authorizerappid";
}
