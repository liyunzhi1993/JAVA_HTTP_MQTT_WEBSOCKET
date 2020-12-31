package com.exfox.mqtt.model.in;

public class PublishMessageInModel {
    //发布的Topic
    public String topic;
    //发布的消息体
    public String content;
    //接收消息的SocketID,当不为空的时候，会下发WebSocket消息【这里可以不用，放在内容中进行加密就好了】
    public String receiveWebSocketID;
    //设备编号【只有对接过IoT平台才能使用】
    public String deviceSn;
}
