<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/2
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basesPath = request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basesPath",basesPath);
%>
<base href="<%=basesPath%>">