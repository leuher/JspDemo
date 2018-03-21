package com.model;

import com.dbutil.Dbconn;
import com.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/11 0011.
 **/
public class BookModel {

    Dbconn Dbconn = new Dbconn();
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs;

    /**
    * @Author: Ray
    * @Date: 2018/3/11 0011
    * @Description: 查询所有图书信息
    * @Return: booklist
    */
    public List<Book> bookList(){
        //创建booklist集合
        List booklist = new ArrayList();
        Book Book = null;
        try{
            //创建Connection连接
            conn = Dbconn.getConnection();
            //查询所有图书信息的sql语句
            String sql = "select * from booktable";
            //获取PreparedStatement
            ps = conn.prepareStatement(sql);
            //执行查询
            rs = ps.executeQuery();
            //判断光标向后移动,并判断是否有效
            while (rs.next()){
                //实例化Book对象
                Book = new Book();
                //对id属性赋值
                Book.setId(rs.getInt("id"));
                //对name属性赋值
                Book.setName(rs.getString("name"));
                //对price属性赋值
                Book.setPrice(rs.getDouble("price"));
                //对bookCount属性赋值
                Book.setBookCount(rs.getInt("bookCount"));
                //对author属性赋值
                Book.setAuthor(rs.getString("author"));
                //将book对象添加到集合中
                booklist.add(Book);
            }
            //关闭连接
            Dbconn.closeConnection(conn,ps,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回booklist集合
        return booklist;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/11 0011
    * @Description: 新增图书信息
    * @Return:
    */
    public void addBook(int id,String name,double price,int bookCount,String author){
        try{
            //创建Connection连接
            conn = Dbconn.getConnection();
            //添加图书信息的sql语句
            String sql = "insert into booktable(id,name,price,bookCount,author) values(?,?,?,?,?)";
            //获取PrepareStatement
            ps = conn.prepareStatement(sql);
            //对占位符进行赋值
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setInt(4,bookCount);
            ps.setString(5,author);
            //执行更新,返回更新锁影响的行数
            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("添加数据成功");
            }
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println("添加数据失败");
            e.printStackTrace();
        }
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/11 0011
    * @Description: 根据Id查询图书信息
    * @Return: booklist集合
    */
    public List<Book> listId(int id){
        //创建booklist集合
        List booklist = new ArrayList();
        Book Book = null;
        try{
            //创建Connection 连接
            conn = Dbconn.getConnection();
            //根据id查询图书信息的sql语句
            String sql = "select * from booktable where id = ?";
            //创建PreparedStatement
            ps = conn.prepareStatement(sql);
            //对占位符进行赋值
            ps.setInt(1,id);
            //执行查询
            rs = ps.executeQuery();
            //判断光标向后移动,并判断是否有效
            while(rs.next()){
                Book = new Book();
                Book.setId(rs.getInt("id"));
                Book.setName(rs.getString("name"));
                Book.setPrice(rs.getDouble("price"));
                Book.setBookCount(rs.getInt("bookCount"));
                Book.setAuthor(rs.getString("author"));
                booklist.add(Book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return booklist;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/11 0011
    * @Description: 修改图书信息
    * @Return:
    */
    public void updateBook(int id,String name,double price,int bookCount,String author){
        try{
            //创建Connection连接
            conn = Dbconn.getConnection();
            //更新图书信息的sql语句
            String sql = "update booktable set name=?,price=?,bookCount=?,author=? where id=?";
            //获取PreparedStatement
            ps = conn.prepareStatement(sql);
            //对占位符进行赋值
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,bookCount);
            ps.setString(4,author);
            ps.setInt(5,id);
            //执行更新
            int row = ps.executeUpdate();
            //判断是否有效
            if(row > 0){
                System.out.println("修改数据成功");
            }
            //关闭连接
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/12 0012
    * @Description: 根据Id删除图书信息
    * @Return:
    */
    public void deleteBook(int id){
        try{
            //创建Connection连接
            conn = Dbconn.getConnection();
            //删除图书信息的SQL语句
            String sql = "delete from booktable where id = ?";
            //获取PreparedStatement
            ps = conn.prepareStatement(sql);
            //对占位符进行赋值
            ps.setInt(1,id);
            //执行删除
            int row = ps.executeUpdate();
            //判断是否有效
            if(row > 0){
                System.out.println("删除数据成功");
            }
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
