package com.model;

import com.dbutil.Dbconn;
import com.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class BookFindDao {
    Dbconn dbconn = new Dbconn();
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Book book = null;

    /**
    * @Author: Ray
    * @Date: 2018/3/12 0012
    * @Description: 分页查询图书
    * @Return: bookList
    */
    public List find(int page){
        //创建List
        List bookList = new ArrayList();

        try{
            //获取数据库连接
            conn = dbconn.getConnection();
            //分页查询的sql语句
            String sql = "select * from booktable order by id asc limit ?,?";
            //获取PreparedStatement
            ps = conn.prepareStatement(sql);
            //对占位符进行赋值
            ps.setInt(1,(page-1) * Book.PAGE_SIZE);
            ps.setInt(2,Book.PAGE_SIZE);
            //执行查询操作
            rs = ps.executeQuery();
            //光标向后移动,并判断是否有效
            while(rs.next()){
                //实例化Book
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setBookCount(rs.getInt("bookCount"));
                book.setAuthor(rs.getString("author"));
                //将book对象添加到集合中
                bookList.add(book);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/12 0012
    * @Description: 查询数据表总行数
    * @Return: 总行数
    */
    public int findCount(){
        //总行数
        int count = 0;

        try{
            //获取数据库连接
            conn = dbconn.getConnection();
            //查询总行数的sql语句
            String sql = "select count(*) from booktable";
            //创建Statement
            st = conn.createStatement();
            //查询并获取ResultSet
            rs = st.executeQuery(sql);
            //光标向后移动,并判断是否有效
            if(rs.next()){
                //取出count(*)字段的值对总行数赋值
                count = rs.getInt(1);
            }
            rs.close();
            st.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回总行数
        return count;
    }
}
