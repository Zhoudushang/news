package com.example.news.servlet;

import com.example.news.entity.News;
import com.example.news.utils.DBHelper;
import com.example.news.utils.DbPreparedUtil;
import com.example.news.utils.Model;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class LoginServlet extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String pass = req.getParameter("password");

        Connection conn = null;
        try {
            conn = DBHelper.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Model model = new Model();
        List us = model.selectUserWithUtil(name);
        if(us==null || us.isEmpty()){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }else if (us.size() > 1) {
            req.setAttribute("message", "用户存在多条");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }else {
            Map user = (Map) us.get(0);
            String dbPassword = (String) user.get("password");
            if (dbPassword.equals(pass)) {
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "密码错误");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
