define(['layui'], function () {
    Popups = {};
    Popups.layer = layui.layer;

    //弹出页面
    Popups.popIfram = function(title){
        var index = this.layer.open({
            type: 2,    //弹出iframe层
            title: [title,'color: white'], //title和样式
            content: "add.html",        //弹出的内容
            skin: "layui-layer-molv",   //墨绿title
            // offset: 'lt',    //快捷设置左上角
            area: ['320px', '195px'],   //弹出框大小['500','400']
            // maxmin: true,       //开启最大化按钮
            // resize: false,      //是否允许拉伸
            // maxWidth: 1920,
            success: function(layero, index){
                // layer.iframeAuto(index);
            }
        })
        layer.full(index);
    }

    return Popups;
})