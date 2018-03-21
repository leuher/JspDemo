package com.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/13 0013.
 **/
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        //获取密码
        String password = request.getParameter("password");
        //获取验证码
        String checkcode = request.getParameter("checkcode");
        //取出session中的验证码
        String sessioncode = String.valueOf(request.getSession().getAttribute("checkcode"));

        //控制台输出(防止解决乱码和输入错误)
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("checkcode: " + checkcode);
        System.out.println("sessioncode: " + sessioncode);

        if("admin".equals(username) && "admin".equals(password) && checkcode.equals(sessioncode)){
            //校验通过
            HttpSession session = request.getSession();
            //将username保存在session中
            session.setAttribute("username",username);
            //response 重定向
            response.sendRedirect(request.getContextPath() + "/BookList");
        }else{
            //校验失败
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }
    }
}
