package com.control;

import com.entity.User;
import com.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/14 0014.
 **/
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取input name值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String photo = request.getParameter("photo");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");

        //username输出到控制台
        System.out.println("username = " + username);

        //调用模型
        UserDao userDao = new UserDao();
        if(username != null){
            //判断用户名在数据库中是否存在
            if(userDao.userIsExist(username)){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setSex(sex);
                user.setPhoto(photo);
                user.setTel(tel);
                user.setEmail(email);
                //执行新增操作
                userDao.addUser(user);
                request.setAttribute("info","恭喜,注册成功!<br>");
            }else{
                request.setAttribute("info","错误:此用户名已存在!<br>");
            }
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
