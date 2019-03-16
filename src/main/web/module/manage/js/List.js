define(['/common/js/config.js'], function () {
    require(['jquery','customtable','popups','common'], function ($, CustomTable) {
        //左侧下拉菜单，只有一个展开，其他自动折叠
        $(".layui-nav-tree li").click(function () {
            $(this).siblings().removeClass("layui-nav-itemed")
        })
var layer = layui.layer;
        //初始化表格
        CustomTable.init({
            elem: "#table",
            url: 'https://easy-mock.com/mock/5bfcbaba1e288d1547186991/XinWenGuanLi/getList', //数据接口     
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
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
            var param = $('.search-form').serializeForm();
            CustomTable.reload(param);
        })

        //重置
        $("#reset").on('click',function () {
            $('.search-form').find('input[type=text]:not(:disabled), select:not(:disabled)').val('');
        })

        //新增
        $("#add").click(function(){
            var data = CustomTable.getSelect();
            Popups.popIfram("新增");
        })

        //编辑
        $("#edit").click(function(){
            var data = CustomTable.getSelect();
            console.log(data)
        })

        //删除
        $("#delete").click(function(){
            var data = CustomTable.getSelect();
            console.log(data)
        })

        //查看
        $("#view").click(function(){
            var data = CustomTable.getSelect();
            console.log(data)
        })
    })
})

// layui.use(['element', 'table','laypage'], function () {});