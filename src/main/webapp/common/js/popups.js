define(['jquery','layui'], function ($) {
    Popups = {};
    layer = layui.layer;

    //弹出页面
    Popups.popIfram = function(option){
        var options = {};     //设置参数
        //默认参数
        options = $.extend({}, this.defaults);
        $.extend(true, options, option);  //相同的属性合并

        var index = layer.open(options);
        layer.full(index);
    }

    Popups.defaults = {
        type: 2,    //弹出iframe层
        title: ["弹出框",'color: white'], //title和样式
        // content: "add.html",        //弹出的内容
        skin: "layui-layer-molv",   //墨绿title
        // offset: 'lt',    //快捷设置左上角
        area: ['320px', '195px'],   //弹出框大小['500','400']
        maxmin: true,       //开启最大化按钮
        // resize: false,      //是否允许拉伸
        // maxWidth: 1920,
        success: function(layero, index){
            // layer.iframeAuto(index);
        }
    }

    return Popups;
})