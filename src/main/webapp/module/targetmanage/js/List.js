define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'popups', 'common','nav'], function ($, CustomTable) {

        var layer = layui.layer;
        //初始化表格
        CustomTable.init({
            elem: "#table",
            // url: 'https://easy-mock.com/mock/5bfcbaba1e288d1547186991/XinWenGuanLi/getList', //数据接口  
            url: '/hzml/api/TargetManage/getList', //数据接口
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            cols: [[ //表头
                // { checkbox: false },
                { field: 'id', title: 'id', hide: true, align: 'center' },
                // {
                //     field: 'isStart', title: '状态', align: 'center',
                //     templet: function (d) {
                //         if (d.isStart) {
                //             return "已启用"
                //         }
                //         else {
                //             return "未启用"
                //         }
                //     }
                // },
                { field: 'p', title: '指标分类', align: 'center' },
                { field: 'name', title: '指标名称', align: 'center' },
                { field: 'meansure', title: '计量单位', align: 'center' },
                // { field: 'sysCreateTime', title: '创建日期', align: 'center' },
                // { field: 'sysCreateName', title: '创建人', align: 'center' },
                // { field: 'targetExplain', title: '说明', align: 'center' }
            ]]
        });

        //查询
        $("#query").on('click', function () {
            var param = $('.search-form').serializeForm();
            console.log(param);
            CustomTable.reload(param);
        })

        //重置
        $("#reset").on('click', function () {
            $('.search-form').find('input[type=text]:not(:disabled), select:not(:disabled)').val('');
        })

        //新增
        $("#add").click(function () {
            var data = CustomTable.getSelect();
            Popups.popIfram({
                title: ["新增"], //title和样式
                content: "add.html",        //弹出的内容
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
                content: "edit.html",    //弹出的内容
            });
        })

        //删除
        $("#delete").click(function () {
            if (CustomTable.getSelect().length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            var data = CustomTable.getSelect();
            var body = []
            for (var i = 0; i < data.length; i++) {
                body.push(data[i].id);
            }
            Helper.Ajax("TargetManage/delete", body, function (result) {
                if (result.response.staticCode == 0) {
                    layer.msg("删除成功", { time: 1000 }, function () {
                        $("#query").click();
                    });
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
            var data = CustomTable.getSelect()[0];
            Helper.Ajax("TargetManage/get", data.id, function (result) {
                if (result.response.staticCode == 0) {
                    Popups.popIfram({
                        title: ["查看"], //title和样式
                        content: "view.html",    //弹出的内容
                    });
                }
                else {
                    layer.msg("查看失败", { time: 1000 });
                }
            })
        })

        //启用
        $("#start").click(function () {
            if (CustomTable.getSelect().length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            var data = CustomTable.getSelect();
            var body = []
            for (var i = 0; i < data.length; i++) {
                body.push(data[i].id);
            }
            Helper.Ajax("TargetManage/usingTarget", body, function (result) {
                if (result.response.staticCode == 0) {
                    layer.msg("修改成功", { time: 1000 }, function () {
                        $("#query").click();
                    });
                }
                else {
                    layer.msg("修改失败", { time: 1000 });
                }
            })
        })

        //删除
        $("#unstart").click(function () {
            if (CustomTable.getSelect().length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            var data = CustomTable.getSelect();
            var body = []
            for (var i = 0; i < data.length; i++) {
                body.push(data[i].id);
            }
            Helper.Ajax("TargetManage/unUsingTarget", body, function (result) {
                if (result.response.staticCode == 0) {
                    layer.msg("修改成功", { time: 1000 }, function () {
                        $("#query").click();
                    });
                }
                else {
                    layer.msg("修改失败", { time: 1000 });
                }
            })
        })
    })
})

// layui.use(['element', 'table','laypage'], function () {});