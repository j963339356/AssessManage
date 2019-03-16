package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.entity.Account;
import com.wjc.assess.service.impl.TestService;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

//所有后台都用/api路径
@RestController
@RequestMapping("/api")
public class LoginController extends BaseController {
    @Autowired
    private TestService dao;
    @Autowired
    private JedisUtil redis;

    @PostMapping(value = "/Login")
    public Object Login(HttpServletRequest httpServletRequest) {
        //获取请求对象
        Account login = (Account)getCommonRequest(httpServletRequest).getBody();

        //判断是否存在用户
        Account account = dao.login(login);

        //把用户信息放到缓存，并返回token
        String token = UUID.randomUUID().toString();
        redis.set(token, JSON.toJSON(account).toString());
        return MessageHelp.Result(token);
    }

    @PostMapping(value = "/Regist")
    public Object Regist(HttpServletRequest httpServletRequest){
        //获取请求对象
        Account regist = (Account)getCommonRequest(httpServletRequest).getBody();

        //注册账号
        dao.regist(regist);
        return MessageHelp.Result(true);
    }

    @GetMapping(value = "/Verify")
    public Object Verify(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        return null;
    }

    @PostMapping(value = "/getList")
    public Object getList(HttpServletRequest httpServletRequest) {
        //获取请求对象
        CommonRequest query = getCommonRequest(httpServletRequest);

        Account account = (Account)query.getBody();
        int page = query.page;
        int size = query.rows;

        return MessageHelp.Result(dao.getList(account,page,size));
    }
}
