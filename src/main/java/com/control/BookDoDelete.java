package com.control;

import com.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class BookDoDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据input name获取值
        int id = Integer.parseInt(request.getParameter("id"));
        //调用模型
        BookModel bookModel = new BookModel();
        //调用删除方法(根据id)
        bookModel.deleteBook(id);
        //response重定向改变路径
        response.sendRedirect(request.getContextPath() + "/BookList");
    }
}
