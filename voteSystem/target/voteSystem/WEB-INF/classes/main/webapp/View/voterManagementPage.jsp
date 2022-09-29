<%@ page import="main.Model.JavaBean.Voter" %>
<%@ page import="java.util.List" %>
<%@ page import="main.Model.Service.voterService" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/28
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>voterManagementPage</title>
</head>
<body>
    <%
        Voter voter = (Voter)session.getAttribute("voter");
        if(voter == null){
            response.sendRedirect("loginPage.jsp");
            return;
        }

        int pageIndex = 1;
        String pageIndexParam = request.getParameter("pageIndexParam");
        if(pageIndexParam != null){
            pageIndex = Integer.parseInt(pageIndexParam);
        }

        List<Voter> list = voterService.queryListVoterPagination(pageIndex);
    %>

    <div>
        <a href="../Controller/logoutController.jsp">登出</a>
    </div>

    <p>用户管理</p>

    <table>
        <tr>
            <td>账号</td>
            <td>密码</td>
        </tr>
        <%
            for(int i = 0; i < list.size(); i++){
                Voter voter1 = list.get(i);
        %>
        <tr>
            <td><%=voter1.getAccount()%></td>
            <td><%=voter1.getPassword()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        int pageCnt = voterService.getVoterPageCnt();//通过SQL语句获取所有的记录页面
        if(pageIndex != 1){
            out.print("<a href=voterManagementPage.jsp?pageIndexParam=" + (pageIndex - 1) + ">上一页</a>&nbsp");
        }
        out.print("<a href=voterManagementPage.jsp?pageIndexParam=" + 1 + ">首页</a>");
        for(int i = 1; i <= pageCnt;i++) {
            out.print("&nbsp<a href=voterManagementPage.jsp?pageIndexParam=" + i + ">[" + i + "]</a>&nbsp");
        }
        out.print("<a href=voterManagementPage.jsp?pageIndexParam=" + pageCnt + ">尾页</a>");
        if(pageIndex != pageCnt){
            out.print("&nbsp<a href=voterManagementPage.jsp?pageIndexParam=" + (pageIndex + 1) + ">下一页</a>");
        }
    %>
</body>
</html>
