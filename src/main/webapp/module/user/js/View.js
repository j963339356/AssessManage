define(['/hzml/common/js/config.js'], function () {
    require(['jquery','customtable','common','layui','popups','helper'], function ($) {
        var form = layui.form;
        form.render();
        var preSelect = parent.CustomTable.getSelect()[0]; //表格选择的数据

        //自动赋值
        Helper.Ajax("Login/getacc", preSelect.id, function (result) {
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
            form.render();
        }
        
    })
})
