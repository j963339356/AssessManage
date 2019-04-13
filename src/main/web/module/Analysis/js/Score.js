define(['/hzml/common/js/config.js'], function () {
    require(['jquery', 'customtable', 'popups', 'common'], function ($, CustomTable) {
        var layer = layui.layer;
        //初始化表格
        CustomTable.init({
            elem: "#table1", 
            url: '/hzml/api/Analysis/score', //数据接口
            where: $('.search-form').serializeForm(),
            // toolbar: '#tool',
            // even: true, //开启隔行背景
            cols: [[ //标题栏
                {field: 'city', title: '城市'}
                ,{field: 'p1', title: '行政村公路通畅率'}
                ,{field: 'p2', title: '行政村通客车率'}
                ,{field: 'p3', title: '城乡道路客运车辆公交化比率'}
                ,{field: 'p4', title: '城乡道路客运车辆交通责任事故万车死亡率'}
                ,{field: 'p5', title: '城乡道路客运基础设施一体化水平（P5）分值（150分）'} //colspan即横跨的单元格数，这种情况下不用设置field和width
                ,{field: 'p6', title: '城乡道路客运信息服务一体化水平（P6）得分(150分)'}
                ,{field: 'p7', title: '城乡道路客运发展政策一体化水平（P7）得分(150分)'}
                ,{field: 'p8', title: '镇村公共交通开通率'}
                ,{field: 'p9', title: '农村客运班车公司化率'}
            ]]
        });
        
        //查询
        $("#query").on('click', function () {
            var param = $('.search-form').serializeForm();
            CustomTable.reload(param);
        })        
    })
})