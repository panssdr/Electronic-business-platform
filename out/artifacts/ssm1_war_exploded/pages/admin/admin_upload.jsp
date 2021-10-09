<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        #main{
            position: relative;
        }
        #main>form{
            position: absolute;
            left: 400px;
            top: 200px;
        }
        #main>a{
            position: absolute;
            left: 400px;
            top: 300px;
            color: rebeccapurple;
        }
    </style>
</head>
<body>
<%@include file="/pages/admin/admin_top.jsp"%>
<div id="main">

    <form action="${pageContext.request.contextPath}/admin/uploadServlet" method="post" enctype="multipart/form-data">
        <label for="desc">图片简介:</label>
        <input type="text" name="desc" id="desc" />
        <br />
        <label for="file">图片文件名:</label>
        <input type="file" name="file" id="file" />
        <br/>
        <input type="submit" name="submit" value="Submit" />
    </form>
    <a href="/pages/admin/admin_deletePic.jsp">删除不想要~</a>
</div>

</body>
</html>
