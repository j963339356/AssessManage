define(['/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'popups', 'common'], function ($, CustomTable) {
        var form = layui.form;
        var layer = layui.layer;
        var user = Helper.GetUser();

        init();

        //查询
        $("#query").on('click', function () {
            var param = $('.search-form').serializeForm();
            CustomTable.reload(param);

        })

        //重置
        $("#reset").on('click', function () {
            $('.search-form').find('input[type=text]:not(:disabled):not(.layui-disabled), select:not(:disabled)').val('');
        })
       
        //新增
        $("#add").click(function () {
            Popups.popIfram({
                title: ["创建"], //title和样式
                content: "Add.html",        //弹出的内容
            });
        })

        //编辑
        $("#edit").click(function () {
            if (CustomTable.getSelect().length != 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            Popups.popIfram({
                title: ["修改"], //title和样式
                content: "Edit.html",    //弹出的内容
            });
        })

        //删除
        $("#delete").click(function(){
            if (CustomTable.getSelect().length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            var data = CustomTable.getSelect();
            var body = []
            for (var i = 0; i < data.length; i++) {
                body.push(data[i].id);
            }
            Helper.Ajax("Login/delete", body, function (result) {
                if (result.response.staticCode == 0) {
                    layer.msg("删除成功", { time: 1000 }, function () {
                    });
                    $("#query").click();
                }
                else {
                    layer.msg("删除失败", { time: 1000 });
                }
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

        function init() {
            //初始化表格
            CustomTable.init({
                elem: "#table",
                url: 'http://localhost:8080/api/Login/getList', //数据接口   
                where: $('.search-form').serializeForm(),
                // toolbar: '#tool',
                // even: true, //开启隔行背景
                cols: [[ //表头
                    { checkbox: true },
                    { field: 'id', title: 'id', hide: true, align: 'center' },
                    { field: 'username', title: '账号', align: 'center' },
                    { field: 'name', title: '姓名', align: 'center' },
                    { field: 'province', title: '辖区省', align: 'center' },
                    { field: 'city', title: '辖区市', align: 'center' },
                    { field: 'county', title: '辖区县', align: 'center' },
                    { field: 'orgName', title: '单位名称', align: 'center' },
                ]]
            });
        }
    })
})

// layui.use(['element', 'table','laypage'], function () {});