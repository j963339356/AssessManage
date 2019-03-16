package com.wjc.assess.utils.controller.dto;

public class ResponseHead {
    public String id;       //当前请求的id
    public String service;  //服务编号
    public int staticCode;  //响应状态
    public String message;  //响应信息
    public String time;     //响应时间

    public String getId() {
        return id;
    }

    public ResponseHead setId(String id) {
        this.id = id;
        return this;
    }

    public String getService() {
        return service;
    }

    public ResponseHead setService(String service) {
        this.service = service;
        return this;
    }

    public int getStaticCode() {
        return staticCode;
    }

    public ResponseHead setStaticCode(int staticCode) {
        this.staticCode = staticCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseHead setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ResponseHead setTime(String time) {
        this.time = time;
        return this;
    }
}
