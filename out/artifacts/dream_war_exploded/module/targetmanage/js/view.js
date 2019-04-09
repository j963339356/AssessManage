define(['/common/js/config.js'], function () {
    require(['jquery','common','layui','popups','helper','customtable'], function ($) {
        var form = layui.form;
        form.render('select');
        var element = layui.element;
        // element.tab({
        //     headerElem: '#tabHeader>li' //指定tab头元素项
        //     ,bodyElem: '#tabBody>.xxx' //指定tab主体元素项
        //   });   
        // element.on('tab(tab)',function(data){
        //     console.log(data)
        // })

        //自动填表
        var data = parent.CustomTable.getSelect()[0];
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

        //维度表
        CustomTable.init({
            elem: "#table",
            url: 'http://localhost:8080/api/TargetManage/dimensionList', //数据接口   
            where: data.id,
            page: false,
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            cols: [[ //表头
                { field: 'id', title: 'id', hide: true, align: 'center' },
                { field: 'name', title: '指标名称', align: 'center' },
                { field: 'meansure', title: '计量单位', align: 'center' }
            ]]
        });
    })
})
