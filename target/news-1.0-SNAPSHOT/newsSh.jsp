<%@ page import="java.util.List" %>
<%@ page import="com.example.news.entity.News" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/2
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻审核</title>
    <link rel="stylesheet" href="CSS/app.css">
    <link rel="stylesheet" href="CSS/newsSh.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<main>
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

</main>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function (){
        $("#ons").on('click',queryList)
        function queryList(){
            $.ajax({
                type:'get',
                url:'newssh',
                data:$('#verfyform').serialize(),
                dataType:'json',
                success:function (data){
                    // alert(data)
                    console.log(data);
                    $("#news").find("tr:gt(0)").remove();//清除
                    $.each(data,function(i){
                        if(data[i].Type===0){
                            var trstring="";
                            trstring = "<tr>" +
                                "<td>"+data[i].newsId+"</td>" +
                                "<td>"+data[i].newsTitle+"</td>" +
                                "<td>"+data[i].newsDate+"</td>" +
                                "<td>"+data[i].Author+"</td>" +
                                "<td><a href='newsSh2?opration=view&id="+data[i].newsId+"'"+">审核</a></td>" +
                                "</tr>";
                            $("table").append(trstring);
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
