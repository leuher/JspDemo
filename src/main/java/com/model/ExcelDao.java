package com.model;

import com.dbutil.Dbconn;
import com.entity.Book;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/19 0019.
 **/
public class ExcelDao {

    Dbconn dbconn = new Dbconn();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    HSSFWorkbook hssfWorkbook = null;

    /**
    * @Author: Ray
    * @Date: 2018/3/19 0019
    * @Description: 导出Excel
    * @Return: HSSFWorkbook
    */
    public HSSFWorkbook Output() {
        try {
            conn = dbconn.getConnection();
            //查询语句
            String sql = "select * from booktable";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            //创建Excel文档
            hssfWorkbook = new HSSFWorkbook();
            //生成一个表格-->表名为"图书信息"
            HSSFSheet hssfSheet = hssfWorkbook.createSheet("图书信息");
            //产生表格标题行
            HSSFRow row = hssfSheet.createRow(0);
            //每列信息
            row.createCell(0).setCellValue("编号");
            row.createCell(1).setCellValue("图书名");
            row.createCell(2).setCellValue("价格");
            row.createCell(3).setCellValue("数量");
            row.createCell(4).setCellValue("作者");

            //跳过标题行
            int index = 1;

            while (rs.next()) {
                //下一行开始
                row = hssfSheet.createRow(index++);
                //每列信息
                row.createCell(0).setCellValue(rs.getInt("id"));
                row.createCell(1).setCellValue(rs.getString("name"));
                row.createCell(2).setCellValue(rs.getDouble("price"));
                row.createCell(3).setCellValue(rs.getInt("bookCount"));
                row.createCell(4).setCellValue(rs.getString("author"));
            }
            //关闭连接
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hssfWorkbook;
    }
}
