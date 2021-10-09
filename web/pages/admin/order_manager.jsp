<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			$(".clearCart").click(function () {
				return confirm("亲爱的管理员,您确定给这位用户发货吗？");
			})
		})
	</script>
</head>
<body>
	

		<%@include file="/pages/admin/admin_top.jsp"%>

	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>
			<c:forEach items="${sessionScope.orderss}" var="orderr">
				<tr>
					<td>
							${orderr.createTime}
					</td>
					<td>${orderr.price}</td>
					<td>${orderr.status==0?"未发货":"已发货"}</td>
					<c:if test="${orderr.status==0}">
						 <td class=".clearCart"><a href="/order/sendOrder?orderrId=${orderr.orderId}">发货!</a></td>
					</c:if>
					<c:if test="${orderr.status==1}">
						<td>已发货</td>
					</c:if>
					<c:if test="${orderr.status==2}">
						<td><a href="/order/showOrderEvaluate?orderid=${orderr.orderId}">已收货，查看评价</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>