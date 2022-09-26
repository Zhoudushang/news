package com.example.news.utils;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbPreparedUtil {
    private Connection connection;
    private PreparedStatement statement;

    /**
     * 初始化和获取connection
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception{
        if (connection==null){ //赋值
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功执行第一步");
            //第二步，获取连接
            connection=
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/newsdata?serverTimezone=UTC&characterEncoding=gb18030&useSSL=false",
                            "root",
                            "189400103");
            System.out.println("成功执行第二步");
        }
        return connection;
    }



    /**
     * 初始化和获取statement
     * @return
     * @throws Exception
     */

    public PreparedStatement getStatement(String sql) throws Exception{
        this.closeStatement();
        if (this.statement==null){
            this.statement= this.getConnection().prepareStatement(sql);
        }
        return this.statement;
    }


    /**
     * 执行查询的方法
     * @param sql
     * @return
     * @throws Exception
     */
    public List executeQuery(String sql, Object...parameters) throws Exception{

        PreparedStatement statement=this.getStatement(sql);
        int index=1;
        for (Object param:parameters){
            statement.setObject(index,param);
            index++;
        }
        ResultSet rs=statement.executeQuery();

        List res=  this.getResult(rs);
        rs.close();
        this.closeStatement();
        return res;
    }
    /**
     * 执行更新、插入、删除的方法
     * @param sql
     * @return
     * @throws Exception
     */
    public int executeUpdate(String sql,Object...parameters) throws Exception{
        PreparedStatement statement=this.getStatement(sql);
        int index=1;
        for (Object param:parameters){
            statement.setObject(index,param);
            index++;
        }
        return this.statement.executeUpdate();
    }

    /**
     * 关闭statement
     */
    public void closeStatement() throws Exception{
        if (this.statement!=null){
            this.statement.close();
            this.statement=null;
        }
    }

    /**
     * 关闭连接
     */
    public void close() throws Exception{
        try{
            this.closeStatement();

        }catch (Exception e){      //无论前面是否关闭statement，这里都要关闭
            e.printStackTrace();
        }

        if (this.connection!=null){
            this.connection.close();
        }
    }

    /**
     * 将Resultset转化为list
     * @param rs
     * @return
     */
    public List getResult(ResultSet rs)throws Exception{
        ResultSetMetaData metaData=rs.getMetaData();
        List trs=new ArrayList();
        while (rs.next()){
            Map temp=new HashMap();
            for(int i=1;i<=metaData.getColumnCount();i++){
                String key=metaData.getColumnName(i);
                Object val=rs.getObject(i);
                temp.put(key,val);
            }
            trs.add(temp);
        }
        return trs;
    }
}
