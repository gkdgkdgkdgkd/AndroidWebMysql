package com.example.javawebdemo.servlet

import com.example.javawebdemo.dao.Dao
import com.example.javawebdemo.entity.User
import com.example.javawebdemo.response.ResponseBody
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet("/sign/in")
class SignIn : HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (req != null && resp != null) {
            req.characterEncoding = "utf-8"
            resp.characterEncoding = "utf-8"
            resp.contentType = "application/json;charset=utf-8"
            val name = req.getParameter("name")
            val password = req.getParameter("password")

            val dao = Dao()
            val user = User(name, password)
            val mapper = ObjectMapper()
            val body = ResponseBody()

            if (dao.select(user)) {
                body.code = 200
                body.data = "success"
            } else {
                body.code = 404
                body.data = "failed"
            }
            mapper.writeValue(resp.writer, body)
        }
    }
}