define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'popups', 'common'], function ($, CustomTable) {
        var table = CustomTable.table;
        var user = Helper.GetUser();
        var form = layui.form;
        var preSelect = parent.CustomTable.getSelect()[0]; //表格选择的数据

        //自动赋值
        $(".userInfo label[name]").each(function (i, item) {
            var data = preSelect[$(item).attr('name')]
            if (data != undefined && data != "") {
                $(item).text(data);
            }
        });

        //退回原因
        $("#form2 [name]").each(function (i,item) {
            var data = preSelect;
            if($(item).attr("name")=='backReson'){
                $(item).val(preSelect.backReson);
            }
        })

        //获取分数
        Helper.Ajax("Score/getList", preSelect, function (result) {
            if (result.response.staticCode == 0) {
                $("#sum").text(preSelect.countyScore);
                fill(result.body.items);
                if(preSelect.cityScore){
                    $("#sum2").text(preSelect.cityScore);
                    fill2(result.body.items);
                }
                if(preSelect.provinceScore){
                    $("#sum3").text(preSelect.provinceScore);
                    fill3(result.body.items);
                }
                console.log(result.body)
            }
            else {
                layer.msg("获取数据失败", { time: 1000 });
            }
        })        

        //填充表格
        function fill(data) {
            $("#table1 tr").each(function (j, item) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name == $(item).find("label[name='name']").text() && data[i].p == $(item).find("label[name='p']").attr('value')) {
                        $(item).find("label[name='countyScore']").text(data[i].countyScore);
                    }
                }
            })
            //县
            var p1 = parseInt($("#p1").find("label[name=countyScore]").attr('data-value')) * parseInt($("#p1").next().find("label[name=countyScore]").text()) / 100;
            $("#p1").find("label[name=countyScore]").text(p1);
            var p2 = parseInt($("#p2").find("label[name=countyScore]").attr('data-value')) * parseInt($("#p2").next().find("label[name=countyScore]").text()) / 100;
            $("#p2").find("label[name=countyScore]").text(p2);
            var p3 = parseInt($("#p3").find("label[name=countyScore]").attr('data-value')) * parseInt($("#p3").next().find("label[name=countyScore]").text()) / 100;
            $("#p3").find("label[name=countyScore]").text(p3);
            var p4 = parseInt($("#p4").find("label[name=countyScore]").attr('data-value')) - parseInt($("#p4").next().find("label[name=countyScore]").text());
            $("#p4").find("label[name=countyScore]").text(p4);
            var p8 = parseInt($("#p8").find("label[name=countyScore]").attr('data-value')) * parseInt($("#p8").next().find("label[name=countyScore]").text()) / 100;
            $("#p8").find("label[name=countyScore]").text(p8);
            var p9 = parseInt($("#p9").find("label[name=countyScore]").attr('data-value')) * parseInt($("#p9").next().find("label[name=countyScore]").text()) / 100;
            $("#p9").find("label[name=countyScore]").text(p9);            

            //计算p5
            calculatep5();
            calculatep67(".p6");
            calculatep67(".p7");
        }

        function calculatep5() {
            for (var i = 1; i < 4; i++) {
                var p = "." + i;
                cur = $("#table1 .p5" + p); //获取当前阶级
                //县
                var level2 = cur.find('[level="2"][name="countyScore"]').text()
                var level3 = 0;
                $.each(cur.find('[level="3"][name="countyScore"]'), function (i, item) {
                    level3 += parseInt($(item).text());
                })
                var level1 = level2==0?0:level3/level2;
                var count = $(cur[0]).find("label[name='countyScore']").attr('data-value');
                $(cur[0]).find("label[name='countyScore']").text(parseInt(level1 * count));
                //验证除0错误
                if($(cur[0]).find("input[name='countyScore']").val()=='NaN'){
                    $(cur[0]).find("label[name='cityScore']").text(0);
                }
            }
            //计算p5总成绩
            //县
            var c1 = $(cur.siblings(".p5.1")[0]).find("label[name='countyScore']").text();
            var c2 = $(cur.siblings(".p5.2")[0]).find("label[name='countyScore']").text();
            var c3 = $(cur.siblings(".p5.3")[0]).find("label[name='countyScore']").text();
            var sum = parseInt(c1) + parseInt(c2) + parseInt(c3);
            $("#p5").find("label[name='countyScore']").text(sum);
        }

        function calculatep67(p) {
            for (var i = 1; i < 5; i++) {
                cur = $("#table1 " + p+"."+i); //获取当前阶级
                //县
                var count = $(cur[0]).find("label[name='countyScore']").attr('data-value')
                var val = $(cur[1]).find("label[name='countyScore']").text()
                if (val == 1) {
                    $(cur[0]).find("label[name='countyScore']").text(count);
                    $(cur[1]).find("label[data-name='countyScore']").text("是")
                } else {
                    $(cur[0]).find("label[name='countyScore']").text(0);
                    $(cur[1]).find("label[data-name='countyScore']").text("否");
                }
            }
            //计算p6、p7总成绩
            var sum = 0;
            var sum2 = 0;
            var sum3 = 0;
            if(p==".p6"){
                $("#table1 .p6:nth-child(even)").each(function (i, item) {
                    sum += parseInt($(item).find("label[name='countyScore']").text());
                })
                $("#p6").find("label[name='countyScore']").text(sum);
            }
            if(p==".p7"){
                $("#table1 .p7:nth-child(odd)").each(function (i, item) {
                    sum += parseInt($(item).find("label[name='countyScore']").text());
                })
                $("#p7").find("label[name='countyScore']").text(sum);
            }
        }

        //填充市分数
        function fill2(data) {
            $("#table1 tr").each(function (i, item) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name == $(item).find("label[name='name']").text() || data[i].p == $(item).find("label[name='p']").val()) {
                        $(item).find("label[name='cityScore']").text(data[i].cityScore);
                    }
                }
            })
            var p1 = parseInt($("#p1").find("label[name=cityScore]").attr('data-value')) * parseInt($("#p1").next().find("label[name=cityScore]").text()) / 100;
            $("#p1").find("label[name=cityScore]").text(p1);
            var p2 = parseInt($("#p2").find("label[name=cityScore]").attr('data-value')) * parseInt($("#p2").next().find("label[name=cityScore]").text()) / 100;
            $("#p2").find("label[name=cityScore]").text(p2);
            var p3 = parseInt($("#p3").find("label[name=cityScore]").attr('data-value')) * parseInt($("#p3").next().find("label[name=cityScore]").text()) / 100;
            $("#p3").find("label[name=cityScore]").text(p3);
            var p4 = parseInt($("#p4").find("label[name=cityScore]").attr('data-value')) - parseInt($("#p4").next().find("label[name=cityScore]").text());
            $("#p4").find("label[name=cityScore]").text(p4);
            var p8 = parseInt($("#p8").find("label[name=cityScore]").attr('data-value')) * parseInt($("#p8").next().find("label[name=cityScore]").text()) / 100;
            $("#p8").find("label[name=cityScore]").text(p8);
            var p9 = parseInt($("#p9").find("label[name=cityScore]").attr('data-value')) * parseInt($("#p9").next().find("label[name=cityScore]").text()) / 100;
            $("#p9").find("label[name=cityScore]").text(p9);

            //计算p5
            citycalculatep5();
            citycalculatep67(".p6");
            citycalculatep67(".p7");
        
            function citycalculatep5() {
                for (var i = 1; i < 4; i++) {
                    var p = "." + i;
                    cur = $("#table1 .p5" + p); //获取当前阶级                    
                    var level22 = cur.find('[level="2"][name="cityScore"]').text()
                    var level32 = 0;
                    $.each(cur.find('[level="3"][name="cityScore"]'), function (i, item) {
                        level32 += parseInt($(item).text());
                    })
                    var level12 = level22==0?0:level32 / level22
                    var count2 = $(cur[0]).find("label[name='cityScore']").attr('data-value');
                    $(cur[0]).find("label[name='cityScore']").text(parseInt(level12 * count2));
                }
                //计算p5总成绩
                var c12 = $(cur.siblings(".p5.1")[0]).find("label[name='cityScore']").text();
                var c22 = $(cur.siblings(".p5.2")[0]).find("label[name='cityScore']").text();
                var c32 = $(cur.siblings(".p5.3")[0]).find("label[name='cityScore']").text();
                var sum2 = parseInt(c12) + parseInt(c22) + parseInt(c32);
                $("#p5").find("label[name='cityScore']").text(sum2);
            }
    
            function citycalculatep67(p) {
                for (var i = 1; i < 5; i++) {
                    cur = $("#table1 " + p+"."+i); //获取当前阶级
                    //市
                    count = $(cur[0]).find("label[name='cityScore']").attr('data-value')
                    val = $(cur[1]).find("label[name='cityScore']").text()
                    if (val == 1) {
                        $(cur[0]).find("label[name='cityScore']").text(count);
                        $(cur[1]).find("label[data-name='cityScore']").text("是")
                    } else {
                        $(cur[0]).find("label[name='cityScore']").text(0);
                        $(cur[1]).find("label[data-name='cityScore']").text("否");
                    }
                }
                //计算p6、p7总成绩
                var sum = 0;
                var sum2 = 0;
                var sum3 = 0;
                if(p==".p6"){
                    $("#table1 .p6:nth-child(even)").each(function (i, item) {
                        sum2 += parseInt($(item).find("label[name='cityScore']").text());
                    })
                    $("#p6").find("label[name='cityScore']").text(sum2);
                }
                if(p==".p7"){
                    $("#table1 .p7:nth-child(odd)").each(function (i, item) {
                        sum2 += parseInt($(item).find("label[name='cityScore']").text());
                    })
                    $("#p7").find("label[name='cityScore']").text(sum2);
                }
            }
        }

        //省
        function fill3(data) {
            $("#table1 tr").each(function (i, item) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name == $(item).find("label[name='name']").text() || data[i].p == $(item).find("label[name='p']").val()) {
                        $(item).find("label[name='provinceScore']").text(data[i].provinceScore);
                    }
                }
            })
            var p1 = parseInt($("#p1").find("label[name=provinceScore]").attr('data-value')) * parseInt($("#p1").next().find("label[name=provinceScore]").text()) / 100;
            $("#p1").find("label[name=provinceScore]").text(p1);
            var p2 = parseInt($("#p2").find("label[name=provinceScore]").attr('data-value')) * parseInt($("#p2").next().find("label[name=provinceScore]").text()) / 100;
            $("#p2").find("label[name=provinceScore]").text(p2);
            var p3 = parseInt($("#p3").find("label[name=provinceScore]").attr('data-value')) * parseInt($("#p3").next().find("label[name=provinceScore]").text()) / 100;
            $("#p3").find("label[name=provinceScore]").text(p3);
            var p4 = parseInt($("#p4").find("label[name=provinceScore]").attr('data-value')) - parseInt($("#p4").next().find("label[name=provinceScore]").text());
            $("#p4").find("label[name=provinceScore]").text(p4);
            var p8 = parseInt($("#p8").find("label[name=provinceScore]").attr('data-value')) * parseInt($("#p8").next().find("label[name=provinceScore]").text()) / 100;
            $("#p8").find("label[name=provinceScore]").text(p8);
            var p9 = parseInt($("#p9").find("label[name=provinceScore]").attr('data-value')) * parseInt($("#p9").next().find("label[name=provinceScore]").text()) / 100;
            $("#p9").find("label[name=provinceScore]").text(p9);

            //计算p5
            citycalculatep5();
            citycalculatep67(".p6");
            citycalculatep67(".p7");
        
            function citycalculatep5() {
                for (var i = 1; i < 4; i++) {
                    var p = "." + i;
                    cur = $("#table1 .p5" + p); //获取当前阶级                    
                    var level22 = cur.find('[level="2"][name="provinceScore"]').text()
                    var level32 = 0;
                    $.each(cur.find('[level="3"][name="provinceScore"]'), function (i, item) {
                        level32 += parseInt($(item).text());
                    })
                    var level12 = level22==0?0:level32 / level22
                    var count2 = $(cur[0]).find("label[name='provinceScore']").attr('data-value');
                    $(cur[0]).find("label[name='provinceScore']").text(parseInt(level12 * count2));
                }
                //计算p5总成绩
                var c12 = $(cur.siblings(".p5.1")[0]).find("label[name='provinceScore']").text();
                var c22 = $(cur.siblings(".p5.2")[0]).find("label[name='provinceScore']").text();
                var c32 = $(cur.siblings(".p5.3")[0]).find("label[name='provinceScore']").text();
                var sum2 = parseInt(c12) + parseInt(c22) + parseInt(c32);
                $("#p5").find("label[name='provinceScore']").text(sum2);
            }
    
            function citycalculatep67(p) {
                for (var i = 1; i < 5; i++) {
                    cur = $("#table1 " + p+"."+i); //获取当前阶级
                    //市
                    count = $(cur[0]).find("label[name='provinceScore']").attr('data-value')
                    val = $(cur[1]).find("label[name='provinceScore']").text()
                    if (val == 1) {
                        $(cur[0]).find("label[name='provinceScore']").text(count);
                        $(cur[1]).find("label[data-name='provinceScore']").text("是")
                    } else {
                        $(cur[0]).find("label[name='provinceScore']").text(0);
                        $(cur[1]).find("label[data-name='provinceScore']").text("否");
                    }
                }
                //计算p6、p7总成绩
                var sum = 0;
                var sum2 = 0;
                var sum3 = 0;
                if(p==".p6"){
                    $("#table1 .p6:nth-child(even)").each(function (i, item) {
                        sum2 += parseInt($(item).find("label[name='provinceScore']").text());
                    })
                    $("#p6").find("label[name='provinceScore']").text(sum2);
                }
                if(p==".p7"){
                    $("#table1 .p7:nth-child(odd)").each(function (i, item) {
                        sum2 += parseInt($(item).find("label[name='provinceScore']").text());
                    })
                    $("#p7").find("label[name='provinceScore']").text(sum2);
                }
            }
        }
    })
})