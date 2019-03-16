package com.wjc.assess.Exception;

import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理异常，返回错误信息
 * */
@RestControllerAdvice
public class GlobalAjaxException {
    private final static Logger log = LoggerFactory.getLogger(GlobalAjaxException.class);

    @ExceptionHandler(value = Exception.class)
    public Object ErrorHandler(Exception e){
        log.error("【发生异常】{}",e);
        //如果是自己定义的异常
        CommonResponse response = new CommonResponse();
        if(e instanceof CustomException){
            response.getResponse()
                    .setMessage(e.getMessage())
                    .setStaticCode(((CustomException) e).getCode());
        }
        //如果是其他异常
        else{
            response.getResponse()
                    .setMessage(ExceptionEnum.ERROR.getMessage()+": "+e.getMessage())
                    .setStaticCode(ExceptionEnum.ERROR.getCode());
        }
        return MessageHelp.Result(response,null);
    }
}
