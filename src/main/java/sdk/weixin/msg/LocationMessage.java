package sdk.weixin.msg;

/**
 * <p>地理位置消息</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class LocationMessage extends PlainMessage {
    private String latitude; //纬度
    private String longitude; // 经度
    private String scale;
    private String label;

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
