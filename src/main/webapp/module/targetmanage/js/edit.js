define(['/hzml/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper','customtable'], function ($) {
        var form = layui.form;
        form.render();
        var element = layui.element;
        var user =  Helper.GetUser();
        // element.tab({
        //     headerElem: '#tabHeader>li' //指定tab头元素项
        //     ,bodyElem: '#tabBody>.xxx' //指定tab主体元素项
        //   });   
        // element.on('tab(tab)',function(data){
        //     console.log(data)
        // })

        //自动填表
        var data = parent.CustomTable.getSelect()[0];
        $("#id").val(data.id);   //保存id
        fill(data);

        function fill(data){
            $('#form1').find('input[name],select[name]').each(function (i, item) {
                var tempValue = data[$(item).attr('name')];
                if (tempValue != undefined) {
                    //TODO: 赋值
                    $(item).val(tempValue.toString() == '' ? '' : tempValue);
                } else {
                    $(item).val('');
                }
            });
        }

        //自动赋值
        $("input").each(function(i,item){
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
            Helper.Ajax("TargetManage/update",body,function(result){   
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
        
        //新增
        $("#addDimension").click(function(){       
            Popups.popIfram({
                title: ["维度设置"],
                content: "dimension.html",
            });
        })   

         //删除
         $("#deleteDimension").click(function(){
            var data2 = CustomTable.getSelect();
            var body = []
            for(var i=0; i<data2.length; i++){
                body.push(data2[i].id);
            }
            Helper.Ajax("TargetManage/dimensionDelete",body,function(result){   
                if(result.response.staticCode == 0){
                    layer.msg("删除成功", {time: 1000 },function(){
                        CustomTable.reload(data.id)
                    });                    
                }
                else{
                    layer.msg("删除失败", {time: 1000 });
                } 
            })    
        })

        //维度表
        CustomTable.init({
            elem: "#table",
            url: '/hzml/api/TargetManage/dimensionList', //数据接口
            where: data.id,
            page: false,
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            cols: [[ //表头
                { checkbox: true },
                { field: 'id', title: 'id', hide: true, align: 'center' },
                { field: 'name', title: '指标名称', align: 'center' },
                { field: 'meansure', title: '计量单位', align: 'center' }
            ]]
        });
    })
})
