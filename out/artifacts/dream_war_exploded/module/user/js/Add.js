define(['/hzml/common/js/config.js'], function () {
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
                    parent.window.$("#query").click();
                }
                else{
                    layer.msg("保存失败", {time: 1000 });
                } 
            })
            return false;
        });
    })
})
