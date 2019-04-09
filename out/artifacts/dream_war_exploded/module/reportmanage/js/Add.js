define(['/common/js/config.js'], function () {
    require(['jquery','common','helper','layui'], function ($, CustomTable) {
        upload = layui.upload;
        form = layui.form;
        form.render();

        //文件上传
        upload.render({
            elem: '#upload'
            ,url: 'http://localhost:8080/api/File/upload',
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
            $.get("http://localhost:8080/api/File/delete","ids="+name,function(res){
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
           window.location.href = "http://localhost:8080/api/File/download?ids="+name;
        })

        //保存
        $("#save").click(function(){
            var body = $("#form1").serializeForm();
            Helper.Ajax("ReportManage/add",body,function(result){
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