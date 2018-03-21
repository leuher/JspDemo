package com.control;

import com.model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ray on 2018/3/11 0011.
 **/
public class BookUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据input name获取值
        int id = Integer.parseInt(request.getParameter("id"));
        //调用模型
        BookModel BookModel = new BookModel();
        //调用查询方法(根据id),返回booklist集合
        List booklist = BookModel.listId(id);
        //不同页面间传递,传递一次后,request失去作用
        request.setAttribute("booklist",booklist);
        //request请求,不会改变路径
        request.getRequestDispatcher("/bookUpdate.jsp").forward(request,response);
    }
}
