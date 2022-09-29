<%@ page import="main.Model.Service.candidateService" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/27
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int tId = Integer.parseInt(request.getParameter("tId"));
        candidateService.changeStatus(tId);
        response.sendRedirect("../View/candidateManagementPage.jsp");
    %>
</body>
</html>
