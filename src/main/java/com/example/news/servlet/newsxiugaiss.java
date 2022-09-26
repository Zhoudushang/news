package com.example.news.servlet;

import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class newsxiugaiss extends HelloServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String Title = req.getParameter("newsTitle");
        String Content = req.getParameter("newsContent");
        String  newsId = req.getParameter("newsid");
        String newsdate="";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        newsdate = dateFormat.format(new Date());
        Model model =new Model();
        int res = model.newsupdata(Integer.parseInt(newsId), Title, Content, newsdate);
        int re=model.newsshupdata2(Integer.parseInt(newsId));

        if(res==-1 || re==-1){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("newsxiugai.jsp").forward(req, resp);
        }

    }
}
