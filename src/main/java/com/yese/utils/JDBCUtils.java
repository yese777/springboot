package com.yese.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 封装jdbc获取连接和释放资源
 */
public class JDBCUtils {

    private static String driverClass = null;
    private static String url = null;
    private static String name = null;
    private static String password = null;

    static {
        try {
            Properties properties = new Properties();
            InputStream is = new FileInputStream(new File("C:\\Users\\zqf\\Desktop\\jdbc.properties"));

            properties.load(is);

            //读取属性
            driverClass = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            name = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverClass);

            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     *
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        closeResultSet(resultSet);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    public static void release(Connection connection, PreparedStatement preparedStatement) {
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    }

    private static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement = null;
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
