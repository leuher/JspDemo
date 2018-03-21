package com.control;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/14 0014.
 **/
public class ExitLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();
        //获取用户对象
        User user = (User) session.getAttribute("user");
        //判断用户是否有效
        if(user != null){
            //将用户对象逐出session
            session.removeAttribute("user");
            //设置提示信息
            request.setAttribute("info",user.getUsername() + " 已成功退出!");
        }
        //转发到message.jsp页面
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
