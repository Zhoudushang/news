<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/2
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户主页</title>
  <link rel="stylesheet" href="CSS/app.css">
  <link rel="stylesheet" href="CSS/userHome.css">
</head>
<body>
<%Map user = (Map) request.getSession().getAttribute("user");%>
<jsp:include page="head.jsp"></jsp:include>
  <div id="one"  class="userleft">
    <div class="userManagement ">
      <span class="on">信息查询</span>
      <span>信息修改</span>
      <span>密码修改</span>
    </div>


  </div>
  <div id="two" class="userright">
    <div id="san">
      <div class="userselect">
        <ul>
          <li>用户ID:<%=user.get("userId")%></li>
          <li>用户名:<%=user.get("username")%></li>
          <li>用户邮箱:<%=user.get("email")%></li>
          <li>联系方式:<%=user.get("phone")%></li>
          <li>联系地址:<%=user.get("address")%></li>
        </ul>
      </div>
      <div class="userxg">
        <ul>
          <li>用户昵称:<input type="text" value placeholder="<%=user.get("username")%>"> </li>
          <li>用户邮箱:<input type="text" value placeholder="<%=user.get("email")%>"> </li>
          <li>联系方式:<input type="text" value placeholder="<%=user.get("phone")%>"> </li>
          <li>联系地址:<input type="text" value placeholder="<%=user.get("address")%>"> </li>
        </ul>
      </div>
      <div class="userpassword">
        <ul>
          <li>旧 密 码：<input type="password" name="oldpassword"></li>
          <li>新 密 码：<input type="password" name="newpassword1"></li>
          <li>确认密码：<input type="password" name="newpassword2"></li>
        </ul>
      </div>
    </div>
  </div>

<script src="js/userHome.js"></script>
</body>
</html>
