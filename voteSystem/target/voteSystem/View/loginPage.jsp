<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/25
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginPage</title>
</head>
<body>
    <%
        String msg = request.getParameter("msg");
        if(msg == null){
            msg = "";
        }
    %>
    <div id="loginForm">
<p>用户登录</p>
<form action="../Controller/loginController.jsp" method="post">
    <p>账号: <input type="text" name="account"></p>
    <p>密码: <input type="password" name="password"></p>
    <p><%=msg%></p>
    <input type="submit" value="登录">
    <a href="registerPage.jsp"><input type="button" value="注册"></a>
</form>
    </div>
</body>
</html>
