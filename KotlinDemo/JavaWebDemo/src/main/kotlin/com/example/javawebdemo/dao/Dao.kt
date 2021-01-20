package com.example.javawebdemo.dao

import com.example.javawebdemo.entity.User
import com.example.javawebdemo.utils.DBUtils
import java.sql.SQLException

class Dao {
    fun select(user: User):Boolean{
        val connection = DBUtils.connection
        val sql = "select * from user where name = ? and password = ?"
        return try{
            val preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1,user.name)
            preparedStatement.setString(2,user.password)
            val resultSet = preparedStatement.executeQuery()
            resultSet.next()
        }catch (e:SQLException){
            e.printStackTrace()
            false
        }finally {
            DBUtils.closeConnection()
        }
    }

    fun insert(user:User):Boolean{
        val connection = DBUtils.connection
        val sql = "insert into user(name,password) values(?,?)"
        return try {
            val preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1,user.name)
            preparedStatement.setString(2,user.password)
            return preparedStatement.updateCount != 0
        }catch (e:SQLException){
            e.printStackTrace()
            false
        }finally {
            DBUtils.closeConnection()
        }
    }
}