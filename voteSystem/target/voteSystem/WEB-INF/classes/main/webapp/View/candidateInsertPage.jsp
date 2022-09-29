<%--
  Created by IntelliJ IDEA.
  User: Kirito
  Date: 2022/9/28
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>candidateInsertPage</title>
</head>
<body>
    <div>
        <p>添加候选人</p>
        <form action="../Controller/candidateInsertController.jsp" method="post">
            <p>姓名: <input type="text" name="tName"></p>
            <input type="submit" value="添加">
        </form>
    </div>
</body>
</html>
