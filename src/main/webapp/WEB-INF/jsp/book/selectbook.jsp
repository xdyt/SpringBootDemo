<%--
  Created by IntelliJ IDEA.
  User: dbdb2
  Date: 2019/9/8
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>全部图书</title>
</head>
<body>
<table>
    <tr>
        <td>书名</td>
        <td>交易日期</td>
        <td>购买人</td>
        <td>地址</td>
        <td>简介</td>
    </tr>
    <c:forEach items="${sessionScope.book}" var="book">
        <tr>
            <td>${book.ordername}</td>
            <td>${book.date}</td>
            <td>${book.orderuser}</td>
            <td>${book.address}</td>
            <td>${book.nm}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
