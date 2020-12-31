package com.exfox.mqtt.task;

import com.exfox.mqtt.component.MQTTClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQTTCallBackTask extends Thread  {
    @Autowired
    private MQTTClient mqttClient;

    @SneakyThrows
    @Override
    public void run() {
        mqttClient.subMessage();
    }
}
