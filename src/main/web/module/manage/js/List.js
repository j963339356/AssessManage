define(['/common/js/config.js'], function () {
    require(['jquery', 'customtable'], function ($, CustomTable) {
        //左侧下拉菜单，只有一个展开，其他自动折叠
        $(".layui-nav-tree li").click(function () {
            $(this).siblings().removeClass("layui-nav-itemed")
        })

        var table = CustomTable.table;
        //初始化表格
        CustomTable.init({
            url: 'https://easy-mock.com/mock/5bfcbaba1e288d1547186991/XinWenGuanLi/getList', //数据接口     
            where: { a: 1, b: "b" },
            toolbar: '#tool',
            even: true, //开启隔行背景
            cols: [[ //表头
                { checkbox: true },
                { field: 'ID', title: 'ID', hide: true, align: 'center' },
                { field: 'BiaoTi', title: '标题', align: 'center' },
                { field: 'GuanJianZi', title: '关键字', align: 'center' },
                { field: 'SYS_ChuangJianRen', title: '创建人', align: 'center' },
                { field: 'SYS_ChuangJianShiJian', title: '创建时间', align: 'center' },
                { field: 'ZhuangTai', title: '状态', templet: '#ZhuangTai', align: 'center' },
                { field: 'FaBuZhe', title: '发布者', align: 'center' },
                { field: 'FaBuShiJian', title: '发布时间', align: 'center' }
            ]]
        });     

        //查询
        $("#query").on('click',function () {
            // active['reload'].call(this)
            console.log($(".layui-laypage-em").siblings().text());
            CustomTable.reload({a: 1, b: "b"});
            console.log($(".layui-laypage-em").siblings().text());
        })

        //新增
        $("#add").click(function(){
            var checkStatus = table.checkStatus('table')
            console.log(checkStatus.data)
        })
    })
})

// layui.use(['element', 'table','laypage'], function () {});