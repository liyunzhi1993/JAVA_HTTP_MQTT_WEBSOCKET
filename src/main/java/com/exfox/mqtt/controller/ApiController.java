package com.exfox.mqtt.controller;

import com.exfox.mqtt.model.BaseOutModel;
import com.exfox.mqtt.model.in.PublishMessageInModel;
import com.exfox.mqtt.model.out.PublishMessageOutModel;
import com.exfox.mqtt.service.MQTTService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MQTTService MQTTService;

    @PostMapping("/publishmessage")
    public Mono<BaseOutModel<PublishMessageOutModel>> publishMessage(@RequestBody PublishMessageInModel publishMessageInModel)
    {
        try {
            return MQTTService.publishMessage(publishMessageInModel);
        } catch (MqttException e) {
            return Mono.just(new BaseOutModel<>(
                    new PublishMessageOutModel(),"发送失败"
            ));
        }
    }
}
