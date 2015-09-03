# 微信SDK
做一个纯净，可扩展的微信sdk。

# 状态
* 完成第三方平台授权所需要的接口
* 完成消息的解析和封装
* 完成网页授权接口封装

# 设计理念
* 面向对象,所有接口封装成对象使用
* 不依赖web框架,做简单纯净的sdk

## 消息解析

    TextMessage message = new TextMessage();
    message.setContent("hello");
    message.setToUserName("toUser");
    message.setFromUserName("fromUser");
    message.setCreateTime(new Date());
    message.setMsgID(RandomUtils.nextLong(1000, 10000000000L));

    MessageUtils messageUtils = MessageUtils.getInstance("token", "encodingAESKey", "appID");
    TextMessage parsedMsg = (TextMessage) messageUtils.parseMessage(message.toString());

## 授权接口调用

    APIUtils apiUtils = APIUtils.getInstance(maxConnectionNumber, timeoutSecond);
    PreAuthRequest preAuthRequest = new PreAuthRequest(componentAccessToken);
    preAuthRequest.setComponentAppid(componentAppID);
    PreAuthResponse response = apiUtils.request(preAuthRequest, PreAuthResponse.class);
