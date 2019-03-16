/* 展开折叠特效 */
$(document).ready(function () {
    $("#slideDown").click(function () {
        $("#panel").slideToggle();
        $(this).toggle();
        $("#slideUp").toggle();
    });
    $("#slideUp").click(function () {
        $("#panel").slideToggle();
        $(this).toggle();
        $("#slideDown").show();
    });
});

$(function () {
    //初始选择第一页，10条数据
    display(1, 10); 
    /* 要显示的记录下拉列表 */
    $("#paging-left").change(function(){
        var limits = $("#paging-left").find("option:selected").val();
        $("#curIndex").val(1);
        $("#limit").val(parseInt(limits));
        display(1,limits);
    });
    /* 查询按钮 */
    $("#add").click(function(){
        add();
    });
    
    /* 日期选择加载渲染 */
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#startdate' //指定元素
        });
        laydate.render({
            elem: '#enddate' //指定元素
        });
    });

    /* 加载form表单让select可以显示 */
    layui.use('form', function(){
        var form = layui.form; 
        // form.render();
    });
});

/* 表格 */
function showTable(data) {
    layui.use('table', function () {
        var table = layui.table;
        //执行渲染
        table.render({
            elem: '#table' //指定原始表格元素选择器（推荐id选择器）
            // , height: 600 //容器高度
            // , page: true
            , even: true  //各行背景不同    
            , limit: $("#limit").val()
            , limits: [10, 20, 50, 100, 200]
            , cols: [[//标题栏
                { checkbox: true },
                { field: 'ID', title: 'ID', hide: true, align: 'center' },
                { field: 'BiaoTi', title: '标题', align: 'center' },
                { field: 'GuanJianZi', title: '关键字', align: 'center' },
                { field: 'SYS_ChuangJianRen', title: '创建人', align: 'center' },
                { field: 'SYS_ChuangJianShiJian', title: '创建时间', align: 'center' },
                { field: 'ZhuangTai', title: '状态', templet: '#ZhuangTai', align: 'center' },
                { field: 'FaBuZhe', title: '发布者', align: 'center' },
                { field: 'FaBuShiJian', title: '发布时间', align: 'center' }
            ]] //设置表头
            , data: data
        });
    });
}

/* 分页 */
function fenye(){
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'paging-right' //注意，这里是ID，不用加 # 号
            , count: $("#totalCount").val() //数据总数，从服务端得到
            , limit: $("#limit").val()  //显示的记录数
            , limits: [10, 20, 50, 100, 200]
            , groups: 3 //连续出现的页数
            , curr: $("#curIndex").val()
            , prev: '<' //上一页内容
            , next: '>' //下一页内容
            // ,first: '<<' //首页内容
            // ,last: '>>' //尾页内容
            , layout: ['prev', 'page', 'next'] //显示顺序
            ,jump: function(obj,first){
                if(!first){
                    $("#limit").val(obj.limit);
                    $("#curIndex").val(obj.curr);
                    display(obj.cur,obj.limit);
                }
            }
        });
    });
}

/* 查询数据库 */
function display(curPage, limits) {
    var body = { "curpage": curPage,"limits": limits };
    doAjax("00230048001", body, function (result) {
        $("#totalCount").val(result.body.totalcount); //总记录数
        $("#curCount").val(result.body.items.length); //当前显示的记录数
        data = result.body.items;
        showTable(data);
        fenye();
        /* 底端记录标签 */
        var totalcount = result.body.totalcount; //总记录数
        var curIndex = $("#curIndex").val(); //当前页数
        var curCount = result.body.items.length;    //当前页显示的记录数
        var limit = $("#limit").val();  //每页应该显示的记录数
        var one = (curIndex-1)*limit+1;
        var two = (curIndex-1)*limit+curCount;
        var uhtml = "第 "+one+" 到 "+two+" 共 "+totalcount+" 条";
        $("#jilu").html(uhtml);
    });
}

/* 请求服务器 */
var doAjax = function (servicCord, body, ajax) {
    var fuwu = {
        "publicrequest": {
            "sysid": "65C2F59E-AB3D-4505-812B-0D1EBEA44189",
            "reqid": "D7677BE6-9190-476C-81A3-BB95563FA3FE",
            "protover": "1.0",
            "servicecode": servicCord,
            "servicever": "1.0",
            "requesttime": "20180306154203524",
            "signdata": "",
            "reserve": ""
        },
        "body": {
            "BiaoTi": "",
            "GuanJianZi": "",
            "ZhuangTai": "",
            "StartFaBuShiJian": "",
            "StopFaBuShiJian": "",
            "YeShu": "",
            "JiLuShu": ""
        }
    }
    // fuwu.body = body;
    if ($.type(ajax) == "function") {
        var callback = ajax;
        ajax = {
            success: function (d) {
                if ($.type(d) == "string") {
                    d = JSON.parse(d);
                }
                callback(d);
            }
        };
    }
    var ajaxObj = $.extend({
        url: "https://www.easy-mock.com/mock/5bee167a0be39b27d3453259/example/layuitable"
        , type: "GET"
        , data: fuwu
        , dataType: "json"
        // ,success: function(result){}
        , error: function () { }
        , complete: function () { }
    }, ajax);
    $.ajax(ajaxObj);
};

/* 弹出新增页面 */
var add = function(){
    layui.use('layer', function(){
        var layer = layui.layer;   
        layer.open({
            type: 2
            ,title: ['新增信息','background:#35b597;']
            ,closeBtn: 1
            ,area: ['99%', '99%']
            ,content:"add.html"
        });
    });   
};






