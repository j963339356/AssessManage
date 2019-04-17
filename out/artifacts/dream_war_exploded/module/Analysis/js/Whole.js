define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'common', 'helper', 'layui','customtable','nav'], function ($) {
        /**
         * 总体情况
         */
        var form = layui.form;
        var user = Helper.GetUser();
        // 基于准备好的dom，初始化echarts实例
        var pieChart = echarts.init(document.getElementById('pie'));
        var barChart = echarts.init(document.getElementById('bar'));

        //给市赋值
        $.ajaxSettings.async = false;   //同步调用
        $.getJSON("/hzml/module/manage/js/cityJson.json", "", function (data) {
            var html = '';
            for (var i = 0; i < data.length; i++) {
                html += "<option value='" + data[i].NAME + "'>" + data[i].NAME + "</option>"
            }
            $("#city").append(html);
            if (user) {
                //市级主管部门
                if (user.orgCode == 2) {
                    // $("#city").append("<option value='"+ user.city +"'>" +user.city + "</option>");
                    $("#city").val(user.city);
                    $("#city").attr("disabled", 'true');                            
                }
            }
            form.render('select');        
        })
        $.ajaxSettings.async = true;   //同步调用

        //获取数据
        $("#query").click(function () {
            var body = $(".search-form").serializeForm();
            body.province = user.province;
            Helper.Ajax("Analysis/whole", body, function (result) {
                if (result.response.staticCode != 0) {
                    layer.msg("获取数据失败", { time: 1000 });
                }
                else {
                    fill(result.body);
                }
            })
        })

        $("#query").click();

        //画图
        function fill(data) {
            var piedata = data.pie;
            var pie = [{ name: 'AAAAA(900分以上)', value: 0 }, { name: 'AAAA(800~899分)', value: 0 }, { name: 'AAA(600~799分)', value: 0 },
            { name: 'AA(500~699分)', value: 0 }, { name: 'A(500分以下)', value: 0 }];
            for (var i = 0; i < data.pie.length; i++) {
                if (piedata[i].score >= 900) {
                    pie[0].value++;
                }
                if (piedata[i].score >= 800 && piedata[i].score < 900) {
                    pie[1].value++;
                }
                if (piedata[i].score >= 700 && piedata[i].score < 800) {
                    pie[2].value++;
                }
                if (piedata[i].score >= 600 && piedata[i].score < 700) {
                    pie[3].value++;
                }
                if (piedata[i].score < 500) {
                    pie[4].value++;
                }
            }
            drawPie(pie);

            var bardata = data.bar;
            var bar = [['product', '行政村公路畅通率', '行政村客车通畅率']];
            for (var i = 0; i < bardata.length; i++) {
                bar.push([bardata[i].city,bardata[i].p1,bardata[i].p2]);
            }
            drawBar(bar);
        }

        //画饼图
        function drawPie(data) {
            option = {
                title: {
                    text: '各评价等级的市县比例',
                    subtext: '',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {c} ({d}%)"
                },
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    right: 10,
                    top: 20,
                    bottom: 20
                },
                series: [
                    {
                        name: '姓名',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        data: data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            pieChart.setOption(option);
        }

        //画柱状图
        function drawBar(data) {
            option = {
                title: {
                    text: '行政村公路和客车通畅率',
                    subtext: '',
                    x: 'center'
                },
                legend: {
                    type: 'scroll',
                    // orient: 'vertical',
                    left: 50,
                    bottom: 10
                },
                tooltip: {},
                xAxis: {
                    name: '片区',
                    type: 'category',
                },
                yAxis: {
                    name: '百分比',
                    // type: 'category',
                    // data: ['0%','10%','20%','30%','40%','50%','60%','70%','80%','90%','100%']
                },
                dataset: {
                    source: data
                },
                series: [
                    {type: 'bar',barWidth: '30px'},
                    {type: 'bar',barWidth: '30px'},
                ]
            };
            barChart.setOption(option);
        }

        //初始化表格
        CustomTable.init({
            elem: "#table1", 
            url: '/hzml/api/Analysis/wholescore', //数据接口
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            page: false,
            cols: [[ //标题栏
                {field: 'city', title: '辖区市'}
                ,{field: 'county', title: '辖区县'}
                ,{field: 'level', title: '评价等级'}
                ,{field: 'total', title: '总评价分值'}
                ,{field: 'p1', title: 'p1'}
                ,{field: 'p2', title: 'p2'}
                ,{field: 'p3', title: 'p3'}
                ,{field: 'p4', title: 'p4'}
                ,{field: 'p5', title: 'p5'} 
                ,{field: 'p6', title: 'p6'}
                ,{field: 'p7', title: 'p7'}
                ,{field: 'p8', title: 'p8'}
                ,{field: 'p9', title: 'p9'}
            ]]
        });
        
        //查询
        $("#query").on('click', function () {
            var param = $('.search-form').serializeForm();
            CustomTable.reload(param);
        }) 
    })
})