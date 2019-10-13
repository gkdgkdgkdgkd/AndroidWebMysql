package com.servlet;

import com.dao.UserDao;
import com.entity.User;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");//设定编码防止中文乱码
        httpServletResponse.setContentType("text/plain;charset=utf-8");//设置相应类型为html,编码为utf-8

        String name = httpServletRequest.getParameter("name");//根据name获取参数
        String password = httpServletRequest.getParameter("password");//根据password获取参数

        UserDao userDao = new UserDao();
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        if(!userDao.add(user)) //若添加失败
        {
            httpServletResponse.sendError(204,"add failed.");//设置204错误码与出错信息
        }
    }
}
