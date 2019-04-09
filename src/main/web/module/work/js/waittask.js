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

        //市级核定
        $("#cityAssess").click(function(){
            if (CustomTable.getSelect().length != 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            Popups.popIfram({
                title: ["市级核定"], //title和样式
                content: "CityAssess.html",        //弹出的内容
            });
        })  
        
        //省级核定
        $("#provinceAssess").click(function(){
            if (CustomTable.getSelect().length != 1) {
                layer.msg("请选择一条数据", { time: 1000 });
                return;
            }
            Popups.popIfram({
                title: ["省级核定"], //title和样式
                content: "ProvinceAssess.html",        //弹出的内容
            });
        }) 

        function init() {
            //初始化表格
            CustomTable.init({
                elem: "#table",
                url: 'http://localhost:8080/api/Manage/waittaskList', //数据接口   
                where: $('.search-form').serializeForm(),
                // toolbar: '#tool',
                // even: true, //开启隔行背景
                cols: [[ //表头
                    { checkbox: true },
                    { field: 'id', title: 'id', hide: true, align: 'center' },
                    { field: 'orgName', title: '申办单位', align: 'center' },
                    { field: 'processName', title: '流程名称', align: 'center' },
                    {
                        field: 'status', title: '流程环节', align: 'center',
                        templet: function (d) {
                            if (d.status == 5) {
                                return "市级核定"
                            }
                            else if (d.status == 6) {
                                return "省级核定"
                            }
                            else{
                                return '';
                            }
                        }
                    },
                    { field: 'writeDate', title: '创建时间', align: 'center' },
                    { field: 'writerName', title: '创建人', align: 'center' },
                    { field: 'writerPhone', title: '创建人电话', align: 'center' },

                ]]
            });
        }
    })
})