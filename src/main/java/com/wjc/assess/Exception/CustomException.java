package com.wjc.assess.Exception;

import com.wjc.assess.Enum.ExceptionEnum;


public class CustomException extends RuntimeException{
    private Integer code;    //异常编号

    //异常编号，异常信息
    public CustomException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
