define(['/hzml/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper'], function ($) {
        var form = layui.form;
        form.render();

        $("#id").val(parent.window.$("#id").val())

        //自动赋值
        $("input").each(function(i,item){
            var user =  Helper.GetUser();
            if($(item).attr('name') == 'sysCreateName'){
                $(item).val(user.name);
            }
            if($(item).attr('name') == 'ogrName'){
                $(item).val(user.orgName);
            }
            if($(item).attr('name') == 'sysCreateTime'){
                $(item).val(new Date().Format("yyyy-MM-dd"));
            }
        });

        //设置分类和主指标一致
        $("input[name='p']").val(window.parent.document.getElementsByName("p")[0].value)

        //保存
        $("#save").click(function(){
            var body = $("#dimension").serializeForm();
            console.log(body);
            //验证指标名称不为空
            if(body.name == ''){
                layer.msg("指标名称不能为空",{time: 1000})
                return ;
            } 
            Helper.Ajax("TargetManage/add",body,function(result){   
                if(result.response.staticCode == 0){
                    layer.msg("保存成功", {time: 1000 },function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });                    
                }
                else{
                    layer.msg("保存失败", {time: 1000 });
                } 
                parent.CustomTable.reload(body.id);
            })   
        })
    })
})
