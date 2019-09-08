<%--
  Created by IntelliJ IDEA.
  User: dbdb2
  Date: 2019/9/8
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    function update() {
        var phone = $("#phone").val();
        var email = $("#email").val();

        //正则表达式
        var regphone = /^1(3|4|5|7|8)\d{9}$/;
        var regemail = /^[A-Za-z0-9]+[@][a-zA-Z0-9_-]+([.][a-zA-Z0-9_-]+)+$/;

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
            "/updateuser",
            {
                phone:phone,
                email:email
            },
            function (data) {
                if (data!="success") {
                    alert("修改失败，账号或密码错误！");
                    window.location.href = '/selectbyusername';
                } else {
                    alert("修改成功！正在跳转...");
                    window.location.href = '/selectAllBook';
                }
            },
            "text"
        )
    }
</script>
<html>
<head>
    <title>显示用户信息</title>
</head>
<body>
    <table>
        <tr>
            <td>用户名:</td>
            <td>${sessionScope.user.username}</td>
        </tr>
        <tr>
            <td>手机号:</td>
            <td><input type="text" value="${sessionScope.user.phone}" name="phone" id="phone"/></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" value="${sessionScope.user.email}" name="email" id="email"/></td>
        </tr>
        <tr>
            <td><input type="button" onclick="update()" value="修改"/></td>
        </tr>
    </table>
</body>
</html>
