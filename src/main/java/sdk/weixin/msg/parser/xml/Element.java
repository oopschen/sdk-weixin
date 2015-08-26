package sdk.weixin.msg.parser.xml;

/**
 * xml解析出来的元素
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class Element {
    private String rawName;
    private String name;
    private String value;

    public Element(String rawName, String name, String value) {
        this.rawName = rawName;
        this.name = name;
        this.value = value;
    }

    public Element(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String rawName) {
        this.rawName = rawName;
    }
}
