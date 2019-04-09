define(['/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper'], function ($) {
        var form = layui.form;
        form.render();
        
        //保存
        form.on('submit(save)', function(data){
            var body = data.field;
            Helper.Ajax("Login/Regist",body,function(result){   
                if(result.response.staticCode == 0){
                    layer.msg("保存成功", {time: 1000 },function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });                    
                }
                else{
                    layer.msg("保存失败", {time: 1000 });
                } 
            })    
            parent.window.$("#query").click();
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
    })
})
