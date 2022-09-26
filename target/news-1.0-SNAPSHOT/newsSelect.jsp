<%@ page import="com.example.news.entity.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/3
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%Map newss = (Map) request.getAttribute("newss");%>
    <title><%=newss.get("newsTitle")%></title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/newsSelect.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
    <div id="nestle" ><%=newss.get("newsTitle")%></div>
    <div id="dayat">
        <span><%=newss.get("newsDate")%></span>
        <span><%=newss.get("Author")%></span>
    </div>
    <div id="content">
        <textarea class="content"><%=newss.get("newsContent")%></textarea>
    </div>

</body>
</html>
