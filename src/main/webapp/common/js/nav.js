define(['jquery','layui','helper'], function ($) {
    var element = layui.element;
    var user = Helper.GetUser();
    /**
     * 左侧导航栏控制
     * @type {string}
     */

    /**
     * 根据权限动态添加导航栏
     */
    $(".layui-nav.layui-nav-tree").empty();
    var html = '';
    html = '<li class="layui-nav-item">\n' +
        '         <a class="" href="/hzml/module/targetmanage/List.html"><i class="layui-icon">&#xe60a;</i> 考核指标管理</a>\n' +
        '       </li>\n' +
        '       <li class="layui-nav-item">\n' +
        '           <a href="/hzml/module/manage/List.html"><i class="layui-icon">&#xe60a;</i> 考核管理</a>\n' +
        '       </li>\n' +
        '       <li class="layui-nav-item">\n' +
        '           <a href="javascript:;"><i class="layui-icon">&#xe667;</i> 考核信息公示查询</a>\n' +
        '           <dl class="layui-nav-child">\n' +
        '               <dd><a href="/hzml/module/infopublicity/ProvinceList.html">省级公示信息查询</a></dd>\n' +
        '               <dd data-code="23"><a href="/hzml/module/infopublicity/CityList.html">市级公示信息查询</a></dd>\n' +
        '           </dl>\n' +
        '       </li>\n' +
        '       <li class="layui-nav-item" data-code="1"><a href="/hzml/module/reportmanage/List.html"><i class="layui-icon">&#xe60a;</i> 考核评价报告管理</a></li>\n' +
        '       <li class="layui-nav-item" data-code="12">\n' +
        '           <a href="javascript:;"><i class="layui-icon">&#xe62c;</i> 考核统计分析</a>\n' +
        '           <dl class="layui-nav-child">\n' +
        '               <dd data-code="1"><a href="/hzml/module/Analysis/Level.html">评价等级统计</a></dd>\n' +
        '               <dd data-code="1"><a href="/hzml/module/Analysis/Score.html">评价分值统计</a></dd>\n' +
        '               <dd data-code="12"><a href="/hzml/module/Analysis/Whole.html">总体情况</a></dd>\n' +
        '               <dd data-code="12"><a href="/hzml/module/Analysis/Gltcqk.html">行政村公路通畅情况</a></dd>\n' +
        '               <dd data-code="12"><a href="/hzml/module/Analysis/Kctcqk.html">行政村客车通畅情况</a></dd>\n' +
        '               <dd data-code="12"><a href="/hzml/module/Analysis/Kcgjhqk.html">城乡客运公交化情况</a></dd>\n' +
        '             <dd data-code="12"><a href="/hzml/module/Analysis/Kyjtsgqk.html">城乡客运交通事故情况</a></dd>\n' +
        '             <dd data-code="12"><a href="/hzml/module/Analysis/Kyjcssqk.html">城乡客运基础设施情况</a></dd>\n' +
        '             <dd data-code="12"><a href="/hzml/module/Analysis/Kyxxfwqk.html">城乡客运信息服务情况</a></dd>\n' +
        '             <dd data-code="12"><a href="/hzml/module/Analysis/Kyfzzcqk.html">城乡客运发展政策情况</a></dd>\n' +
        '         </dl>\n' +
        '     </li>\n' +
        '     <li class="layui-nav-item" data-code="12">\n' +
        '         <a href="javascript:;"><i class="layui-icon">&#xe665;</i> 工作事项</a>\n' +
        '         <dl class="layui-nav-child">\n' +
        '             <dd><a href="/hzml/module/work/waittask.html">待处理件</a></dd>\n' +
        '         </dl>\n' +
        '     </li>\n' +
        '     <li class="layui-nav-item" data-code="0">\n' +
        '         <a href="/hzml/module/user/List.html"><i class="layui-icon">&#xe770;</i> 用户管理</a>\n' +
        '     </li>';
    $(".layui-nav.layui-nav-tree").append(html);
    $("[data-code]").hide();
    if(user) {
        $("[data-code]").each(function (i, item) {
            if ($(item).attr("data-code").indexOf(user.orgCode) != -1) {
                $(item).show();
            }
        })
    }

    /**
     * 高亮显示当前导航位置
     */
    // var href = window.location.href.substr(26);
    var href = window.location.href.match(/\/hzml.*/)[0];
    //如果是一级菜单
    if ($(".layui-side-scroll .layui-nav-item>a[href='" + href + "']").parent().attr('class') == "layui-nav-item") {
        $(".layui-side-scroll .layui-nav-item>a[href='" + href + "']").parent().addClass("layui-nav-itemed");
    }
    //如果是二级菜单
    if ($(".layui-side-scroll a[href='" + href + "']").parent()[0].localName == "dd") {
        $(".layui-side-scroll a[href='" + href + "']").parent().parent().parent().addClass("layui-nav-itemed");
        $(".layui-side-scroll a[href='" + href + "']").parent().addClass("layui-this"); //设置二级菜单
    }

    element.render('nav');  //重新渲染
})