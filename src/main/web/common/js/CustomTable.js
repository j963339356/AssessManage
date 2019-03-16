define(['jquery','layui'], function ($) {
        //jQuery, canvas and the app/sub module are all
    //loaded and can be used here now.
    //表格
    CustomTable = {}
    CustomTable.table = layui.table;
    CustomTable.laypage = layui.laypage;
    //当前页数
    CustomTable.pageInfo = {page:1,rows:10}
    //查询参数
    CustomTable.query = {};
    //初始化表格
    CustomTable.init = function (option) {
        var $this = $(this);  //CustomTable对象自己
        var options = {};     //设置参数
        //dataTable默认参数
        options = $.extend({}, CustomTable.defaults);
        //弄成传入的报文格式
        option.where = Request(option.where);

        $.extend(true, options, option);  //相同的属性合并
        CustomTable.query = options.where;
        CustomTable.table.render(options);
    }

    //重载表格
    CustomTable.reload = function(where){
        //重载表格
        CustomTable.table.reload('table',{
            // where: { //设定异步数据接口的额外参数，任意设
            //     aaaaaa: 'xxx', 
            //     bbb: 'yyy'
            // },
            page: {
                curr: 1 //重新从第 1 页开始
            },     
            where: Request(where)
                   
        });
    }

    //默认属性
    CustomTable.defaults = {
        elem: "#demo",
        id: 'table',
        height: 312,
        method: "post",
        headers: {
            "token": "111111"/*CwHelper.GetToken()*/,
            "Source-Type": "76d5f6283a57b2db",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Headers": "X-Requested-With"
        }
        // , contentType: "application/x-www-form-urlencoded"
        , contentType: "application/json",
        url: '/',
        page: {
            layout: ['limit', 'prev', 'page', 'next', 'count']
        },
        where: {},
        request: {
            pageName: "page", //页码的参数名称，默认：page
            limitName: "rows" //每页数据量的参数名，默认：limit
        },
        response: {
            statusCode: 0, //规定成功的状态码，默认：0            
        },
        parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
            return {                    
                "code": res.publicresponse.statuscode, //解析接口状态
                "msg": res.publicresponse.message, //解析提示文本
                "count": res.body.totalcount, //解析数据长度
                "data": res.body.items //解析数据列表
            };
        },
        limits: [10, 20, 50, 100, 200],
        cols: [],
        done: function (res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            console.log(res);
            //得到当前页码
            console.log(curr);
            CustomTable.pageInfo.page = curr;
            CustomTable.pageInfo.rows = count;
            //得到数据总量
            console.log(count);
        }
    }

    var Request = function(where){
        var body = $.extend({},{body:where});
        $.extend(body,{publicrequest:{id:"22",service:"aa"}});
        CustomTable.query = body;
        return body;
    }
    
    return CustomTable;
});
