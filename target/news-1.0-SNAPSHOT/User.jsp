<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/1
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查询</title>

</head>
<body>
    <%--用户管理模块--%>
    <div class="userManagement ">
        <form action="userselect"><input type="button" value="用户查询"></form>
        <span><a href="userSelectServlet.jsp">用户查询</a></span>
        <span><a href="">密码修改</a></span>
        <span><a href="">用户修改</a></span>
    </div>

    <%--管理员管理模块--%>
    <div class="admin">
        <span><a href="">新闻审核</a></span>
        <span><a href="">密码修改</a></span>
        <span><a href="">用户修改</a></span>
    </div>

</body>
</html>
