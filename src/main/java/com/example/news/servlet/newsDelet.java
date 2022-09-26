package com.example.news.servlet;

import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class newsDelet extends HelloServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(req.getParameter("id"));
        Model model =new Model();
        int res = model.newsdelet(id);
        if(res>0){
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

    }
}
