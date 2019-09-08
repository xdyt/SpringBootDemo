<%--
  Created by IntelliJ IDEA.
  User: dbdb2
  Date: 2019/9/7
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    function adduser() {
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        var repwd = $("#repwd").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        //正则表达式
        var regphone = /^1(3|4|5|7|8)\d{9}$/;
        var regemail = /^[A-Za-z0-9]+[@][a-zA-Z0-9_-]+([.][a-zA-Z0-9_-]+)+$/;

        if (!username){
            alert("账号不能为空!");
        }

        if(!pwd){
            alert("密码不能为空!");
        }

        if(!repwd){
            alert("请重新输入密码!");
        }else if(repwd != pwd){
            alert("两次输入的密码不一致,请重新输入!");
        }

        if(!phone){
            alert("请输入手机号!");
        }else {
            if (!regphone.test(phone)){
                alert("请输入有效的手机号!")
            }
        }

        if(!email){
            alert("请输入邮箱!");
        }else {
            if(!regemail.test(email)){
                alert("请输入正确的邮箱格式!!");
            }
        }

        $.post(
            "/registration",
            {
                username: username,
                password: pwd,
                phone:phone,
                email:email
            },
            function (data) {
                if (data!="WEB-INF.jsp.user.success") {
                    alert("注册失败，账号或密码错误！");
                    window.location.href = '..';
                } else {
                    alert("注册成功！正在跳转...");
                    window.location.href = '..';
                }
            },
            "text"
        )
    }
</script>
<body>
<form>
    用户名:<input type="text" name="username" id="username"/><br>
    密码:<input type="password" name="pwd" id="pwd"/><br>
    确认密码:<input type="password" name="repwd" id="repwd"/><br>
    手机号:<input type="text" name="phone" id="phone"/><br>
    邮箱:<input type="email" name="email" id="email"/><br>
    <input type="button" value="注册" onclick="adduser()"/>
</form>
</body>
</html>