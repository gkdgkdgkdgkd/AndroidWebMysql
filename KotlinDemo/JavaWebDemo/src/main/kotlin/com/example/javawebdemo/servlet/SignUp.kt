package com.example.javawebdemo.servlet

import com.example.javawebdemo.dao.Dao
import com.example.javawebdemo.entity.User
import com.example.javawebdemo.response.ResponseBody
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet("/sign/up")
class SignUp : HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doPost in sign up")
        println(req == null)
        println(resp == null)
        if (req != null && resp != null) {
            req.characterEncoding = "utf-8"
            resp.characterEncoding = "utf-8"
            resp.contentType = "application/json;charset=utf-8"
            val name = req.getParameter("name")
            val password = req.getParameter("password")

            println(name)
            println(password)

            val dao = Dao()
            val user = User(name, password)
            val mapper = ObjectMapper()
            val body = ResponseBody()

            if (dao.insert(user)) {
                body.code = 200
                body.data = "success"
            } else {
                body.code = 500
                body.data = "failed"
            }
            mapper.writeValue(resp.writer, body)
        }
    }
}