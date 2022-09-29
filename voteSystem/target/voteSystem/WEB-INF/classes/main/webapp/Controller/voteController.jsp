<%@ page import="main.Model.Service.voteService" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/27
  Time: 22:28
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
        String account = request.getParameter("account");
        if(voteService.vote(tId, account)){
           response.sendRedirect("../View/votePage.jsp");
        }
        else{
            response.sendRedirect("../View/voteFailedPage.jsp");
        }
    %>
</body>
</html>
