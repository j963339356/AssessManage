define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'pipups', 'popups', 'common'], function ($, CustomTable) {
        var form = layui.form;
        var layer = layui.layer;
        var user = Helper.GetUser();
        var preSelect = parent.CustomTable.getSelect()[0]; //表格选择的数据

        init();

        //市级填报
        $("#cityReport").click(function(){
            var data = CustomTable.getSelect()
            if (data.length < 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            Pipups.confirm('确定提交申请？',function(){
                var body = []
                for (var i = 0; i < data.length; i++) {
                    body.push(data[i].id);
                }
                Helper.Ajax("Manage/cityReport", body, function (result) {
                    if (result.response.staticCode == 0) {
                        layer.msg("上报成功", { time: 1000 });
                        CustomTable.reload({year: 2018});
                    }
                    else {
                        layer.msg("修改失败", { time: 1000 });
                    }
                })
            })
        })
        
        //查看
        $("#view").click(function () {
            if (CustomTable.getSelect().length != 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            Popups.popIfram({
                title: ["查看"], //title和样式
                content: "View.html",    //弹出的内容
            });
        })

        //删除
        $("#delete").click(function () {
            var data = CustomTable.getSelect();
            if (data.length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            Pipups.confirm('是否确认删除？',function(){
                var body = []
                for (var i = 0; i < data.length; i++) {
                    body.push(data[i].id);
                }
                Helper.Ajax("Manage/deleteCounty", body, function (result) {
                    if (result.response.staticCode == 0) {
                        layer.msg("删除成功", { time: 1000 },function(){
                            CustomTable.reload({year:2018, city:user.city});
                        });
                    }
                    else {
                        layer.msg("删除失败", { time: 1000 });
                    }
                })
            })
        })        

        function init() {
            //自动赋值
            $(".userInfo label[name]").each(function (i, item) {
                var data = user[$(item).attr('name')]
                if(data != undefined && data != ""){
                    $(item).text(data);
                }   
                if($(item).attr('name')=='date'){
                    $(item).text(new Date().Format('yyyy-MM-dd'));
                }     
            });



            //初始化表格
            CustomTable.init({
                elem: "#table1",
                url: '/hzml/api/Manage/cityReportList', //数据接口
                where: {year:2018, city:user.city},
                // toolbar: '#tool',
                // even: true, //开启隔行背景
                cols: [[ //表头
                    { checkbox: true },
                    { field: 'id', title: 'id', hide: true, align: 'center' },
                    { field: 'year', title: '考核年度', align: 'center' },
                    { field: 'city', title: '辖区市', align: 'center' },
                    { field: 'county', title: '辖区县', align: 'center' },
                    { field: 'orgName', title: '单位名称', align: 'center' },
                    { field: 'provinceScore', title: '评价分值', align: 'center' },
                    { field: 'level', title: '评价等级', align: 'center' },     
                ]]
            });
        }        
    })
})

// layui.use(['element', 'table','laypage'], function () {});