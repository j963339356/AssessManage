define(['/hzml/common/js/config.js'], function () {
    require(['jquery','common','helper','layui'], function ($, CustomTable) {
        upload = layui.upload;
        form = layui.form;
        form.render();
        var preSelect = parent.CustomTable.getSelect()[0]; //表格选择的数据

        //自动赋值
        $("#id").val(preSelect.id);   //保存id
        fill(preSelect);

        function fill(data){
            $('#form1').find('input[name],select[name],textarea[name]').each(function (i, item) {
                var tempValue = data[$(item).attr('name')];
                if (tempValue != undefined) {
                    //TODO: 赋值
                    $(item).val(tempValue.toString() == '' ? '' : tempValue);
                } else {
                    $(item).val('');
                }
            });
        }

        //判断是否有文件，如果有文件则显示查看和删除
        if(preSelect.reportAddr){
            $("#upload2").show();
            $("#upload").hide();
        }

        //文件上传
        upload.render({
            elem: '#upload'
            ,url: '/hzml/api/File/upload',
            headers: {
                "token": Helper.GetToken(),
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "X-Requested-With, Content-Type, X-File-Name",
                "Access-Control-Allow-Methods": "PUT,GET,POST,OPTIONS"
            },
            done: function(res, index, upload){ //上传后的回调
                layer.msg("上传成功",{time: 1000});
                $("#upload2 input").val(res.body);
                $("#upload2").show();
                $("#upload").hide();
            } 
            ,accept: 'file' //允许上传的文件类型
            //,size: 50 //最大允许上传的文件大小
            //,……
            ,field: 'file'
            
        })

        //删除文件
        $(".delete").click(function(){
            var name = $("#upload2 input").val()
            var ids = [,name]
            $.get("/hzml/api/ReportManage/deleteFile","id="+preSelect.id+"&fileName="+name,function(res){
                if(res.response.staticCode == 0){
                    layer.msg("删除成功",{time:1000})
                    $("#upload2 input").val('');
                    $("#upload2").hide();
                    $("#upload").show();
                }   
            },'json');
            
        })

        //下载文件
        $(".view").click(function(){
           var name = $("#upload2 input").val()
           window.location.href = "/hzml/api/File/download?ids="+name;
        })

        //保存
        $("#save").click(function(){
            var body = $("#form1").serializeForm();
            Helper.Ajax("ReportManage/update",body,function(result){
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
        })
    })
})