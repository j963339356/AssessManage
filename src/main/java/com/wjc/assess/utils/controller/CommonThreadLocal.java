package com.wjc.assess.utils.controller;

import com.wjc.assess.utils.controller.dto.CommonResponse;

/*
 * ThreadLocal是一个为线程提供线程局部变量的工具类，为线程提供一个线程私有的变量副本，
 * 这样多个线程都可以随意更改自己线程局部的变量，不会影响到其他线程
 * 不过需要注意的是，ThreadLocal提供的只是一个浅拷贝，如果变量是一个引用类型，那么就要考虑它内部的状态是否会被改变，
 * 想要解决这个问题可以通过重写ThreadLocal的initialValue()函数来自己实现深拷贝，建议在使用ThreadLocal时一开始就重写该函数
 * 可以在请求时把数据放到这个线程里，响应完成后释放
 */
public class CommonThreadLocal {
    private static ThreadLocal<CommonResponse> local = new ThreadLocal();

    private CommonThreadLocal(){}

    //释放线程
    public static void free(){
        local.set(null);
    }

    //设置数据
    public static void set(CommonResponse response){
        local.set(response);
    }

    //获取数据
    public static CommonResponse getCommonResponse(){
        return local.get();
    }
}