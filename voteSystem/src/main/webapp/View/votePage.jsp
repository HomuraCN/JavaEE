<%@ page import="main.Model.JavaBean.Voter" %>
<%@ page import="main.Model.JavaBean.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="main.Model.Service.voteService" %>
<%@ page import="main.Model.Service.candidateService" %><%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/26
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>votePage</title>
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

        List<Candidate> list = voteService.queryListPagination(pageIndex);
    %>

    <div>
        <a href="../Controller/logoutController.jsp">登出</a>
    </div>

    <p>投票页</p>

    <table>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>得票数</td>
            <td>投票</td>
        </tr>
        <%
            for(int i = 0; i < list.size(); i++){
                Candidate candidate = list.get(i);
        %>
        <tr>
            <td><%=candidate.getTId()%></td>
            <td><%=candidate.getTName()%></td>
            <td><%=candidate.getVotes()%></td>
            <%
                if(candidateService.checkStatus(candidate.getTId()) == 1){
            %>
            <td><a href="../Controller/voteController.jsp?tId=<%=candidate.getTId()%>&account=<%=voter.getAccount()%>"><input type="button" value="投票"></a></td>
            <%
            }
            else{
            %>
            <td><a href="../Controller/voteController.jsp?tId=<%=candidate.getTId()%>&account=<%=voter.getAccount()%>"><input type="button" value="投票" disabled></a></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>
    <%
        int pageCnt = voteService.getCandidatePageCnt();//通过SQL语句获取所有的记录页面
        if(pageIndex != 1){
            out.print("<a href=votePage.jsp?pageIndexParam=" + (pageIndex - 1) + ">上一页</a>&nbsp");
        }
        out.print("<a href=votePage.jsp?pageIndexParam=" + 1 + ">首页</a>");
        for(int i = 1; i <= pageCnt;i++) {
            out.print("&nbsp<a href=votePage.jsp?pageIndexParam=" + i + ">[" + i + "]</a>&nbsp");
        }
        out.print("<a href=votePage.jsp?pageIndexParam=" + pageCnt + ">尾页</a>");
        if(pageIndex != pageCnt){
            out.print("&nbsp<a href=votePage.jsp?pageIndexParam=" + (pageIndex + 1) + ">下一页</a>");
        }
    %>
</body>
</html>
