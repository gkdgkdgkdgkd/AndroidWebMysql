package com.example.javawebdemo.servlet;

import com.example.javawebdemo.dao.Dao;
import com.example.javawebdemo.entity.User;
import com.example.javawebdemo.response.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sign/in")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Dao dao = new Dao();
        User user = new User(name,password);
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody body = new ResponseBody();

        if (dao.select(user)) {
            body.setCode(200);
            body.setData("success");
        } else {
            body.setCode(404);
            body.setData("failed");
        }
        mapper.writeValue(response.getWriter(), body);
    }
}