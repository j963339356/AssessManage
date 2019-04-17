define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'popups', 'common','nav'], function ($, CustomTable) {
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

        //县级填报
        $("#countyReport").click(function(){
            if (CustomTable.getSelect().length != 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            //如果不是退回的，也不是没状态的，说明上报过，不二次允许上报
            if(CustomTable.getSelect()[0].status!=null && CustomTable.getSelect()[0].status!=7){
                layer.msg("不能重复上报", { time: 1000 });
                return;
            }
            Popups.popIfram({
                title: ["县级填报"], //title和样式
                content: "CountyReport.html",        //弹出的内容
            });
        })

        //市级填报
        $("#cityReport").click(function(){
            Popups.popIfram({
                title: ["市级填报"], //title和样式
                content: "CityReport.html",        //弹出的内容
            });
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
                content: "edit.html",    //弹出的内容
            });
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

        //公示
        $("#start").click(function () {
            var data = CustomTable.getSelect();
            if (data.length == 0) {
                layer.msg("请选择最少一条数据", { time: 1000 });
                return;
            }
            //市级只能公示市级未公示，省级只能公示省级未公示
            for(var i=0; i<data.length; i++){
                if((user.orgCode == 1 && data[i].status!=3) || (user.orgCode==2 && data[i].status!=1)) {   //省级
                    layer.msg("不能公示已公示的或不符合要求的数据", { time: 1000 });
                    return;
                }
            }
            var body = []
            for (var i = 0; i < data.length; i++) {
                body.push(data[i].id);
            }
            Helper.Ajax("Manage/Publicity", body, function (result) {
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

        function init() {
            //市县联动            
            initCity()
            //初始化表格
            CustomTable.init({
                elem: "#table",
                url: '/hzml/api/Manage/getList', //数据接口
                where: $('.search-form').serializeForm(),
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
                    {
                        field: 'status', title: '状态', align: 'center',
                        templet: function (d) {
                            if (d.status == 1) {
                                return "待市级公示"
                            }
                            else if (d.status == 2) {
                                return "市级已公示"
                            }
                            else if (d.status == 3) {
                                return "待省级公示"
                            }
                            else if(d.status == 4){
                                return "省级已公示"
                            }
                            else if(d.status == 7 || d.status == 8){
                                return '已退回'
                            }
                            else{
                                return '';
                            }
                        }
                    },
                    { field: 'writeDate', title: '更新时间', align: 'center' },
                    { field: 'writerName', title: '更新人', align: 'center' },

                ]]
            });
        }

        //市县联动
        function initCity() {
            $.ajaxSettings.async = false;   //同步调用
            //给市赋值
            $.getJSON("js/cityJson.json", "", function (data) {
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html += "<option value='" + data[i].NAME + "'>" + data[i].NAME + "</option>"
                }
                $("#city").append(html);
                form.render('select');
            })
            $.ajaxSettings.async = true;
            //市县联动
            form.on('select(city)', function (data) {
                console.log(data.value)
                $.getJSON("js/countyJson.json", "", function (res) {
                    var html = '';
                    for (var i = 0; i < res.length; i++) {
                        if (res[i].PARENT_ID == data.value)
                            html += "<option value='" + res[i].NAME + "'>" + res[i].NAME + "</option>"
                    }
                    $("#county").empty();
                    $("#county").append("<option value=''>请选择</option>")
                    $("#county").append(html);
                    form.render('select');
                })
            });
            if (user) {
                //市级主管部门
                if (user.orgCode == 2) {
                    // $("#city").append("<option value='"+ user.city +"'>" +user.city + "</option>");
                    $("#city").val(user.city);
                    $("#city").attr("disabled", 'true');
                    form.render('select');
                    $.getJSON("js/countyJson.json", "", function (res) {
                        var html = '';
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].PARENT_ID == user.city)
                                html += "<option value='" + res[i].NAME + "'>" + res[i].NAME + "</option>"
                        }
                        $("#county").empty();
                        $("#county").append("<option value=''>请选择</option>")
                        $("#county").append(html);
                        form.render('select');
                    })
                }
                //县级主管部门
                if (user.orgCode == 3) {
                    $("#city").append("<option value='" + user.city + "'>" + user.city + "</option>");
                    $("#city").val(user.city);
                    $("#city").attr("disabled", 'true');
                    $("#county").append("<option value='" + user.county + "'>" + user.county + "</option>");
                    $("#county").val(user.county);
                    $("#county").attr("disabled", 'true');
                    form.render('select');
                }
            }
        }
    })
})

// layui.use(['element', 'table','laypage'], function () {});