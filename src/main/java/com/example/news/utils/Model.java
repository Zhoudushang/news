package com.example.news.utils;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class Model {
    public int updateUser(String userName) throws Exception{
        //第一步，注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("成功执行第一步");
        //第二步，获取连接
        Connection connection=
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/newsdata?serverTimezone=UTC&characterEncoding=gb18030",
                        "root",
                        "189400103");
        PreparedStatement statement=
                connection.prepareStatement(
                        "select * from user" +
                                "where username=?");
        statement.setObject(1,userName);
        int re = statement.executeUpdate();
        //第五步，关闭连接
        connection.close();
        System.out.println("成功执行第五步");
        return re;
    }
//    用户登录查询
    public List selectUserWithUtil(String username){
        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="select * from users where username=?";

        try {
            List res=dbUtil.executeQuery(sql,username);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;

    }
//管理员查询
    public List adminSelectUserWithUtil(String adminId){
        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="select * from admin where adminId=?";

        try {
            List res=dbUtil.executeQuery(sql,adminId);
            return res;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 新增用户
     * @return
     * **/
    public boolean addUser(String username,String password,String email,String phone,String address){
        DbPreparedUtil util=new DbPreparedUtil();
        String sql="insert into users(username,password,email,phone,address) " +
                "values(?,?,?,?,?)";
        int ret= 0;
        try {
            ret= util.executeUpdate(sql,username,password,email,phone,address);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            util.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //注册成功返回true，注册失败返回false
        if(ret>0){
            return true;
        }
        else{
            return false;
        }
    }
    //新闻插入
    public int addNews(String newsTitle, String  newsContent,
                        String newsDate, String Author) {
        DbPreparedUtil util=new DbPreparedUtil();
        String sql="insert into news (newsTitle,newsContent,newsDate,Author)" +
                "value (?,?,?,?)";
        try {
            return util.executeUpdate(sql,newsTitle,newsContent,newsDate,Author);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                util.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;   // sql查询出现错误
    }
    public List selectNewsWithUtil(int newsId){
        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="select * from news where newsId=?";

        try {
            List res=dbUtil.executeQuery(sql,newsId);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;

    }
//    新闻查询
    public List selectnewWithUtil(String  newsTitle){
        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="select * from news where newsTitle like '%"+newsTitle+"%'";
        try {
            List res=dbUtil.executeQuery(sql);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    //    新闻修改查询查询
    public List selectxiugaiWithUtil(String  newsTitle,String Author){

        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="select * from news where newsTitle like '%"+newsTitle+"%' and Author=?";
        try {
            List res=dbUtil.executeQuery(sql,Author);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    //    新闻修改
    public int newsupdata(int newsId,String  newsTitle,String newsContent,String newsDate){

        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="update news set newsTitle='"+newsTitle+
                "',newsContent='"+newsContent+"',newsDate='"+newsDate+"' where newsId='"+newsId+"'";
        try {
            int res=dbUtil.executeUpdate(sql);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }
//    新闻审核修改状态
    public int newsshupdata(int newsId){

        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="update news set Type = 1 where newsId='"+newsId+"'";
        try {
            int res=dbUtil.executeUpdate(sql);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }
    public int newsshupdata2(int newsId){

        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="update news set Type = 0 where newsId='"+newsId+"'";
        try {
            int res=dbUtil.executeUpdate(sql);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }
//    新闻删除
    public int newsdelet(int newsId){

        DbPreparedUtil dbUtil=new DbPreparedUtil();
        String sql="delete from news where newsId='"+newsId+"'";
        try {
            int res=dbUtil.executeUpdate(sql);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dbUtil.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }
}



