<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/25
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.news.entity.User" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.news.utils.DBHelper" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.news.entity.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<html lang="en">
<head>
    <title>新闻发布系统</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/home.css">
</head>

<body>
<jsp:include page="head.jsp"></jsp:include>
<%Map user = (Map) request.getSession().getAttribute("user");%>
<main>
    <div class="welcome">
        欢迎使用新闻发布系统
    </div>
    <div class="newsSelect">
        <div class="newsshousuo">
            <form id="verfyform" action="##" method="get">
                <input class="newsshousuo_sr" type="text" name="newsTitle" value placeholder="请输入新闻标题查询">
                <input id="ons" type="button" value="搜索">
            </form>
        </div>
        <div class="newstitle">
            <table cellspacing="10" id="news">
                <tr>
                    <td>新闻ID</td>
                    <td class="on">新闻标题</td>
                    <td>发布时间</td>
                    <td>发布者</td>
                    <td>操作</td>
                </tr>
            </table>

        </div>
    </div>
    <div id="wowowo"><%=user.get("type")%></div>
    <div id="wowo"><%=user.get("username")%></div>
</main>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script  type="text/javascript" src="js/home.js"></script>
<script type="text/javascript">
    $(function (){
        let type=document.getElementById("wowowo");
        let type2=document.getElementById("wowo");
        x=type.innerHTML;
        y=type2.innerHTML;
        $("#ons").on('click',queryList)
        function queryList(){
            $.ajax({
                type:'get',
                url:'NewsServlet',
                data:$('#verfyform').serialize(),
                dataType:'json',
                success:function (data){
                    // alert(data)
                    console.log(data);
                    $("#news").find("tr:gt(0)").remove();//清除
                        $.each(data,function(i){
                            if(data[i].Type===1){
                                var trstring="";
                                if(x==="1" || data[i].Author===y){
                                    trstring = "<tr>" +
                                        "<td>"+data[i].newsId+"</td>" +
                                        "<td><a href='newselect?opration=view&id="+data[i].newsId+"'"+">"+data[i].newsTitle+"</a></td>" +
                                        "<td>"+data[i].newsDate+"</td>" +
                                        "<td>"+data[i].Author+"</td>"+
                                        "<td><a href='newsDelet?opration=view&id="+data[i].newsId+"'"+">删除</a>" +
                                        "<a href='newsxiugais?opration=view&id="+data[i].newsId+"'"+">修改</a></td>"+
                                        "</tr>";
                                    $("table").append(trstring);
                                }else{
                                    trstring = "<tr>" +
                                        "<td>"+data[i].newsId+"</td>" +
                                        "<td><a href='newselect?opration=view&id="+data[i].newsId+"'"+">"+data[i].newsTitle+"</a></td>" +
                                        "<td>"+data[i].newsDate+"</td>" +
                                        "<td>"+data[i].Author+"</td>"+
                                        "</tr>";
                                    $("table").append(trstring);
                                }
                            };
                        });
                },
                error:function (error){
                    alert('请求错误');
                }
            })
        }
    })

</script>
</body>
</html>
