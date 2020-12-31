package com.exfox.mqtt.model;


import lombok.Getter;
import lombok.Setter;

public class BaseOutModel<T> {
    /**
     * 具体业务数据
     */
    @Getter
    @Setter
    private T data;
    /**
     * 返回状态码【200正常，0有错误】
     */
    @Getter
    @Setter
    private int code;

    /**
     * 错误描述，Code为0使用
     */
    @Getter
    @Setter
    private String message;

    /**
     * 构造
     */
    public BaseOutModel()
    {
        code = 200;
    }

    public BaseOutModel(T t,String message)
    {
        code = 200;
        data=t;
        this.message=message;
    }

    /**
     * 错误
     * @param msg
     */
    public void error(String msg)
    {
        code = 0;
        message = msg;
    }
}
