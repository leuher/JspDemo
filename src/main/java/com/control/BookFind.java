package com.control;

import com.entity.Book;
import com.model.BookFindDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class BookFind extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前页码
        int currPage = 1;
        //判断传递页码是否有效
        if(request.getParameter("page") != null){
            //对当前页码赋值
            currPage = Integer.parseInt(request.getParameter("page"));
        }
        //实例化BookFindDao
        BookFindDao bookFindDao = new BookFindDao();
        //查询数据表总行数
        List booklist = bookFindDao.find(currPage);
        //request值传递
        request.setAttribute("booklist",booklist);

        //总页数
        int pages;
        //查询总行数
        int count = bookFindDao.findCount();
        //计算总页数
        if(count % Book.PAGE_SIZE == 0){
            //对总页数赋值
            pages = count / Book.PAGE_SIZE;
        }else{
            //对总页数赋值
            pages = count / Book.PAGE_SIZE + 1;
        }

        //实例化StringBuffer
        StringBuffer sb = new StringBuffer();
        //通过循环构建分页条
        for(int i = 1; i <= pages; i++){
            //判断是否为当前页
            if (i == currPage){
                //构建分页条
                sb.append("[" + i + "]");
            }else{
                //构建分页条
                sb.append("<a href='BookFind?page=" + i + "'>" + i + "</a>");
            }
            sb.append(" ");
        }
        //将分页条的字符串放置到request中
        request.setAttribute("bar",sb.toString());
        //转发到bookList
        request.getRequestDispatcher("/bookFind.jsp").forward(request,response);
    }
}
