package com.exfox.mqtt.component;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

public class MQTTCallBack implements MqttCallback {

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //message和sid自行去解析，sid是通过客户端发送来的，message是设备回的
        String message = "我接收到了啊..";
        String sid = "123";
        webSocketServer.sendMessage(message, sid);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
