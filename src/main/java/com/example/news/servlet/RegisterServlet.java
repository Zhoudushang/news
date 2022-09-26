package com.example.news.servlet;

import com.example.news.entity.User;
import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class RegisterServlet extends HelloServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String qpassword = req.getParameter("qpassword");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Model us = new Model();
        List uu=us.selectUserWithUtil(username);
        if(uu.size()>0){
            req.setAttribute("message", "该用户已存在");
            req.getRequestDispatcher("registered.jsp").forward(req, resp);
        }else if(!qpassword.equals(password)) {
            req.setAttribute("message", "两次密码不一致");
            req.getRequestDispatcher("registered.jsp").forward(req, resp);
        }else if(email==null ||phone==null){
            req.setAttribute("message", "请填写邮箱或电话");
            req.getRequestDispatcher("registered.jsp").forward(req, resp);
        }else {
            boolean result = us.addUser(username, password, email, phone, address);
            //如果返回值为真，这返回登录页面
            if (result) {
                resp.sendRedirect("Login.jsp");
            } else {
                resp.sendRedirect("registered.jsp");
            }
        }
    }
}
