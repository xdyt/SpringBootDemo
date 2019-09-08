<%--
  Created by IntelliJ IDEA.
  User: dbdb2
  Date: 2019/9/7
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    function login() {
        var username = $("#username").val();
        var pwd = $("#pwd").val();
        if (username){
            if (pwd) {
                $.post(
                    "/userLogin",
                    {
                        username: username,
                        pwd: pwd
                    },
                    function (data) {
                        if (data!="success") {
                            alert("登录失败，账号或密码错误！");
                            window.location.href = '/';
                        } else {
                            alert("登陆成功！正在跳转...");
                            window.location.href = '/selectbyusername';
                        }
                    },
                    "text"
                )
            }else {
                alert("请输入密码!!!")
            }
        } else {
            alert("请输入账号!!");
        }
    }
</script>
<body>
<form id="from1">
    账号:<input type="text" name="username" id="username"/><br>
    密码:<input type="password" name="pwd" id="pwd"/><br>
    <input type="button" onclick="login()" value="登陆"/><a href="adduser">注册</a>
</form>
</body>
</html>
