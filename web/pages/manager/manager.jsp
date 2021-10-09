<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
	<%@include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
		<img class="logo_img"alt="" src="/static/img/logo.gif">
<%--			<img class="logo_img" alt="" src="https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=喜茶logo&hs=2&pn=2&spn=0&di=6710&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3272920449%2C4064486292&os=3279085789%2C863121209&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=喜茶logo&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fi.serengeseba.com%2Fuploads%2Fi_1_1850931798x4044264281_26.jpg%26refer%3Dhttp%3A%2F%2Fi.serengeseba.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622676923%26t%3D5c4673bb91c575a1cd8fc96a46080a8d&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bx7gsjtf5_z%26e3Bv54AzdH3Fp7AzdH3F%3FoAzdH3F%25Ec%25lm%25lC%25Eb%25bC%25Bms525%25E0%25lF%25Ad%25El%25b0%25bF%25Ec%25lB%25BEAzdH3F&gsm=2&islist=&querylist=" >--%>
			<span class="wel_word">后台管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>