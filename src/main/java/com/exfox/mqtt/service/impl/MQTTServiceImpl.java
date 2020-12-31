package com.exfox.mqtt.service.impl;

import com.exfox.mqtt.component.MQTTClient;
import com.exfox.mqtt.model.BaseOutModel;
import com.exfox.mqtt.model.in.PublishMessageInModel;
import com.exfox.mqtt.model.out.PublishMessageOutModel;
import com.exfox.mqtt.service.MQTTService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MQTTServiceImpl implements MQTTService {

    @Autowired
    private MQTTClient mqttClient;
    @Override
    public Mono<BaseOutModel<PublishMessageOutModel>> publishMessage(PublishMessageInModel publishMessageInModel) throws MqttException {
        mqttClient.pubishMessage(publishMessageInModel.topic,publishMessageInModel.content);
        return Mono.just(new BaseOutModel<>(
                new PublishMessageOutModel(),"发送成功"
        ));
    }
}
