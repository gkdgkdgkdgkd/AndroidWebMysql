package com.servlet;

import com.dao.UserDao;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignIn")
public class SingIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException, ServletException
    {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/plain;charset=utf-8");//设置相应类型为html,编码为utf-8

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");

        UserDao userDao = new UserDao();
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        if(!userDao.query(user))//若查询失败
        {
            httpServletResponse.sendError(204,"query failed.");//设置204错误码与出错信息
        }
    }
}
