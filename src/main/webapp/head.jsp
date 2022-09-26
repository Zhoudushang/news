<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/10
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/head.css">
</head>
<body>
<%Map user = (Map) request.getSession().getAttribute("user");%>
<!--导航-->
<nav class="mainNav">
    <div class="fist">
        <!--一级导航-->
        <ul id="fistUl" class="fistNav">
            <li><a href="home.jsp">首页</a></li>
            <li><a href="">新闻管理</a>
                <ul class="subNav  c1">
                    <li><a href="newsfabu.jsp">新闻编辑</a></li>
                    <li><a href="newsxiugai.jsp">新闻状态</a></li>
                    <%if(user.get("type").equals(1)){%>
                    <li><a href="newsSh.jsp">新闻审核</a></li>
                    <%}%>
                </ul>
            </li>
            <%if(user.get("type").equals(1)){
            %><li><a href="">管理员管理</a>
                <ul class="subNav  c1"  >
                    <li><a href="userDelete.jsp">用户删除</a></li>
                    <li><a href="">用户修改</a></li>

                </ul>
            </li>
            <%}%>
            <li><a href="">用户管理</a>
                <ul class="subNav  c1" >
                    <li><a href="User.jsp">用户查询</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="usergl">
        <a href="userHome.jsp">
            <%if(user.get("type").equals(1)){%>管理员：<%}%><%=user.get("username")%>
            <div class="tou"></div>
        </a>
    </div>
</nav>
</body>
<script src="js/head.js"></script>
</html>
