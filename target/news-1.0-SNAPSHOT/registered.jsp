<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/25
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/registered.css">
</head>
<body>
<div class="fubu">
    新闻发布系统
</div>
<div id="zhuce">
    <h1>欢迎注册</h1>
    <p>已有账号？<a href="index.jsp">登录</a></p>
    <form action="reqister" method="get">
<%--        <span>I  d：</span><input type="text" name="userId">--%>
        <span>名 称：</span><input id="uname" type="text" name="username" value placeholder="请输入用户昵称">
        <span>密 码：</span><input id="pass" type="password" name="password" value placeholder="请输入密码">
        <span>确认密码：</span><input id="repass" type="password" name="qpassword" value placeholder="请确认密码">
        <span>邮 箱：</span><input type="text" name="email" value placeholder="请输入邮箱">
        <span>电 话：</span><input type="text" name="phone" value placeholder="请输入联系电话">
        <span>地 址：</span><input type="text" name="address" value placeholder="请输入联系地址">
        <input id="myform" class="ress" type="submit" value="注册">
    </form>
</div>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=message%>");
</script>
<%} %>
<script src="js/registered.js"></script>
</body>

</html>
