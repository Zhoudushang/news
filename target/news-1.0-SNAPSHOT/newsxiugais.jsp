<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/11
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻修改页面</title>
    <link rel="stylesheet" href="CSS/newsxiugais.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<%Map newss = (Map) request.getAttribute("newss");%>
<div class="ln">
    新闻修改
</div>
<form action="newsxiugaiss" class="ifo">
    <textarea name="newsTitle" class="newsTitle" ><%=newss.get("newsTitle")%></textarea>
    <textarea name="newsid" class="newsid"><%=newss.get("newsId")%></textarea>
    <textarea class="newsContent" name="newsContent"><%=newss.get("newsContent")%></textarea>
    <button type="submit" >提交</button>
    <button type="submit" ><a href="newsxiugai.jsp">取消</a></button>
</form>
</body>
</html>
