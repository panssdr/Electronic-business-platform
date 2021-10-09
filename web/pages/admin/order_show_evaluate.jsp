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
    <p>订单编号为:${sessionScope.evaluate_order_id}</p>
      <form>
          <input type="text" name="evaluate" value="${sessionScope.evaluate}">
      </form>
</div>

<%@include file="/pages/common/foot.jsp"%>
</body>
</html>