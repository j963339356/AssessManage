define(['jquery', 'helper'], function ($) {
    //序列化表单为json对象
    $.fn.serializeForm = function () {
        // var params = this.serializeArray();
        var values = {};
        $(this).find('input[name],label[name],select[name],textarea[name]').each(function (i, item) {
            if (item.localName == 'input' || item.localName == 'select' || item.localName == 'textarea') {
                values[$(item).attr('name')] = $(item).val();
            }
            if (item.localName == 'label') {
                values[$(item).attr('name')] = $(item).text();
            }
        })
        // for (x in params) {
        //     values[params[x].name] = params[x].value;
        // }
        //  var idata = JSON.stringify(values);
        return values;
    }
    //序列化表格为json对象
    $.fn.serializeTabel = function () {
        var values = [];
        $(this).find('tr').each(function (i, item) {
            obj = {};
            $(item).find('input[name],label[name]').each(function (i, item) {
                if (item.localName == 'input') {
                    obj[$(item).attr('name')] = $(item).val();
                }
                if (item.localName == 'label') {
                    obj[$(item).attr('name')] = $(item).text();
                }
            })
            if (!isEmpty(obj) && obj.name != undefined) {
                values.push(obj);
            }
        })

        function isEmpty(obj) {
            for (var k in obj) {
                return false;
            }
            return true;
        }
        return values;
    }

    //列表的左侧下拉菜单，只有一个展开，其他自动折叠
    $(".layui-nav-tree li").click(function () {
        $(this).siblings().removeClass("layui-nav-itemed")
    })

    //日期格式化
    Date.prototype.Format = function (fmt) { //author: meizz   
        var o = {
            "M+": this.getMonth() + 1,                 //月份   
            "d+": this.getDate(),                    //日   
            "h+": this.getHours(),                   //小时   
            "m+": this.getMinutes(),                 //分   
            "s+": this.getSeconds(),                 //秒   
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
            "S": this.getMilliseconds()             //毫秒   
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    //权限校验
    var user = Helper.GetUser();
    if (user) {
        $("[data-code]").hide();
        $("[data-code]").each(function (i, item) {
            if ($(item).attr("data-code").indexOf(user.orgCode) != -1) {
                $(item).show();
            }
        })
        //用户信息
        $("#username").text(user.name);
        $("#userinfo").text(user.username);
        $("#orgName").text(user.orgName);
    }
    $("#logout").click(function () {
        Helper.ClearnToken();
        Helper.removeUser();
    })

})
