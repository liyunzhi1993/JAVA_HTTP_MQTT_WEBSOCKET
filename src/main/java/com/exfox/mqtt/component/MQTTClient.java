package com.exfox.mqtt.component;

import lombok.Getter;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MQTTClient{
    int qos = 0;
    String broker = "tcp://broker.hivemq.com:1883";
    MemoryPersistence persistence = new MemoryPersistence();

    @Getter
    protected final MqttClient mqttClient;

    /**
     * 初始化MQTT客户端【这个是给API用的】
     * @throws MqttException
     */
    public MQTTClient() throws MqttException {
        mqttClient = new MqttClient(broker, UUID.randomUUID().toString(), persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        mqttClient.connect(connOpts);
    }

    /**
     * 订阅消息【这个是来订阅消息的】
     * @return
     * @throws MqttException
     */
    public void subMessage() throws MqttException {
        mqttClient.setCallback(new MQTTCallBack());
        mqttClient.subscribe("subTopic");
    }

    /**
     * 发布消息
     * @param topic
     * @param content
     */
    public void pubishMessage(String topic,String content) throws MqttException {
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        mqttClient.publish(topic,message);
    }
}
