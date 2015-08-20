package sdk.weixin.msg;

/**
 * <p>上报地理位置事件</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class LocationUploadMessage extends EventMessage {
    private String latitude;
    private String longitude;
    private String precision;

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

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
