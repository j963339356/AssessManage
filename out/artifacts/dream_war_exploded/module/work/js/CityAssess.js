define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'pipups', 'popups', 'common'], function ($, CustomTable) {
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
        $("#id").val(preSelect.id);

        //退回原因
        $("#form2 textarea[name]").each(function (i,item) {
            var data = preSelect;
            if($(item).attr("name")=='backReson'){
                $(item).val(preSelect.backReson);
            }
        })

        //提交
        $("#save").click(function(){
            //把countyScore改成cityScore
            $("#form1").find("input[name='countyScore'],input[data-name='countyScore']").each(function(i,item){
                if($(item).attr('name')=='countyScore')
                {
                    $(item).attr('name','cityScore');
                }
                else{
                    $(item).attr('data-name','cityScore');
                }
            })
            var body = $("#form1").serializeTabel();
            var body2 = {scoreList: body,cityScore: $("#sum").val(),county: preSelect.county,city: preSelect.city};
            console.log(body2);

            Pipups.confirm('确定办理该工作项?',function(){
                Helper.Ajax("Manage/cityAssess",body2,function(result){
                    if(result.response.staticCode == 0){
                        parent.Pipups.prompt("核定成功");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        parent.window.$("#query").click();
                    }
                    else{
                        parent.Pipups.prompt("核定失败");
                    }
                })
            })
        });

        //退回
        $("#back").click(function(){
            var body = $("#form2").serializeForm();
            body.id = preSelect.id
            console.log(body);
            if(body.backReson == ''){
                layer.msg('退回原因不能为空！');
                return ;
            }
            Pipups.confirm('确定要退回流程吗?',function(){
                Helper.Ajax("Manage/cityBack", body,function(result){
                    if(result.response.staticCode == 0){
                        parent.Pipups.prompt("操作成功");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        parent.window.$("#query").click();
                    }
                    else{
                        parent.Pipups.prompt("操作失败");
                    }
                })
            })
        })

        //获取分数
        Helper.Ajax("Score/getList", preSelect, function (result) {
            if (result.response.staticCode == 0) {
                $("#sum").val(preSelect.countyScore);
                fill(result.body.items);
                //复制
                $("#form1").find("input[name='countyScore'],input[data-name='countyScore']").each(function(i,item){
                    if($(item).parent().prev().html() == ''){   //防止把p6p7的是给覆盖
                        $(item).parent().prev().text($(item).val());
                    }
                })                
                console.log(result.body)
            }
            else {
                layer.msg("获取数据失败", { time: 1000 });
            }
        })

        //计算分数
        $("td").change(function(){
            var p = $(this).parent().attr('class');  //获取类
            var cur = $("#table1 ."+p); //获取当前阶级
            if(p=='p1' || p=='p2' || p=='p3' || p=='p4' || p=='p8' || p=='p9'){
                var level2 = cur.find('[level="2"]').val()
                var level3 = 0;
                $.each(cur.find('[level="3"]'),function(i,item){ 
                    level3 += parseInt($(item).val()); 
                })
                var level1 = level3 / level2 * 100            
                cur.find('[level="1"]').val(level1);
                var count = $(cur[0]).find("input[name='countyScore']").attr('data-value') / 100;
                $(cur[0]).find("input[name='countyScore']").val(parseInt(level1 * count));
                if(p == 'p4'){  //死亡率和分数是反过来的
                    $(cur[0]).find("input[name='countyScore']").val(parseInt(count*100-level1));
                }
                $(cur[1]).find("input[name='countyScore']").val(parseInt(level1));  
                //总分值大了，肯听填错数字了
                if(parseInt($(cur[3]).find("input[name='countyScore']").val()) > parseInt($(cur[2]).find("input[name='countyScore']").val())
                    || $(cur).find("input[name='countyScore']").val()<0 || $(cur[0]).find("input[name='countyScore']").val()=='NaN'){
                    layer.msg("数据填写错误",{time:1000})
                    cur.find("input[name='countyScore']").val(0); //置零
                }
            }
            if(p.indexOf("p5")==0){
                p = p.replace(/\s\d$/,'.'+p.charAt(p.length-1));
                cur = $("#table1 ."+p); //获取当前阶级
                var level2 = cur.find('[level="2"]').val()
                var level3 = 0;
                $.each(cur.find('[level="3"]'),function(i,item){
                    level3 += parseInt($(item).val());
                })
                var level1 = level3 / level2;
                var count = $(cur[0]).find("input[name='countyScore']").attr('data-value');
                $(cur[0]).find("input[name='countyScore']").val(parseInt(level1 * count));
                //总分值大了，肯听填错数字了
                if(parseInt($(cur[2]).find("input[name='countyScore']").val()) > parseInt($(cur[1]).find("input[name='countyScore']").val())
                    || $(cur).find("input[name='countyScore']").val()<0 || $(cur[0]).find("input[name='countyScore']").val()=='NaN'){
                    layer.msg("数据填写错误",{time:1000})
                    cur.find("input[name='countyScore']").val(0); //置零
                }
                //计算p5总成绩
                var c1 = $(cur.siblings(".p5.1")[0]).find("input[name='countyScore']").val();
                var c2 = $(cur.siblings(".p5.2")[0]).find("input[name='countyScore']").val();
                var c3 = $(cur.siblings(".p5.3")[0]).find("input[name='countyScore']").val();
                $("#p5").find("input[name='countyScore']").val(parseInt(c1)+parseInt(c2)+parseInt(c3));
            }
            if(p.indexOf("p6")==0 || p.indexOf("p7")==0){
                p = p.replace(/\s\d$/,'.'+p.charAt(p.length-1));
                cur = $("#table1 ."+p); //获取当前阶级
                var count = $(cur[0]).find("input[name='countyScore']").attr('data-value')
                var val = $(cur[1]).find("input[data-name='countyScore']").val()
                if(val=='是') {
                    $(cur[0]).find("input[name='countyScore']").val(count);
                    $(cur[1]).find("input[name='countyScore']").val(1)
                }else{
                    $(cur[0]).find("input[name='countyScore']").val(0);
                    $(cur[1]).find("input[name='countyScore']").val(0);
                }
                //计算p6、p7总成绩
                var c6 = 0;
                var c7 = 0;
                $("#table1 .p6:nth-child(even)").each(function(i,item){
                    c6 += parseInt($(item).find("input[name='countyScore']").val());
                })
                $("#table1 .p7:nth-child(odd)").each(function(i,item){
                    c7 += parseInt($(item).find("input[name='countyScore']").val());
                })
                $("#p6").find("input[name='countyScore']").val(c6);
                $("#p7").find("input[name='countyScore']").val(c7);
            }
            //计算总成绩
            var sum = 0;
            sum += parseInt($("#p1").find("input[name='countyScore']").val());
            sum += parseInt($("#p2").find("input[name='countyScore']").val());
            sum += parseInt($("#p3").find("input[name='countyScore']").val());
            sum += parseInt($("#p4").find("input[name='countyScore']").val());
            sum += parseInt($("#p5").find("input[name='countyScore']").val());
            sum += parseInt($("#p6").find("input[name='countyScore']").val());
            sum += parseInt($("#p7").find("input[name='countyScore']").val());
            sum += parseInt($("#p8").find("input[name='countyScore']").val());
            sum += parseInt($("#p9").find("input[name='countyScore']").val());
            $("#sum").val(sum);
        })

        //填充表格(input)
        function fill(data) {
            $("#table1 tr").each(function (j, item) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].name == $(item).find("label[name='name']").text() && data[i].p == $(item).find("input[name='p']").val()) {
                        $(item).find("input[name='countyScore']").val(data[i].countyScore);
                    }
                }
            })
            var p1 = parseInt($("#p1").find("input[name=countyScore]").attr('data-value')) * parseInt($("#p1").next().find("input[name=countyScore]").val()) / 100;
            $("#p1").find("input[name=countyScore]").val(p1);
            var p2 = parseInt($("#p2").find("input[name=countyScore]").attr('data-value')) * parseInt($("#p2").next().find("input[name=countyScore]").val()) / 100;
            $("#p2").find("input[name=countyScore]").val(p2);
            var p3 = parseInt($("#p3").find("input[name=countyScore]").attr('data-value')) * parseInt($("#p3").next().find("input[name=countyScore]").val()) / 100;
            $("#p3").find("input[name=countyScore]").val(p3);
            var p4 = parseInt($("#p4").find("input[name=countyScore]").attr('data-value')) - parseInt($("#p4").next().find("input[name=countyScore]").val());
            $("#p4").find("input[name=countyScore]").val(p4);
            var p8 = parseInt($("#p8").find("input[name=countyScore]").attr('data-value')) * parseInt($("#p8").next().find("input[name=countyScore]").val()) / 100;
            $("#p8").find("input[name=countyScore]").val(p8);
            var p9 = parseInt($("#p9").find("input[name=countyScore]").attr('data-value')) * parseInt($("#p9").next().find("input[name=countyScore]").val()) / 100;
            $("#p9").find("input[name=countyScore]").val(p9);
            //计算p5
            calculatep5();
            calculatep67(".p6");
            calculatep67(".p7");
        }

        function calculatep5() {
            for (var i = 1; i < 4; i++) {
                var p = "." + i;
                cur = $("#table1 .p5" + p); //获取当前阶级
                var level2 = cur.find('[level="2"]').val()
                var level3 = 0;
                $.each(cur.find('[level="3"]'), function (i, item) {
                    level3 += parseInt($(item).val());
                })
                var level1 = level2==0 ? 0 : level3 / level2
                var count = $(cur[0]).find("input[name='countyScore']").attr('data-value');
                $(cur[0]).find("input[name='countyScore']").val(parseInt(level1 * count));
                //总分值大了，肯听填错数字了
                if(parseInt($(cur[2]).find("input[name='countyScore']").val()) > parseInt($(cur[1]).find("input[name='countyScore']").val())
                    || $(cur).find("input[name='countyScore']").val()<0 || $(cur[0]).find("input[name='countyScore']").val()=='NaN'){
                    layer.msg("数据填写错误",{time:1000})
                    cur.find("input[name='countyScore']").val(0); //置零
                }
            }
            //计算p5总成绩
            var c1 = $(cur.siblings(".p5.1")[0]).find("input[name='countyScore']").val();
            var c2 = $(cur.siblings(".p5.2")[0]).find("input[name='countyScore']").val();
            var c3 = $(cur.siblings(".p5.3")[0]).find("input[name='countyScore']").val();
            var sum = parseInt(c1) + parseInt(c2) + parseInt(c3);
            $("#p5").find("input[name='countyScore']").val(sum);
            return sum;
        }

        function calculatep67(p) {
            for (var i = 1; i < 5; i++) {
                cur = $("#table1 " + p+"."+i); //获取当前阶级
                var count = $(cur[0]).find("input[name='countyScore']").attr('data-value')
                var val = $(cur[1]).find("input[name='countyScore']").val()
                if (val == 1) {
                    $(cur[0]).find("input[name='countyScore']").val(count);
                    $(cur[1]).find("input[data-name='countyScore']").val("是")
                } else {
                    $(cur[0]).find("input[name='countyScore']").val(0);
                    $(cur[1]).find("input[data-name='countyScore']").val("否");
                }
            }
            //计算p6、p7总成绩
            var sum = 0;
            if(p==".p6"){
                $("#table1 .p6:nth-child(even)").each(function (i, item) {
                    sum += parseInt($(item).find("input[name='countyScore']").val());
                })
                $("#p6").find("input[name='countyScore']").val(sum);
            }
            if(p==".p7"){
                $("#table1 .p7:nth-child(odd)").each(function (i, item) {
                    sum += parseInt($(item).find("input[name='countyScore']").val());
                })
                $("#p7").find("input[name='countyScore']").val(sum);
            }
            return sum;
        }        
    })
})