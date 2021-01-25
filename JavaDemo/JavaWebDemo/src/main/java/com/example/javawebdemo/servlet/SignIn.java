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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Dao dao = new Dao();
        User user = new User(name, password);
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody body = new ResponseBody();

        if (dao.select(user)) {
            body.setCode(200);
            body.setData("success");
        } else {
            body.setCode(404);
            body.setData("failed");
        }
        mapper.writeValue(resp.getWriter(), body);
    }
}