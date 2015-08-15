package sdk.weixin;

import org.testng.Assert;
import org.testng.annotations.Test;
import sdk.weixin.msg.BaseMessage;
import sdk.weixin.msg.ImageMessage;
import sdk.weixin.msg.parser.MessageParser;
import sdk.weixin.msg.parser.impl.MessageSaxParser;

import java.io.ByteArrayInputStream;
import java.util.Date;

/**
 * <p>MessageSaxParser 测试类</p>
 *
 * @author ray
 * @date 2015-08-15
 * @since 1.0
 */
public class MessageSaxParserTest {

    @Test public void plainMessage() {
        String message = "<xml>\n" + " <ToUserName><![CDATA[name]]></ToUserName>\n"
            + " <FromUserName><![CDATA[fname]]></FromUserName>\n"
            + " <CreateTime>1348831860</CreateTime>\n" + " <MsgType><![CDATA[image]]></MsgType>\n"
            + " <PicUrl><![CDATA[url]]></PicUrl>\n" + " <MediaId><![CDATA[media_id]]></MediaId>\n"
            + " <MsgId>1234567890123456</MsgId>\n" + " </xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        ImageMessage parsedMessage = (ImageMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "name");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fname");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1348831860));
        Assert.assertEquals(parsedMessage.getPicURL(), "url");
        Assert.assertEquals(parsedMessage.getMediaID(), "media_id");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));

    }
}
