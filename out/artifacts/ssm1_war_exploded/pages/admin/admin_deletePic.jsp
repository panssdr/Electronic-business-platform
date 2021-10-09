<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/12
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <title>图片管理</title>
    <script type="text/javascript" src="/static/script/jquery-1.7.2.js"></script>
    <script language="javascript">
        $(function(){
            $("select#pic").change(function(){
                var filename=$(this).val();
                $("#img1").attr('src','../../upload/'+filename);
            });
        });
    </script>
    <%
        String pathStr=request.getServletContext().getRealPath("/upload");
        request.setAttribute("pathStr",pathStr);

    %>
    <style type="text/css">
        #main{
            position: relative;
        }
        #main>form{
            position: absolute;
            left: 400px;
            top: 100px;
        }
    </style>
</head>
<body>

<%@include file="/pages/admin/admin_top.jsp"%>
<div id="main">
    <jsp:useBean id="fileBean" class="domain.Images" scope="page"></jsp:useBean>
    <%--            设置bean中的属性--%>
    <jsp:setProperty name="fileBean" property="path" value="${pathStr}" ></jsp:setProperty>
    <%--            获取并显示bean中的属性--%>
    <jsp:getProperty name="fileBean" property="path"/>
    <%--<jsp:getProperty name="fileBean" property="files"/>--%>
    <%--${fileBean.files}--%>
    <form id='form1' name='form1' method='post' action='/delete'>
        <select name='pic' id='pic' >
            <option value="">请选择图片</option>
            <%--                    遍历fileBean.files，显示每个文件名--%>
            <c:forEach items="${fileBean.files}" var="file" varStatus="s">
                <option value="${file}">${file}</option>
            </c:forEach>

        </select>
        <p/>
        <img id='img1' name='img1' width='200px' height='200px' src='#' />
        <p/>
        <input type="submit" name="submit" value="删除图片" onclick="return confirm('确定要删除吗？');"/>
        <br>
        <font color="red">${delete_msg}</font>
    </form>
</div>
</body>
</html>
