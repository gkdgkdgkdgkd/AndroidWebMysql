package com.dao;

import com.entity.User;
import com.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean query(User user)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "select * from user where name = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtils.closeConnection();
        }
    }

    public boolean add(User user)
    {
        Connection connection = DBUtils.getConnection();
        String sql = "insert into user(name,password) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtils.closeConnection();
        }
    }
}
