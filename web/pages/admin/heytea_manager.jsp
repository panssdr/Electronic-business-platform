<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>喜茶管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function(){

			$("a.deleteClass").click(function () {

				confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text() +"】?")
			});
		});
	</script>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>

<body>

<%@include file="/pages/admin/admin_top.jsp"%>

	<div id="main">
		<table>
			<tr>
			<td>名称</td>
			<td>价格</td>
			<td>类型</td>
			<td>销量</td>
			<td>库存</td>
			<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="heytea">
				<tr>
				     <td>${heytea.name}</td>
					<td>${heytea.price}</td>
			     	<td>${heytea.category}</td>
					<td>${heytea.sales}</td>
					<td>${heytea.stock}</td>
				<td><a href="/manage/getHeyTea?id=${heytea.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a class="deleteClass" href="/manage/delete?id=${heytea.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/heytea_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加喜茶</a></td>
			</tr>
		</table>

		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>