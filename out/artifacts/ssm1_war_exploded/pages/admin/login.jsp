<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>喜茶管理员登录页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="/static/img/logo.gif" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>喜茶管理员</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="/admin/login" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="adminname" value="${empty requestScope.adminname?"请输入用户名和密码":requestScope.adminname}" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                        <input type="hidden" name="action" value="login">
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot.jsp"%>
</body>
</html>