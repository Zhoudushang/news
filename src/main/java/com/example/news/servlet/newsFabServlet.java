package com.example.news.servlet;

import com.example.news.utils.Model;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class newsFabServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String title = request.getParameter("newsTitle");
        String content = request.getParameter("newsContent");
        String newsdate="";
        Map user = (Map) request.getSession().getAttribute("user");
        String Author = (String) user.get("username");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        newsdate = dateFormat.format(new Date());
        Model model = new Model();
        int result = model.addNews(title,content,newsdate, Author);
        if(result>0){
            response.sendRedirect("home.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
