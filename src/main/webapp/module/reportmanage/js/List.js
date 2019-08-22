define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'pipups', 'popups', 'common','nav'], function ($, CustomTable) {
        var layer = layui.layer;
        //初始化表格
        CustomTable.init({
            elem: "#table", 
            url: '/hzml/api/ReportManage/getList', //数据接口
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            cols: [[ //表头
                { checkbox: true },
                { field: 'id', title: 'id', hide: true, align: 'center' },
                { field: 'year', title: '考核年度', align: 'center' },
                {
                    field: '', title: '评价报告附件', align: 'center',
                    templet: function (d) {
                        var addr = d.reportAddr;
                        var html = '';
                        if(addr){
                            html += '<input name="reportAddr" value='+addr+' hidden>'
                                + '<a class="viewReport layui-btn layui-btn-sm layui-bg-green">查看</a>';
                        }
                        return html;
                    }
                },
                { field: 'sysUpdateTime', title: '更新时间', align: 'center' },
                { field: 'sysUpdateName', title: '更新人', align: 'center' }
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
            Pipups.confirm("是否确认删除？",function () {
                Helper.Ajax("ReportManage/delete", body, function (result) {
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

        //查看报告
        $(document).on('click',".viewReport",function() {
            var addr = $(this).prev().val()
            window.location.href = "/hzml/api/File/download?ids="+addr;
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