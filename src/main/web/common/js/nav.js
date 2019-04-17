define(['jquery'], function ($) {
    /**
     * 左侧导航栏控制
     * @type {string}
     */
    var href = window.location.href.substr(26);
    //如果是一级菜单
    if ($(".layui-side-scroll .layui-nav-item>a[href='" + href + "']").parent().attr('class') == "layui-nav-item") {
        $(".layui-side-scroll .layui-nav-item>a[href='" + href + "']").parent().addClass("layui-nav-itemed");
    }
    //如果是二级菜单
    if ($(".layui-side-scroll a[href='" + href + "']").parent()[0].localName == "dd") {
        $(".layui-side-scroll a[href='" + href + "']").parent().parent().parent().addClass("layui-nav-itemed");
        $(".layui-side-scroll a[href='" + href + "']").parent().addClass("layui-this"); //设置二级菜单
    }
})