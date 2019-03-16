package com.wjc.assess.utils.token;

import com.alibaba.fastjson.JSON;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
token工具类，生成token，解析token
 */
@Component
public class TokenUtil {
    //过期时间 默认15分钟
    public long EXPIRE_TIME = 15;
    @Autowired
    public JedisUtil redis;
    /*
     * 生成token,传入用户信息，
     * token作为键，用户信息转成json数据存入redis，并有效时间
     */
    public <T>String createToken(T user){
        //生成token
        String token = UUID.randomUUID().toString();
        //user转json格式
        String userStr = JSON.toJSON(user).toString();
        //放到redis
        redis.set(token,userStr);

        return token;
    }

    //根据token获取
    public <T>Object getUser(String token){
        T user = (T)redis.get(token);
        if(user == null){
            throw new CustomException(ExceptionEnum.COMPONENT.getCode(),"token已过期");
        }
        //重置token有效期
        redis.expire(token);
        return user;
    }
    public <T>Object getUser(HttpServletRequest httpServletRequest)
    {
        String token = checkToken(httpServletRequest);
        return getUser(token);
    }

    //校验token,如果成功返回token
    public String checkToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        if(token == null || token.trim().equals("")){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"账号未登录");
        }
        //重置token有效期
        redis.expire(token);
        return token;
    }
}
