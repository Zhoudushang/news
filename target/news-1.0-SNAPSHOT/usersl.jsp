<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/2
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户删除</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/uesrsl.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<main>
    <div class="userSelect">
        <div class="usershousuo">
            <form action="">
                <input class="usershousuo_sr" type="text" name="username">
                <input type="submit" value="搜索">
            </form>
        </div>
        <div class="username_1">
            <table  cellspacing="10" border="0" >
                <tr>
                    <td>用户ID</td>
                    <td class="on">用户昵称</td>
                    <td class="on">用户注册邮箱</td>
                    <td>联系方式</td>
                    <td>联系住址</td>
                </tr>
                <tr>
                    <td>1005</td>
                    <td>我的天啊</td>
                    <td>2020215@qq.com</td>
                    <td>1002</td>
                    <td>1002</td>
                </tr>
            </table>

            </td>
        </div>
    </div>
</main>
</body>
</html>
