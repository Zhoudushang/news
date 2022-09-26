package com.example.news.utils;

import com.example.news.entity.Page;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DBUtil {
    public static Connection getConn(){

        String url = "jdbc:mysql://localhost:3306/newsdata?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String pwd = "189400103";

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;

    }

    public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
