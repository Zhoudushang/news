<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: zhoudu
  Date: 2021/6/17
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="CSS/newsSh2.css">
</head>
<body>
<%Map newss = (Map) request.getAttribute("newss");%>
<jsp:include page="head.jsp"></jsp:include>
<form action="newsSh3" class="ifo">
    <div id="nestle" ><%=newss.get("newsTitle")%></div>
    <div id="dayat">
        <span><%=newss.get("newsDate")%></span>
        <span><%=newss.get("Author")%></span>
    </div>
    <div id="content">
        <textarea type="text" name="newsId" class="wwowoow"><%=newss.get("newsId")%></textarea>
        <textarea class="content"><%=newss.get("newsContent")%></textarea>
    </div>
    <button type="submit" >通过</button>
    <button type="submit" ><a href="home.jsp">取消</a></button>
</form>
</body>
</html>
