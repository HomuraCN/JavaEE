<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/27
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerPage</title>
</head>
<body>
    <%
        String msg = request.getParameter("msg");
        if(msg == null){
            msg = "";
        }
    %>
    <div>
        <p>用户注册</p>
        <form action="../Controller/registerController.jsp" method="post">
            <p>账号: <input type="text" name="account"></p>
            <p>密码: <input type="password" name="password"></p>
            <p><%=msg%></p>
            <input type="submit" value="注册">
            <a href="loginPage.jsp">已有账号?</a>
        </form>
    </div>
</body>
</html>
