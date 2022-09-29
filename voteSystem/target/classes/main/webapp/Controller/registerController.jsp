<%@ page import="main.Model.JavaBean.Voter" %>
<%@ page import="main.Utils.StringUtils" %>
<%@ page import="main.Model.Service.loginService" %>
<%@ page import="main.Model.Service.registerService" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/27
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Voter voter = new Voter();
        voter.setAccount(request.getParameter("account"));
        voter.setPassword(request.getParameter("password"));
        if(voter.getAccount().equals("") || voter.getPassword().equals("")){
            response.sendRedirect("../View/registerPage.jsp?msg=" + StringUtils.UrlEncoder("账号或密码不能为空"));
        }
        else if (registerService.checkAccountExist(voter)){
            response.sendRedirect("../View/registerPage.jsp?msg=" + StringUtils.UrlEncoder("账号已存在，注册失败"));
            System.out.println("账号已存在，注册失败");
        }
        else{
//            response.sendRedirect("../View/loginPage.jsp?msg=" + StringUtils.UrlEncoder("注册成功，请重新登录"));
            response.sendRedirect("../View/registerSuccessfullyPage.jsp");
            System.out.println("注册成功");
        }
    %>
</body>
</html>
