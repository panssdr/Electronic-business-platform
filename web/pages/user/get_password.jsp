<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>喜茶会员登录页面</title>
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
                    <h1>喜茶会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${empty requestScope.msg?"请输入用户名和邮箱":requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="/user/getpassword">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="<%=request.getAttribute("username")==null?"请输入用户名":request.getAttribute("username")%>" />
                        <br />
                        <br />
                        <label>用户邮箱：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱" autocomplete="off" tabindex="1" name="email" />
                        <br />
                        <br />
                        <input type="submit" value="找回" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot.jsp"%>
</body>
</html>