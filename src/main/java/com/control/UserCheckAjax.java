package com.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ray on 2018/3/18 0018.
 **/
public class UserCheckAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模拟存在数据库里的账号
        String[] arr = {"张三","李四","admin"};
        //获取页面传来的数据
        String username = request.getParameter("username");
        System.out.println("username: " + username);

        //模拟和数据库里信息匹配
        boolean mark = false;
        for(String user:arr){
            if(user.equals(username)){
                mark = true;
                break;
            }
        }

        //响应页面
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(mark){
            out.println("<font color='red'>该用户名已经存在，请重新输入!!</font>");
        }else {
            out.println("<font color='green'>恭喜您，该用户名可以使用!!</font>");
        }
        //刷新流
        out.flush();
        //关闭流
        out.close();
    }
}
