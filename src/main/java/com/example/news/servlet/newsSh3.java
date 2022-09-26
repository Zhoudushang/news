package com.example.news.servlet;

import com.alibaba.fastjson.JSON;
import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class newsSh3 extends HelloServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String newsId = req.getParameter("newsId");
        Model model = new Model();
        int res = model.newsshupdata(Integer.parseInt(newsId));
        if(res>0){
            req.getRequestDispatcher("newsSh.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }
}
