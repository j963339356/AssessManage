package com.wjc.assess.utils.controller.dto;

public class RequestHead {
    public String id;       //当前请求的id
    public String service;  //服务编号
    public String time;     //请求时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
