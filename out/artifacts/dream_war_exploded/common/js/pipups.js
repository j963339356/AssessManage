define(['jquery','layui'], function ($) {
    Pipups = {};
    layer = layui.layer;

    //弹出页面
    Pipups.confirm = function(message,func){
        layer.confirm(message, {
            btn: ['確定','取消'] //按钮
        }, function(index){
            layer.close(index); //执行关闭
            func();
        }, function(index){
            return;
        });
    }

    //右下角提示
    Pipups.prompt = function(message){
        layer.msg('<div style="line-height:75px; text-align: center;">'+message+'</div>',{
            time: 1000,
            offset: ['85%', '85%'],
            area: ['200px', '100px']
        });
    }

    return Pipups;
})