define(['/common/js/config.js'], function () {
    require(['jquery', 'common', 'helper', 'layui'], function ($, CustomTable) {
        upload = layui.upload;
        form = layui.form;
        form.render();
        var preSelect = parent.CustomTable.getSelect()[0]; //表格选择的数据

        //自动赋值
        var data = CustomTable.getSelect()[0];
        Helper.Ajax("ReportManage/get", data.id, function (result) {
            if (result.response.staticCode == 0) {
                fill(preSelect);
            }
            else {
                layer.msg("加载数据失败", { time: 1000 });
            }
        })
        
        function fill(data) {
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
        if (preSelect.reportAddr) {
            $("#upload2").show();
        }

        //下载文件
        $(".view").click(function () {
            var name = $("#upload2 input").val()
            window.location.href = "http://localhost:8080/api/File/download?ids=" + name;
        })
    })
})