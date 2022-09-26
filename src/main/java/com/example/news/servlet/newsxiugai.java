package com.example.news.servlet;

import com.alibaba.fastjson.JSON;
import com.example.news.utils.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class newsxiugai extends HelloServlet{

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
        Map user = (Map) req.getSession().getAttribute("user");
        String newsTitle = req.getParameter("newsTitles");
        String author = (String) user.get("username");
        Model model = new Model();
        List res = model.selectxiugaiWithUtil(newsTitle,author);
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
