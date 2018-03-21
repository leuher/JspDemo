package com.control;

import com.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ray on 2018/3/18 0018.
 **/
public class UserCheckAjax2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面传来的数据
        String username = request.getParameter("username");

        //调用模型
        UserDao userDao = new UserDao();
        //判断用户名在数据库中是否存在
        boolean makr = userDao.userIsExist(username);
        System.out.println("makr: " + makr);

        //响应页面
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(!makr){
            out.println("<font color='red'>该用户名已经存在，请重新输入!!</font>");
        }else{
            out.println("<font color='green'>恭喜您，该用户名可以使用!!</font>");
        }
        //刷新流
        out.flush();
        //关闭流
        out.close();
    }
}
