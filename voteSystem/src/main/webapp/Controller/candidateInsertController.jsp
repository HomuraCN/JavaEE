<%@ page import="main.Model.Service.candidateService" %>
<%@ page import="main.Model.JavaBean.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/28
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Candidate candidate = new Candidate();
        candidate.setTName(request.getParameter("tName"));
        candidateService.insertCandidate(candidate);
        response.sendRedirect("../View/candidateManagementPage.jsp");
    %>
</body>
</html>
