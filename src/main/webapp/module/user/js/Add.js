define(['/hzml/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper'], function ($) {
        var form = layui.form;
        form.render();

        //表单验证
        form.verify({
            dianhua:[ /\d{2,3}-?\d{7,8}$/,'请输入正确的电话']
        })

        //保存
        form.on('submit(save)', function(data){
            var body = data.field;
            Helper.Ajax("Login/Regist",body,function(result){   
                if(result.response.staticCode == 0){
                    parent.Pipups.prompt("保存成功");
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                    parent.window.$("#query").click();
                }
                else{
                    parent.Pipups.prompt("保存失败");
                } 
            })
            return false;
        });
    })
})
