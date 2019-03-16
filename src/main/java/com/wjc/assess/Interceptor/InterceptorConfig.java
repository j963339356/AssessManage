package com.wjc.assess.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    //页面跳转，访问第一个页面，跳转到第二个页面
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/toLogin").setViewName("login");
//    }

    //必须要用注解，因为和他关联的属性用了@AutoWire，不能new新对象，那样会让AutoWire失效
    @Bean
    public LoginInterceptor LoginInterceptor(){
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //拦截api后的所有
        registry.addInterceptor(LoginInterceptor()).addPathPatterns("/api/**");
    }
}
