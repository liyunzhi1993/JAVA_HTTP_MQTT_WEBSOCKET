package com.exfox.mqtt;

import com.exfox.mqtt.config.ApplicationStartupConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MqttApplication.class);
        springApplication.addListeners(new ApplicationStartupConfig());
        springApplication.run(args);

    }
}
