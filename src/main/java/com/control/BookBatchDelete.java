package com.control;

import com.model.BookBatch;
import com.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class BookBatchDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用模型
        BookBatch bookBatch = new BookBatch();
        //调用批量删除图书方法
        bookBatch.deleteBatch();
        //response重定向
        response.sendRedirect(request.getContextPath() + "/BookList");
    }
}
