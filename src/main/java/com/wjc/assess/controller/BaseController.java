package com.wjc.assess.controller;

import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    //获取请求报文
    public CommonRequest getCommonRequest(HttpServletRequest httpServletRequest){
        CommonRequest request = MessageHelp.getCommonRequest(httpServletRequest);
        return request;
    }
}
