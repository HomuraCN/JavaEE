<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/27
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.removeAttribute("voter");
        session.invalidate();
        response.sendRedirect("../View/loginPage.jsp");
    %>
</body>
</html>
