<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link href="CSS/Login.css" rel="stylesheet" type="text/css" >

</head>
<body>
<div id="xt">新闻发布系统</div>
<div id="login_fist">
    <div id="login">
        <h1>欢迎登录</h1>
    </div>
    <div id="zhuce">
        <div id="ifrom">
            <form id=“dengl” action="lnServlet" >
                <span>账  号：</span><input type="text" name="username" value placeholder="请输入账号">
                <span>密  码：</span><input type="password" name="password" value placeholder="请输入密码">
                <input  class="ress" type="submit" value="登录">
            </form>
        </div>
    </div>
    <p>没有账号？用户<a href="registered.jsp">注册</a></p>
</div><%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){
%>
<script type="text/javascript">
    alert("<%=message%>");
</script>
<%} %>
<script  type="text/javascript" src="js/index.js"></script>
</body>
</html>