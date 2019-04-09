package com.wjc.assess.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.entity.User;
import com.wjc.assess.service.impl.UserService;
import com.wjc.assess.utils.VerifyUtil;
import com.wjc.assess.utils.controller.MessageHelp;
import com.wjc.assess.utils.controller.dto.CommonRequest;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.UUID;

//所有后台都用/api路径
@RestController
@RequestMapping("/api/Login")
public class LoginController extends BaseController {
    @Autowired
    private UserService dao;
    @Autowired
    private JedisUtil redis;

    @PostMapping(value = "/Login")
    public Object Login(HttpServletRequest httpServletRequest,HttpSession session) {
        //获取请求对象
        Object object = getCommonRequest(httpServletRequest).getBody();
        JSONObject jsonObject = JSON.parseObject(object.toString());
        User login = JSON.parseObject(object.toString(),User.class);
        //验证验证码
        Boolean objs = redis.hasKey(jsonObject.getString("captcha").toLowerCase());//验证码对象
        if(objs==false){
            throw new CustomException(ExceptionEnum.VERIFY);
        }
        //判断是否存在用户
        User account = dao.login(login);

        //把用户信息放到缓存，并返回token
        String token = UUID.randomUUID().toString();
        redis.set(token, JSON.toJSON(account).toString());
        return MessageHelp.Result(token);
    }

    @PostMapping(value = "/Regist")
    public Object Regist(HttpServletRequest httpServletRequest){
        //获取请求对象
        Object object = getCommonRequest(httpServletRequest).getBody();
        User regist = JSON.parseObject(object.toString(),User.class);

        //注册账号
        dao.regist(regist);
        return MessageHelp.Result(true);
    }

    //验证码
    @RequestMapping("/captcha")
    public void captcha(HttpServletResponse response, HttpSession session) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入redis
        redis.set(objs[0].toString().toLowerCase(),"1",1);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);  //tomcat没有temp临时文件所以会报错
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os); encoder.encode(image);
    }

    @PostMapping(value = "/getList")
    //账号列表
    public Object getList(HttpServletRequest httpServletRequest) {
        //获取请求对象
        CommonRequest query = getCommonRequest(httpServletRequest);
        User account = JSON.parseObject(query.getBody().toString(),User.class);

        int page = query.page;
        int size = query.rows;

        return MessageHelp.Result(dao.getList(account,page,size));
    }

    @PostMapping(value = "/getacc")
    //账号
    public Object getacc(HttpServletRequest httpServletRequest) {
        //获取请求对象
        CommonRequest query = getCommonRequest(httpServletRequest);

        String id = query.getBody().toString();
        return MessageHelp.Result(dao.get(id));
    }

    @PostMapping(value = "/delete")
    //删除
    public Object delete(HttpServletRequest httpServletRequest) {
        //获取请求对象
        CommonRequest query = getCommonRequest(httpServletRequest);

        String[] ids = JSON.parseObject(query.getBody().toString(),String[].class);
        dao.delete(ids);
        return MessageHelp.Result(true);
    }

    @PostMapping(value = "/get")
    public Object get(HttpServletRequest httpServletRequest){
        //获取请求对象
        CommonRequest query = getCommonRequest(httpServletRequest);
        String token = query.getBody().toString();

        Object o = redis.get(token);
        return  MessageHelp.Result(o);
    }
}
