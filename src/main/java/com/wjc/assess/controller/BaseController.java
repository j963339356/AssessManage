package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.User;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    //获取请求报文
    public CommonRequest getCommonRequest(HttpServletRequest httpServletRequest){
        CommonRequest request = MessageHelp.getCommonRequest(httpServletRequest);
        return request;
    }

    //获取用户信息
    public User getUser(HttpServletRequest httpServletRequest){
        Object str = httpServletRequest.getAttribute("user");
        User user = JSON.parseObject(str.toString(), User.class);
        return user;
    }
}
