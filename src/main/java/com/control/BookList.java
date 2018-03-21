package com.control;

import com.model.BookModel;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ray on 2018/3/11 0011.
 **/
public class BookList extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //调用模型
        BookModel BookModel = new BookModel();
        //调用查询方法,返回booklist集合
        List booklist = BookModel.bookList();
        //不同页面间传值,传递一次后,request失去作用
        request.setAttribute("booklist",booklist);
        //request请求转发 不会改变路径
        request.getRequestDispatcher("/bookList.jsp").forward(request,response);
    }
}
