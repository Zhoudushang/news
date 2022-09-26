package com.example.news.servlet;

import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class newsSh2 extends HelloServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        Model model =new Model();
        List news = model.selectNewsWithUtil(Integer.parseInt(id));
        Map newss = (Map) news.get(0);
        req.setAttribute("newss",newss);
        req.getRequestDispatcher("newsSh2.jsp").forward(req, resp);

    }
}
