<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
               $("#clearCart").click(function () {
                  return confirm("你确定要清空购物车吗？");
			   })

			$("#sureCart").click(function () {
				return confirm("你确定要结账吗？");
			})
			$(".updateCount").change(function () {
				var count=this.value;
			var id=	$(this).attr("heyTeaId");
                   if(confirm("你确定要修改商品数量吗？")){
					   location.href = "${pageContext.getAttribute("basesPath")}/cart/updateCount?id="+id+"&count="+count;
				   }else {
                   	//defaultValue就是表单DOM对象默认的value属性值
                     this.value=this.defaultValue;
				   }
			});
		})
	</script>
</head>
<body>
	
	<div id="header">
		<img class="logo_img"alt="" src="/static/img/logo.gif">
<%--			<img class="logo_img" alt="" src="https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=喜茶logo&hs=2&pn=2&spn=0&di=6710&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3272920449%2C4064486292&os=3279085789%2C863121209&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=喜茶logo&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fi.serengeseba.com%2Fuploads%2Fi_1_1850931798x4044264281_26.jpg%26refer%3Dhttp%3A%2F%2Fi.serengeseba.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622676923%26t%3D5c4673bb91c575a1cd8fc96a46080a8d&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bx7gsjtf5_z%26e3Bv54AzdH3Fp7AzdH3F%3FoAzdH3F%25Ec%25lm%25lC%25Eb%25bC%25Bms525%25E0%25lF%25Ad%25El%25b0%25bF%25Ec%25lB%25BEAzdH3F&gsm=2&islist=&querylist=" >--%>
			<span class="wel_word">购物车</span>
			<%@ include file="/pages/common/login_sucess_menu.jsp"%>
	</div>

	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">

					<h3>亲，购物车为空~</h3>


			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="cartitem">
			<tr>
				<td>${cartitem.value.name}</td>
				<td>
					<input class="updateCount" style="width: 80px" type="text"
					heyTeaId="${cartitem.value.id}"	   value="${cartitem.value.count}">
				</td>
				<td>${cartitem.value.price}</td>
				<td>${cartitem.value.totalPrice}</td>
				<td><a href="/cart/deleteItem?id=${cartitem.value.id}">删除</a></td>
			</tr>

			</c:forEach>
			</c:if>
		</table>

		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="/cart/clear">清空购物车</a></span>
			<span class="cart_span"><a id="sureCart" href="/order/createOrder">去结账</a></span>
		</div>
		</c:if>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>