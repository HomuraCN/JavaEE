<%@ page import="main.Model.JavaBean.Voter" %>
<%@ page import="main.Utils.StringUtils" %>
<%@ page import="main.Model.Service.loginService" %>
<%@ page import="main.Model.JavaBean.Voter" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/25
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
    <%
        Voter voter = new Voter();
        voter.setAccount(request.getParameter("account"));
        voter.setPassword(request.getParameter("password"));
        if(voter.getAccount().equals("") || voter.getPassword().equals("")){
            response.sendRedirect("../View/loginPage.jsp?msg=" + StringUtils.UrlEncoder("账号或密码为空"));
        }
        else if (loginService.login(voter)){
            session.setAttribute("voter", voter);
            if(voter.getAccount().length() >= 5 && voter.getAccount().substring(0, 5).equals("admin")){
                response.sendRedirect("../View/adminPage.jsp");
            }
            else{
                response.sendRedirect("../View/votePage.jsp");
            }
            System.out.println("登录成功");
        }
        else{
            response.sendRedirect("../View/loginPage.jsp?msg=" + StringUtils.UrlEncoder("账号或密码错误"));
            System.out.println("登录失败");
        }
    %>
</html>
