package com.exfox.mqtt.model.out;

import lombok.Getter;
import lombok.Setter;

public class PublishMessageOutModel {
    //回复消息的内容
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    //回复状态【1 已回复，0 未回复 即超时】
    private int receiveStatus;
}
