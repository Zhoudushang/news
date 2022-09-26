package com.example.news.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.example.news.entity.News;
import com.example.news.utils.DBUtil;
import com.example.news.utils.Model;
import com.google.gson.JsonNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NewsServlet extends HelloServlet{


    /**
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        String newsTitle = req.getParameter("newsTitle");
        Model model = new Model();
        List res = model.selectnewWithUtil(newsTitle);
        String userStr = JSON.toJSONString(res);
        out.write(userStr);
        out.flush();
        out.close();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doGet(req, resp);
    }


}
