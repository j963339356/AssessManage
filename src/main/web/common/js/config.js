var common = "/common/js/";  //自己的工具
var lib = common + "lib/"; //框架
var layui = lib + "layui/lay/modules/";  //layui模块
require.config({
    //By default load any module IDs from js/lib
    baseUrl: '',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        jquery: lib + "jquery-1.10.2.min",
        layui: lib + "layui/layui.all",
        config: common + "config",
        customtable: common + "CustomTable",
        table: layui + "table",
        laypage: layui + "laypage", 
        common: common + "common",
        popups: common + "popups",

    },
    //指明依赖关系，因为是异步的，如果一个文件的加载有前置条件，这里要加上
    shim: {
        // customtable: ["layui","table","laypage"]

    }

});