define(['/common/js/config.js'], function () {
    require(['jquery', 'common', 'helper'], function ($) {
        var user =  Helper.GetUser();
        // 基于准备好的dom，初始化echarts实例
        var pieChart = echarts.init(document.getElementById('pie'));
        var barChart = echarts.init(document.getElementById('bar'));

        //获取数据
        $("#query").click(function(){
            Helper.Ajax("Analysis/level",{year:2018,province:user.province},function(result){
                if(result.response.staticCode != 0){
                    layer.msg("获取数据失败", {time: 1000 });     
                }
                else{
                    fill(result.body);
                } 
            })   
        })

        $("#query").click();

        //测试
        // object = [{city:'广东',score:'1000'},{city:'广西',score:'900'},{city:'湛江',score:'500'}]
        // fill(object)

        //画图
        function fill(data){
            var pie = [{name:'AAAAA(900分以上)',value:0},{name:'AAAA(800~899分)',value:0},{name:'AAA(600~799分)',value:0},
                        {name:'AA(500~699分)',value:0},{name:'A(500分以下)',value:0}];            
            for(var i=0; i<data.length; i++){
                if(data[i].score>=900){
                    pie[0].value++;
                }
                if(data[i].score>=800 && data[i].score<900){
                    pie[1].value++;
                }
                if(data[i].score>=600 && data[i].score<800){
                    pie[2].value++;
                }
                if(data[i].score>=600 && data[i].score<700){
                    pie[3].value++;
                }
                if(data[i].score<500){
                    pie[4].value++;
                }
            }
            drawPie(pie);

            var bar = {city:[],score:[]};
            for(var i=0; i<data.length; i++){
                pie.push({name:data[i].city,value:data[i].score})
                bar.city.push(data[i].city);
                bar.score.push(data[i].score)
            }
            drawBar(bar);
        }

        //画饼图
        function drawPie(data){
            option = {
                title: {
                    text: '各评价等级的市（区）数量',
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
        function drawBar(data){
            option = {
                title: {
                    text: '片区的评价等级',
                    subtext: '',
                    x: 'center'
                },
                legend: {},
                tooltip: {},
                xAxis: {
                    name: '片区',
                    type: 'category',
                    data: data.city
                },
                yAxis: {
                    name: '分数',
                    type: 'value'
                },
                series: [{
                    type: 'bar',
                    barWidth: '30px',
                    data: data.score
                }]
            };
            barChart.setOption(option);
        }

        



        var data = genData(50);

        



        function genData(count) {
            var nameList = [
                '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
            ];
            var legendData = [];
            var seriesData = [];
            var selected = {};
            for (var i = 0; i < 50; i++) {
                name = Math.random() > 0.65
                    ? makeWord(4, 1) + '·' + makeWord(3, 0)
                    : makeWord(2, 1);
                legendData.push(name);
                seriesData.push({
                    name: name,
                    value: Math.round(Math.random() * 100000)
                });
                selected[name] = i < 6;
            }

            return {
                legendData: legendData,
                seriesData: seriesData,
                selected: selected
            };

            function makeWord(max, min) {
                var nameLen = Math.ceil(Math.random() * max + min);
                var name = [];
                for (var i = 0; i < nameLen; i++) {
                    name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
                }
                return name.join('');
            }
        }
    })
})