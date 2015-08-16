package sdk.weixin;

import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import sdk.weixin.msg.EncryptMessage;
import sdk.weixin.msg.TextMessage;

import java.util.Date;

/**
 * <p>消息工具测试</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class MessageUtilsTest {
    @Test public void encryptDecryptMessage() throws AesException {
        String timeStamp = "12121212122",
            nonce = "nonce",
            appID = "wxb11529c136998cb6",
            token = "testtoken",
            encodingAESKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";

        TextMessage message = new TextMessage();
        message.setContent("hello");
        message.setToUserName("toUser");
        message.setFromUserName("fromUser");
        message.setCreateTime(new Date());
        message.setMsgID(RandomUtils.nextLong(1000, 10000000000L));


        MessageUtils messageUtils = MessageUtils.getInstance(token, encodingAESKey, appID);
        String encodedMsg = messageUtils.encryptMessage(message, timeStamp, nonce);
        Assert.assertNotNull(encodedMsg);

        // string 2 object
        EncryptMessage encryptMessage = (EncryptMessage) messageUtils.parseMessage(encodedMsg);
        Assert.assertNotNull(encryptMessage);

        // decrypt
        encryptMessage.setToUserName("test");
        TextMessage decryptMsg =
            (TextMessage) messageUtils.decryptAndValidationMessage(encryptMessage);
        Assert.assertNotNull(decryptMsg);
        Assert.assertEquals(message.getContent(), decryptMsg.getContent());

    }

    @Test public void message2Str() {
        TextMessage message = new TextMessage();
        message.setContent("hello");
        message.setToUserName("toUser");
        message.setFromUserName("fromUser");
        message.setCreateTime(new Date());
        message.setMsgID(RandomUtils.nextLong(1000, 10000000000L));

        MessageUtils messageUtils = MessageUtils.getInstance("a", "b", "c");
        TextMessage parsedMsg = (TextMessage) messageUtils.parseMessage(message.toString());
        Assert.assertNotNull(parsedMsg);
        Assert.assertEquals(parsedMsg.getContent(), message.getContent());
        Assert.assertEquals(parsedMsg.getToUserName(), message.getToUserName());
        Assert.assertEquals(parsedMsg.getFromUserName(), message.getFromUserName());
        Assert.assertEquals(parsedMsg.getCreateTime(), message.getCreateTime());

    }
}
