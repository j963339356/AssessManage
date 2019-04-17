define(['jquery','layui','cookie','popups','login'], function ($) {
    Helper = {}

    //发起ajax请求
    Helper.Ajax = function(url,body,callback,callback2){
        var ajaxData = Helper.AjaxData(url,body,callback,callback2);
        $.support.cors = true;
        ajaxData.data = {'':JSON.stringify(ajaxData.data)};
        $.ajax(ajaxData);
    }

    //创建ajax请求体
    Helper.AjaxData = function(url,body,callback,callback2){
        var index;
        ajax = {
            //请求成功的回调函数
            success:function(result){
                layer.closeAll('dialog');   //关闭加载层

                if($.type(result) == "string"){
                    result = JSON.parse(result)
                }
                if(result.response.staticCode == 4){
                    //用户信息已过期
                    Helper.ClearnToken();
                    Helper.removeUser();
                }
                callback(result);
            },
            complete:function(){    //请求完成时
                // layer.closeAll(index); //关闭加载层
                if(callback2!=undefined){
                    callback2();
                }
            }
        }
        var data = {body: body};
        var ajaxObject = $.extend({
            url: "/hzml/api/" + url,       //请求url
            type: "post",  //post请求
            // data: {},      //要传输的数据
            cache: true,  //false不缓存页面
            crossDomain: true,
            dataType: "json",   //json数据
            contentType: "application/json",
            headers:{
                "token": Helper.GetToken(),
                "Access-Control-Allow-Origin": "*",     //跨域
                "Access-Control-Allow-Headers": "X-Requested-With",
                "Cache-Control": "private"  //开启post缓存
            },
            error:function(request,error,exception){    //请求对象，错误信息，异常对象
                console.log(error)
                console.log(exception)
            },
            beforeSend:function(){  //请求前的动作，可以做成加载中动画
                index = layer.msg('加载中', {
                    icon: 16,
                    shade: 0.01,
                    // time: 3000
                });
            }            
        },ajax,{data: data});
        return ajaxObject;
    }
    

    //获取COOKIE中的TOKEN
    Helper.GetToken = function () {
        var token = $.trim($.cookie('token'));
        return token;
    }

    //设置token
    Helper.SetToken = function(token){
        $.cookie('token', token, {
            // expire:  //不设置这个，在浏览器退出时会自动删除cookie
            path: "/"
        });
    }

    Helper.ClearnToken = function(){
        $.removeCookie('token',{ path: '/'}); //path为指定路径，直接删除该路径下的cookie
    }

    //登录验证
    Helper.Login = function(){
        //显示登录框
        Login.ShowLogin();

    }

    //获取用户信息
    Helper.GetUser = function(){
        return JSON.parse(sessionStorage.getItem('user'));
    }

    //设置用户信息
    Helper.SetUser = function(token){
        Helper.Ajax("Login/get",token,function(data){
            sessionStorage.setItem('user',data.body)
        })
    }
    //删除用户信息
    Helper.removeUser = function(){
        sessionStorage.removeItem('user');
    }
})