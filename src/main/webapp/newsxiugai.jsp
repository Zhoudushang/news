<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/6/11
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻状态查询</title>
    <link rel="stylesheet" href="CSS/newsxiugai.css">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="chankan">
    <div id="zt" class="zhuangtai">
        <span class="on">已发布</span>
        <span>未审核</span>
    </div>
    <div class="xinxi">

        <div id="jd" class="jiandan">
            <!--        /*已发布新闻列表*/-->
            <div class="yfb">
                <div class="newsshousuo">
                    <form id="verfyforms" action="##" method="get">
                        <input class="newsshousuo_sr" type="text" name="newsTitles" value placeholder="请输入新闻标题查询">
                        <input id="onss" type="button" value="搜索">
                    </form>
                </div>
                <table id="yfbnews" cellspacing="10" class="news">
                    <tr>
                        <td>新闻ID</td>
                        <td class="title">新闻标题</td>
                        <td>发布时间</td>
                        <td>发布者</td>
                        <td>操作</td>
                    </tr>
                </table>
            </div>
<%--            未审核新闻列表--%>
            <div class="wsh">
                <div class="newsshousuo">
                    <form id="verfyform" action="##" method="get">
                        <input class="newsshousuo_sr" type="text" name="newsTitless" value placeholder="请输入新闻标题查询">
                        <input id="ons" type="button" value="搜索">
                    </form>
                </div>
                <table id="whsnews" cellspacing="10" class="news">
                    <tr>
                        <td>新闻ID</td>
                        <td class="title">新闻标题</td>
                        <td>发布时间</td>
                        <td>发布者</td>
                        <td>操作</td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script  type="text/javascript" src="js/newsxiugai.js"></script>
<script type="text/javascript">
    $(function (){
        $("#onss").on('click',queryList)
        function queryList(){
            $.ajax({
                type:'get',
                url:'newsxiugai',
                data:$('#verfyforms').serialize(),
                dataType:'json',
                success:function (data){
                    // alert(data)
                    console.log(data);
                    $(".news").find("tr:gt(0)").remove();//清除
                    $.each(data,function(i){
                        if(data[i].Type===1) {
                            var trstring = "";
                            trstring = "<tr><td>" + data[i].newsId + "</td>" +
                                "<td>" + data[i].newsTitle + "</td>" +
                                "<td>" + data[i].newsDate + "</td>" +
                                "<td>" + data[i].Author + "</td>" +
                                "<td>" + "<a href='newsxiugais?opration=view&id=" + data[i].newsId + "'" + ">修改</a>" +
                                "<a href=''></a>" + "</td>" +
                                "</tr>";
                            $("#yfbnews").append(trstring);
                        }else{
                            var trstring = "";
                            trstring = "<tr><td>" + data[i].newsId + "</td>" +
                                "<td>" + data[i].newsTitle + "</td>" +
                                "<td>" + data[i].newsDate + "</td>" +
                                "<td>" + data[i].Author + "</td>" +
                                "<td>" + "<a href='newsxiugais?opration=view&id=" + data[i].newsId + "'" + ">修改</a>" +
                                "<a href=''></a>" + "</td>" +
                                "</tr>";
                            $("#whsnews").append(trstring);
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
