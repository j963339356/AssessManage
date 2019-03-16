package com.wjc.assess.controller;

import com.wjc.assess.service.TestInterface;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import static com.wjc.assess.utils.controller.MessageHelp.Result;

//所有后台都用/api路径
@RestController
@RequestMapping("/api")
public class TestController extends BaseController {
    @Autowired
    private TestInterface testDao;
    @Autowired
    private JedisUtil redis;

    @RequestMapping(value = "/a", produces = {"application/json;charset=UTF-8"})
    public Object hello(HttpServletRequest httpServletRequest){
//        return testDao.get(0);
        return null;
    }

    @RequestMapping(value = "/a2")
    public Object get(HttpServletRequest httpServletRequest){
        //获取请求对象
//        CommonRequest request = getCommonRequest(httpServletRequest);
//        Totaltime totaltime = JSON.parseObject(request.body.toString(),Totaltime.class);
//        redis.set("xiaofa","666");
//        System.out.println(redis.get("xiaofa"));
//        return testDao.get2(1);
        return Result(true);
    }


    //异常测试
    @RequestMapping(value = "/err", produces = {"application/json;charset=UTF-8"})
    public Object hello(String str){
        int a = 2/0;
        return "Hello World";
    }


}
