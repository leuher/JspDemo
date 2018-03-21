package com.control;

import com.dbutil.Dbconn;
import com.entity.Book;
import com.model.ExcelDao;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/19 0019.
 **/
public class OutputExcel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置上下文类型
        response.setContentType("application/vnd.ms-excel");
        //设置响应头
        response.setHeader("Content-Disposition","attachment;filename='test.xls'");
        //调用模型
        ExcelDao excelDao = new ExcelDao();
        //调用方法
        HSSFWorkbook hssfWorkbook = excelDao.Output();
        //执行
        hssfWorkbook.write(response.getOutputStream());

    }
}
