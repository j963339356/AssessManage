define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'common', 'helper', 'layui','customtable','nav'], function ($) {
        /**
         * 城乡客运交通事故情况折线图
         */
        var form = layui.form;
        var user = Helper.GetUser();
        // 基于准备好的dom，初始化echarts实例
        var lineChart = echarts.init(document.getElementById('line'));
        var countyList = [];    //县
        var countyScore = [];   //县的分数

        initCity();

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
            $.ajaxSettings.async = true;
        }

        //获取数据
        $("#query").click(function () {
            var body = $(".search-form").serializeForm();
            body.province = user.province;
            Helper.Ajax("Analysis/kyjqsgqk", body, function (result) {
                if (result.response.staticCode != 0) {
                    layer.msg("获取数据失败", { time: 1000 });
                }
                else {
                    fill(result.body.items);
                }
            })
            CustomTable.reload(body);
        })

        $("#query").click();

        //画图
        function fill(data) {
            countyList = [];
            countyScore = [];
            $.getJSON("/hzml/module/manage/js/countyJson.json", "", function (res) {
                var html = '';
                for (var i = 0; i < res.length; i++) {
                    if (res[i].PARENT_ID == $(".search-form").serializeForm().city) {
                        countyList.push(res[i].NAME);
                        countyScore.push(0);
                    }
                }
                //设置通畅率
                for(var i=0; i<countyList.length; i++){
                    for(var j=0; j<data.length; j++){
                        if(countyList[i]==data[j].county){
                            countyScore[i] = data[j].rate;
                        }
                    }
                }
                option = {
                    title: {
                        text: '城乡道路客运车辆交通责任事故万车死亡率',
                        subtext: '',
                        x: 'center'
                    },
                    legend: {
                        type: 'scroll',
                        left: 90,
                        bottom: 0
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        name: '片区',
                        type: 'category',
                        data: countyList
                    },
                    yAxis: {
                        name: '百分比',
                        type: 'value',
                        max: 100
                    },
                    series: [{
                        name:"2018",
                        data: countyScore,
                        type: 'line',
                        symbolSize:8
                    }]
                };
                lineChart.setOption(option)
            })
        }

        //初始化表格
        CustomTable.init({
            elem: "#table1",
            url: '/hzml/api/Analysis/kyjqsgqk', //数据接口
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            page: false,
            cols: [[ //标题栏
                {field: 'city', title: '辖区市'}
                ,{field: 'county', title: '辖区县'}
                ,{field: 'level', title: '评价等级'}
                ,{field: 'score', title: '总评价分值'}
                ,{field: 'pScore', title: 'P4分值'}
                ,{field: 'rate', title: '城乡客车交通事故死亡率（人/万车）'}
                ,{field: 'name1', title: '城乡客车交通事故死亡人数'}
                ,{field: 'name2', title: '城乡客运车辆数'}
            ]]
        });
    })
})
