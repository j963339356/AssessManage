define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable','common','helper'], function ($, CustomTable) {
        var table = CustomTable.table;
        var user =  Helper.GetUser();
        var form = layui.form;

        //自动赋值
        $(".userInfo label[name]").each(function(i,item){
            var data = user[$(item).attr('name')]
            if(data != undefined && data != ""){
                $(item).text(data);
            }   
            if($(item).attr('name')=='date'){
                $(item).text(new Date().Format('yyyy-MM-dd'));
            }         
        });

        caculate();
        //先进行计算
        function caculate(){
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
        }

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
                }else if(val=='否'){
                    $(cur[0]).find("input[name='countyScore']").val(0);
                    $(cur[1]).find("input[name='countyScore']").val(0);
                }else{
                    layer.msg("请填写是或否",{time:1000})
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

        //保存
        $("#save").click(function(){
            var body = $("#form1").serializeTabel();
            var body2 = {scoreList: body,countyScore: $("#sum").val()};
            console.log(body2);
            Helper.Ajax("Manage/add",body2,function(result){
                if(result.response.staticCode == 0){
                    parent.Pipups.prompt("保存成功");
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                    parent.window.$("#query").click();    
                }
                else{
                    parent.Pipups.prompt("保存失败");
                }
            })    
        })

        

              

    })
})








