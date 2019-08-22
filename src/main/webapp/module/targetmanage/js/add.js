define(['/hzml/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper'], function ($) {
        var form = layui.form;
        form.render();
        var element = layui.element;
        // element.tab({
        //     headerElem: '#tabHeader>li' //指定tab头元素项
        //     ,bodyElem: '#tabBody>.xxx' //指定tab主体元素项
        //   });   
        // element.on('tab(tab)',function(data){
        //     console.log(data)
        // })

        //自动赋值
        $("input").each(function(i,item){
            var user =  Helper.GetUser();
            if($(item).attr('name') == 'sysCreateName'){
                $(item).val(user.name);
            }
            if($(item).attr('name') == 'orgName'){
                $(item).val(user.orgName);
            }
            if($(item).attr('name') == 'sysCreateTime'){
                $(item).val(new Date().Format("yyyy-MM-dd"));
            }
        });
        
        //保存
        $("#save").click(function(){
            var body = $("#form1").serializeForm();
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
            })    
            parent.window.$("#query").click();        
        });  
    })
})
