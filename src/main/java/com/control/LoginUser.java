package com.control;

import com.entity.User;
import com.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/14 0014.
 **/
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        /**
        * @Author: Ray
        * @Date: 2018/3/15 0015
        * @Description: Cookie
        */
        //首先判断用户是否选择了记住登录状态
        String[] isUseCookies = request.getParameterValues("isUseCookie");
        if(isUseCookies != null && isUseCookies.length > 0){
            System.out.println("选择了记住登录状态!");
            //以键值对创建一个Cookie
            Cookie usernameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password",password);

            //设置最大生存期限为10天
            usernameCookie.setMaxAge(864000);
            passwordCookie.setMaxAge(864000);

            //保存Cookie
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }else{
            System.out.println("没有选择记住登录状态!");
            //创建一个Cookie对象数组
            Cookie[] cookies = request.getCookies();
            if(cookies != null && cookies.length > 0 ){
                for(Cookie cookie : cookies){
                    //判断元素的值是否为username和password中的值
                    if(cookie.getName().equals("username") || cookie.getName().equals("password")){
                        //设置Cookie失效
                        cookie.setMaxAge(0);
                        //重新保存
                        response.addCookie(cookie);
                    }
                }
            }
        }

        //调用模型
        UserDao userDao = new UserDao();
        //调用登录方法
        User user = userDao.login(username,password);
        if(user != null){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }else{
            request.setAttribute("info","错误:用户名或密码有误!");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }
}
