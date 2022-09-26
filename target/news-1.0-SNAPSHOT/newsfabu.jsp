<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻编辑页面</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/newsabu.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="ln">
    新闻编辑
</div>
<form action="newsflashes" class="ifo">
    <textarea name="newsTitle" class="newsTitle" value placeholder="新闻的标题，建议不要超过30字"></textarea>
    <textarea class="newsContent" name="newsContent" value placeholder="新闻内容"></textarea>
    <button type="submit" >提交</button>
    <button type="submit" ><a href="home.jsp">取消</a></button>
</form>

<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=message%>");
</script>
<%} %>
</body>
</html>
