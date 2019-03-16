package com.wjc.assess.Enum;

import org.omg.PortableInterceptor.SUCCESSFUL;

public enum ExceptionEnum {
    BUSINESS(1,"业务处理出错"), //业务异常，在处理业务时出错
    PARAMERTER(2,"参数错误"),   //参数错误
    COMPONENT(3,"工具类错误"),   //工具类错误
    SUCCESS(0,"成功"),    //成功
    ERROR(-1,"未知错误");   //其他异常

    private int code;    //异常编号
    private String message;  //异常信息

    private ExceptionEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
