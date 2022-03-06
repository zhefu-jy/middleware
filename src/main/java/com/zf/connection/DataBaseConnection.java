package com.zf.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String DBDriver ="com.mysql.cj.jdbc.Driver";
    private final String DBURL ="jdbc:mysql://localhost:3306/middleware";
    private final String DBUSER ="root";
    private final String DBPASSWORD ="123456";
    private Connection conn = null;
    //构造器
    public DataBaseConnection(){
        try{
            Class.forName(DBDriver);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }
        catch(Exception e){  }
    }

    //获得连接
    public Connection getConnection(){
        return this.conn; }

    //关闭连接
    public void close() throws SQLException {
        this.conn.close(); }

}
