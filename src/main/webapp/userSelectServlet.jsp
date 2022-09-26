<%@ page import="com.example.news.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><jsp:include page="head.jsp"></jsp:include>

<%
    User user = (User)request.getAttribute("user");
%>

id:<%=user.getId() %>
username:<%=user.getUsername() %>
password:<%=user.getPassword() %>
address:<%=user.getAddress() %>

</body>
</html>
