package com.example.laogong.JDBC;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @author admin
 */
public class JDBCCode {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 根据驱动管理器获取链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8","root","root");
            // 定义sql
            String sql = "select * from user where userName = ?";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setString(1,"ca");
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
