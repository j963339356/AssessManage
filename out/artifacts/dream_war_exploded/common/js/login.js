define(['/common/js/config.js'], function () {
    require(['jquery', 'layui', 'popups', 'helper'], function ($) {
        form = layui.form;
        layer = layui.layer;
        Login = {}
        Login.Login = function(){
            //弹出登录框
            layer.open({
                type: 2,
                title: ['登录'],
                area: ['330px', '320px'],
                resize: false,
                move: false,
                content: ['/module/Login.html', 'no'],
                success: function () {

                }
            });
        }

        Login.ShowLogin = function () {
            if(Helper.GetToken()==""){
                Login.Login();
            }
        }

        //监听提交
        form.on('submit(login)', function (data) {
            var param = data.field;            
            var status = null;
            var data = null;
            Helper.Ajax("Login/Login", param, function (res) {
                status = res.response.staticCode;
                data = res;
            },function(){
                //如果成功
                if (status == 0) {
                    Helper.SetToken(data.body);
                    Helper.SetUser(data.body);
                    layer.msg("登录成功", { icon: 1, time: 1000 }, function () {
                        console.log(data.body);
                        //设置token
                        
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        if(index==undefined){
                            window.location.href = "/module/manage/List.html";
                            return ;
                        }
                        parent.layer.close(index); //再执行关闭
                        parent.window.location.reload();   
                    });
                }
                else {
                    //否则
                    if(status==5){
                        layer.msg(data.response.message, { icon: 2, anim: 6, time: 1000 });
                    }
                    else{
                        layer.msg("账号或密码错误", { icon: 2, anim: 6, time: 1000 });
                    }
                    $('.captcha img').attr('src', 'http://localhost:8080/api/Login/captcha?id=' + Math.random());  //刷新验证码
                }
            });
            return false;
        });

        return Login;
    })
})