define(['/hzml/common/js/config.js'], function () {
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
            //市县联动            
            initCity()
            //初始化表格
            CustomTable.init({
                elem: "#table",
                url: '/hzml/api/Manage/provinceNoticeList', //数据接口
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
                    { field: 'noticeStart', title: '公示开始时间', align: 'center' },
                    { field: 'noticeEnd', title: '公示结束时间', align: 'center' },

                ]]
            });
        }

        //市县联动
        function initCity() {
            $.ajaxSettings.async = false;   //同步调用
            //给市赋值
            $.getJSON("/hzml/module/manage/js/cityJson.json", "", function (data) {
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
                $.getJSON("/hzml/module/manage/js/countyJson.json", "", function (res) {
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
                    $.getJSON("/hzml/module/manage/js/countyJson.json", "", function (res) {
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