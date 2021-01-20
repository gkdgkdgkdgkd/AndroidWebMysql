package com.example.javawebdemo.utils

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DBUtils {
    companion object {
        val connection: Connection
            get() {
                Class.forName("com.mysql.cj.jdbc.Driver")
                val url = "jdbc:mysql://127.0.0.1:3306/userinfo"
                val username = "root"
                val password = "123456"
                return DriverManager.getConnection(url, username, password)
            }

        fun closeConnection(){
            try{
                connection.close()
            }catch (e:SQLException){
                e.printStackTrace()
            }
        }
    }
}