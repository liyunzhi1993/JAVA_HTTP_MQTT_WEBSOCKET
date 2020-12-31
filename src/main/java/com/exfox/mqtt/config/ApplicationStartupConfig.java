package com.exfox.mqtt.config;

import com.exfox.mqtt.task.MQTTCallBackTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationStartupConfig implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 获得IOC
        ApplicationContext ioc = event.getApplicationContext();
        // 获得任务类
        MQTTCallBackTask mqttCallBackTask = ioc.getBean(MQTTCallBackTask.class);
        // 开启任务线程
        mqttCallBackTask.start();
    }
}
