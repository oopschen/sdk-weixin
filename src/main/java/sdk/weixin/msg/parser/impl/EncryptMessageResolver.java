package sdk.weixin.msg.parser.impl;

import sdk.weixin.msg.EncryptMessage;
import sdk.weixin.msg.parser.Constants;
import sdk.weixin.msg.parser.ResolveParam;
import sdk.weixin.msg.parser.xml.Element;

/**
 * 加密消息解析器
 *
 * @author work
 * @version %I%, %G%
 * @since 1.0
 */
public class EncryptMessageResolver extends BaseContentMessageResolver {
    @Override protected boolean initMessage(ResolveParam param) {
        setMessage(new EncryptMessage());
        return true;
    }

    @Override protected boolean parseExtElement(Element element) {
        if (super.parseExtElement(element)) {
            return true;
        }

        EncryptMessage encryptMessage = castMessage(EncryptMessage.class);
        switch (element.getName()) {
            case Constants.ELE_ENCRYPT:
                encryptMessage.setEncryptMessage(element.getValue());
                return true;

            case Constants.ELE_ENCRYPT_NONCE:
                encryptMessage.setNonce(element.getValue());
                return true;

            case Constants.ELE_ENCRYPT_SIGNATURE:
                encryptMessage.setSignature(element.getValue());
                return true;

            case Constants.ELE_ENCRYPT_TS:
                encryptMessage.setTimeStamp(element.getValue());
                return true;

            case Constants.ELE_INFO_MSG_APPID:
                encryptMessage.setToUserName(element.getValue());
                return true;

            default:
                break;
        }

        return false;
    }
}
