package com.exfox.mqtt.service;

import com.exfox.mqtt.model.BaseOutModel;
import com.exfox.mqtt.model.in.PublishMessageInModel;
import com.exfox.mqtt.model.out.PublishMessageOutModel;
import org.eclipse.paho.client.mqttv3.MqttException;
import reactor.core.publisher.Mono;

public interface MQTTService {
    Mono<BaseOutModel<PublishMessageOutModel>> publishMessage(PublishMessageInModel publishMessageInModel) throws MqttException;
}
