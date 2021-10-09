<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%@include file="/pages/common/head.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function(){

            $(".deleteClass").click(function () {

                confirm("您确定要收货吗？")
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img"alt="" src="/static/img/logo.gif">
    <%--			<img class="logo_img" alt="" src="https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=喜茶logo&hs=2&pn=2&spn=0&di=6710&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=3272920449%2C4064486292&os=3279085789%2C863121209&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=喜茶logo&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fi.serengeseba.com%2Fuploads%2Fi_1_1850931798x4044264281_26.jpg%26refer%3Dhttp%3A%2F%2Fi.serengeseba.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1622676923%26t%3D5c4673bb91c575a1cd8fc96a46080a8d&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bx7gsjtf5_z%26e3Bv54AzdH3Fp7AzdH3F%3FoAzdH3F%25Ec%25lm%25lC%25Eb%25bC%25Bms525%25E0%25lF%25Ad%25El%25b0%25bF%25Ec%25lB%25BEAzdH3F&gsm=2&islist=&querylist=" >--%>
    <span class="wel_word">我的订单</span>
    <%@ include file="/pages/common/login_sucess_menu.jsp"%>
</div>

<div id="main">

    <table>
        <tr>
            <td>饮品名字</td>
            <td>数量</td>
            <td>价格</td>
            <td>总额</td>
        </tr>
        <c:forEach items="${sessionScope.orderItems}" var="orderItem">
            <tr>
                <td>
                        ${orderItem.name}
                </td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
        <c:if test="${sessionScope.real==0}"></c:if>
        <c:if test="${sessionScope.real==1}">
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td class="deleteClass"><a href="/order/recieveOrderItem?orderid=${sessionScope.orderId}">确认收货</a></td>
        </tr>
        </c:if>
    </table>


</div>

<%@include file="/pages/common/foot.jsp"%>
</body>
</html>