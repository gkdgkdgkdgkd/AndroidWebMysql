package com.util;
import java.sql.*;

public class DBUtils {

    private static Connection connection = null;
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/userinfo";
            String usename = "root";
            String password = "int lcxal = -1";
            connection = DriverManager.getConnection(url,usename,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static void closeConnection()
    {
        if(connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

