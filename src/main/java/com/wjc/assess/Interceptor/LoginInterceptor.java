package com.wjc.assess.Interceptor;

import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.utils.redis.JedisUtil;
import com.wjc.assess.utils.token.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 登录验证拦截，如果是登录则通过，如果是其他请求则验证token
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private JedisUtil redis;
    @Autowired
    private TokenUtil tokenUtil;
    //返回true继续向下走，返回false立刻中断执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //设置响应的字符编码格式
        httpServletResponse.setContentType("text/html;charset=utf-8");

        //如果是登录或注册，就放行
        if(httpServletRequest.getRequestURI().contains("/api/Login")
                || httpServletRequest.getRequestURI().contains("/api/File")
                || httpServletRequest.getRequestURI().contains("/api/ReportManage/deleteFile")){
            return true;
        }
        //否则验证token
        String token = tokenUtil.checkToken(httpServletRequest);

        //如果存在token
        if(!redis.hasKey(token)){
            throw new CustomException(ExceptionEnum.LOGIN);
        }
        httpServletRequest.setAttribute("user",redis.get(token));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("执行拦截器的afterCompletion方法");
    }
}
