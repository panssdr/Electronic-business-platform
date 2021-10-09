<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/2
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>欢迎来到喜茶</span>
    <a href="pages/cart/cart.jsp">购物车</a>
    <a href="/order/showOrder">我的订单</a>
    <a href="/user/logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
