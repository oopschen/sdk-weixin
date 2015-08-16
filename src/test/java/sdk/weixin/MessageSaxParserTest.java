package sdk.weixin;

import org.testng.Assert;
import org.testng.annotations.Test;
import sdk.weixin.msg.*;
import sdk.weixin.msg.parser.MessageParser;
import sdk.weixin.msg.parser.SubscribeMessage;
import sdk.weixin.msg.parser.impl.MessageSaxParser;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * <p>MessageSaxParser 测试类</p>
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class MessageSaxParserTest {

    @Test public void imageMessage() {
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

    @Test public void textMessage() {
        String message = " <xml>\n" + " <ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + " <FromUserName><![CDATA[fromUser]]></FromUserName> \n"
            + " <CreateTime>1348831860</CreateTime>\n" + " <MsgType><![CDATA[text]]></MsgType>\n"
            + " <Content><![CDATA[this is a test]]></Content>\n"
            + " <MsgId>1234567890123456</MsgId>\n" + " </xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        TextMessage parsedMessage = (TextMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1348831860));
        Assert.assertEquals(parsedMessage.getContent(), "this is a test");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
    }

    @Test public void voiceMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1357290913</CreateTime>\n" + "<MsgType><![CDATA[voice]]></MsgType>\n"
            + "<MediaId><![CDATA[media_id]]></MediaId>\n" + "<Format><![CDATA[Format]]></Format>\n"
            + "<MsgId>1234567890123456</MsgId>\n" + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        VoiceMessage parsedMessage = (VoiceMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1357290913));
        Assert.assertEquals(parsedMessage.getMediaID(), "media_id");
        Assert.assertEquals(parsedMessage.getFormat(), "Format");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
        Assert.assertNull(parsedMessage.getTransTextFromVoice());

        // recog
        message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1357290913</CreateTime>\n" + "<MsgType><![CDATA[voice]]></MsgType>\n"
            + "<MediaId><![CDATA[media_id]]></MediaId>\n" + "<Format><![CDATA[Format]]></Format>\n"
            + "<MsgId>1234567890123456</MsgId>\n<Recognition><![CDATA[腾讯微信团队]]></Recognition>"
            + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        parsedMessage = (VoiceMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1357290913));
        Assert.assertEquals(parsedMessage.getMediaID(), "media_id");
        Assert.assertEquals(parsedMessage.getFormat(), "Format");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
        Assert.assertEquals(parsedMessage.getTransTextFromVoice(), "腾讯微信团队");
    }

    @Test public void videoMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1357290913</CreateTime>\n" + "<MsgType><![CDATA[video]]></MsgType>\n"
            + "<MediaId><![CDATA[media_id]]></MediaId>\n"
            + "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n"
            + "<MsgId>1234567890123456</MsgId>\n" + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        VideoMessage parsedMessage = (VideoMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1357290913));
        Assert.assertEquals(parsedMessage.getMediaID(), "media_id");
        Assert.assertEquals(parsedMessage.getThumbMediaID(), "thumb_media_id");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
        Assert.assertFalse(parsedMessage.getIsShort());

        // short
        message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1357290913</CreateTime>\n"
            + "<MsgType><![CDATA[shortvideo]]></MsgType>\n"
            + "<MediaId><![CDATA[media_id]]></MediaId>\n"
            + "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n"
            + "<MsgId>1234567890123456</MsgId>\n" + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        parsedMessage = (VideoMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1357290913));
        Assert.assertEquals(parsedMessage.getMediaID(), "media_id");
        Assert.assertEquals(parsedMessage.getThumbMediaID(), "thumb_media_id");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
        Assert.assertTrue(parsedMessage.getIsShort());
    }

    @Test public void locationMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1351776360</CreateTime>\n" + "<MsgType><![CDATA[location]]></MsgType>\n"
            + "<Location_X>23.134521</Location_X>\n" + "<Location_Y>113.358803</Location_Y>\n"
            + "<Scale>20</Scale>\n" + "<Label><![CDATA[位置信息]]></Label>\n"
            + "<MsgId>1234567890123456</MsgId>\n" + "</xml> ";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        LocationMessage parsedMessage = (LocationMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1351776360));
        Assert.assertEquals(parsedMessage.getLatitude(), "23.134521");
        Assert.assertEquals(parsedMessage.getLongitude(), "113.358803");
        Assert.assertEquals(parsedMessage.getScale(), "20");
        Assert.assertEquals(parsedMessage.getLabel(), "位置信息");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));

    }

    @Test public void linkMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>1351776360</CreateTime>\n" + "<MsgType><![CDATA[link]]></MsgType>\n"
            + "<Title><![CDATA[公众平台官网链接]]></Title>\n"
            + "<Description><![CDATA[公众平台官网链接]]></Description>\n" + "<Url><![CDATA[url]]></Url>\n"
            + "<MsgId>1234567890123456</MsgId>\n" + "</xml> ";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        LinkMessage parsedMessage = (LinkMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");

        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(1351776360));
        Assert.assertEquals(parsedMessage.getTitle(), "公众平台官网链接");
        Assert.assertEquals(parsedMessage.getUrl(), "url");
        Assert.assertEquals(parsedMessage.getMsgID(), Long.valueOf("1234567890123456"));
    }

    @Test public void subscribeMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[subscribe]]></Event>\n" + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        SubscribeMessage parsedMessage = (SubscribeMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertTrue(parsedMessage.isSubscribe());

        // unsubscribe
        message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[unsubscribe]]></Event>\n" + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        parsedMessage = (SubscribeMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertFalse(parsedMessage.isSubscribe());
    }

    @Test public void scanQRMessage() {
        String message = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[subscribe]]></Event>\n"
            + "<EventKey><![CDATA[qrscene_123123]]></EventKey>\n"
            + "<Ticket><![CDATA[TICKET]]></Ticket>\n" + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        ScanQRCodeMessage parsedMessage = (ScanQRCodeMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getEventKey(), "123123");
        Assert.assertEquals(parsedMessage.getTicket(), "TICKET");

        // no prefix
        message = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[subscribe]]></Event>\n" + "<EventKey><![CDATA[123123]]></EventKey>\n"
            + "<Ticket><![CDATA[TICKET]]></Ticket>\n" + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        parsedMessage = (ScanQRCodeMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getEventKey(), "123123");
        Assert.assertEquals(parsedMessage.getTicket(), "TICKET");

        // scan
        message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[SCAN]]></Event>\n"
            + "<EventKey><![CDATA[qrscene_123123]]></EventKey>\n"
            + "<Ticket><![CDATA[TICKET]]></Ticket>\n" + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        ScanQRSubscribeMessage parsedMessage1 = (ScanQRSubscribeMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage1);
        Assert.assertEquals(parsedMessage1.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage1.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage1.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage1.getEventKey(), "qrscene_123123");
        Assert.assertEquals(parsedMessage1.getTicket(), "TICKET");
    }

    @Test public void locationUploadMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[LOCATION]]></Event>\n" + "<Latitude>23.137466</Latitude>\n"
            + "<Longitude>113.352425</Longitude>\n" + "<Precision>119.385040</Precision>\n"
            + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        LocationUploadMessage parsedMessage = (LocationUploadMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "fromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getLatitude(), "23.137466");
        Assert.assertEquals(parsedMessage.getLongitude(), "113.352425");
        Assert.assertEquals(parsedMessage.getPrecision(), "119.385040");
    }

    @Test public void menuMessage() {
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[CLICK]]></Event>\n" + "<EventKey><![CDATA[EVENTKEY]]></EventKey>\n"
            + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        MenuMessage parsedMessage = (MenuMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getMenuKey(), "EVENTKEY");
    }

    @Test public void encryptMessage() {
        String message = "<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>"
            + "<Encrypt><![CDATA[msg_encrypt]]></Encrypt>" + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        EncryptMessage parsedMessage = (EncryptMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertNull(parsedMessage.getFromUserName());
        Assert.assertNull(parsedMessage.getCreateTime());
        Assert.assertEquals(parsedMessage.getEncryptMessage(), "msg_encrypt");
        Assert.assertNull(parsedMessage.getTimeStamp());
        Assert.assertNull(parsedMessage.getSignature());
        Assert.assertNull(parsedMessage.getNonce());

        message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>" + "<Encrypt>\n"
            + "<![CDATA[test]]> </Encrypt>\n" + "<MsgSignature>hello</MsgSignature>\n"
            + "<TimeStamp>1411034505</TimeStamp>\n" + "<Nonce>1111</Nonce>\n" + "</xml>";

        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

        parsedMessage = (EncryptMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertNull(parsedMessage.getFromUserName());
        Assert.assertNull(parsedMessage.getCreateTime());
        Assert.assertEquals(parsedMessage.getEncryptMessage(), "test");
        Assert.assertEquals(parsedMessage.getTimeStamp(), "1411034505");
        Assert.assertEquals(parsedMessage.getSignature(), "hello");
        Assert.assertEquals(parsedMessage.getNonce(), "1111");
    }

    @Test public void abnormalMessage() {
        String message = "<xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertFalse(messageParser.parse(new ByteArrayInputStream(message.getBytes())));

    }

    @Test public void parseMethods() {
        // string
        String message = "<xml>\n" + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
            + "<FromUserName><![CDATA[FromUser]]></FromUserName>\n"
            + "<CreateTime>123456789</CreateTime>\n" + "<MsgType><![CDATA[event]]></MsgType>\n"
            + "<Event><![CDATA[CLICK]]></Event>\n" + "<EventKey><![CDATA[EVENTKEY]]></EventKey>\n"
            + "</xml>";

        MessageParser messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(message));

        MenuMessage parsedMessage = (MenuMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getMenuKey(), "EVENTKEY");

        // gbk encoded
        String gbkEncodedMsg = new String(message.getBytes(StandardCharsets.UTF_8));
        messageParser = new MessageSaxParser();

        Assert.assertTrue(messageParser.parse(gbkEncodedMsg));

        parsedMessage = (MenuMessage) messageParser.getMessage();
        Assert.assertNotNull(parsedMessage);
        Assert.assertEquals(parsedMessage.getToUserName(), "toUser");
        Assert.assertEquals(parsedMessage.getFromUserName(), "FromUser");
        Assert.assertEquals(parsedMessage.getCreateTime(), new Date(123456789));
        Assert.assertEquals(parsedMessage.getMenuKey(), "EVENTKEY");

    }

}
