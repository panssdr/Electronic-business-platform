<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>喜茶首页</title>
    <%@include file="/pages/common/head.jsp"%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <%--	<style>--%>
    <%--		body{--%>
    <%--			background-color:pink;--%>
    <%--		}--%>
    <%--	</style>--%>

</head>
<body>

<%!
    public static int c=0;
%>
<div id="header">
    <img class="logo_img"alt="" src="/static/img/logo.gif">
    <%--			<img class="logo_img" alt="" src="https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=喜茶logo&hs=2&pn=2&spn=0&di=6710&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3272920449%2C4064486292&os=3279085789%2C863121209&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=喜茶logo&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fi.serengeseba.com%2Fuploads%2Fi_1_1850931798x4044264281_26.jpg%26refer%3Dhttp%3A%2F%2Fi.serengeseba.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622676923%26t%3D5c4673bb91c575a1cd8fc96a46080a8d&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bx7gsjtf5_z%26e3Bv54AzdH3Fp7AzdH3F%3FoAzdH3F%25Ec%25lm%25lC%25Eb%25bC%25Bms525%25E0%25lF%25Ad%25El%25b0%25bF%25Ec%25lB%25BEAzdH3F&gsm=2&islist=&querylist=" >--%>
    <span class="wel_word"></span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<a href="/user/loginItem?username=${sessionScope.user.username}" class="um_span">${sessionScope.user.username}</a>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="/user/logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/admin/login.jsp">后台管理</a>
    </div>
</div>
<div id="main">

    <form action="/admin/update">
        <input type="hidden" value="${sessionScope.admin.adminName}" name="adminName">
        <div class="form-group">
            <label for="oldpassword">原密码</label>
            <input type="text" class="form-control" name="oldpassword" id="oldpassword" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="newpassword">新密码</label>
            <input type="text" name="newpassword" class="form-control" id="newpassword"  placeholder="Password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>


</div>
<%@include file="/pages/common/foot.jsp"%>
</body>
</html>