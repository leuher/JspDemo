package com.control;

import com.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/11 0011.
 **/
public class BookAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据input name获取值
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        int bookCount = Integer.valueOf(request.getParameter("bookCount"));
        String author = request.getParameter("author");

        // 输出name 解决乱码
        System.out.println("name = " + name);

        //调用模型
        BookModel BookModel = new BookModel();
        //调用新增方法
        BookModel.addBook(id,name,price,bookCount,author);
        //response重定向改变路径
        response.sendRedirect(request.getContextPath() + "/BookList");
    }
}
