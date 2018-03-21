package com.model;

import com.dbutil.Dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class BookBatch {

    Dbconn dbconn = new Dbconn();
    Connection conn = null;
    PreparedStatement ps = null;

    /**
    * @Author: Ray
    * @Date: 2018/3/12 0012
    * @Description: 批量新增图书
    * @Return: 行数
    */
    public int saveBatch(){
        //行数
        int row = 0;

        try{
            //获取数据库连接
            conn = dbconn.getConnection();
            //插入数据的sql语句
            String sql = "insert into booktable(id,name,price,bookCount,author) values (?,?,?,?,?)";
            //实例化PreparedStatement
            ps = conn.prepareStatement(sql);
            //实例化Random
            Random random = new Random();
            //循环添加数据
            for(int i = 10; i < 20; i++){
                //对占位符进行赋值
                ps.setInt(1, i + 1);
                ps.setString(2,"图书" + i);
                ps.setDouble(3, i%2);
                ps.setInt(4,random.nextInt(5) + 10);
                ps.setString(5,"作者" + i);
                //添加批处理命令
                ps.addBatch();
            }
            //执行批处理操作并返回计数组成的数组
            int[] rows = ps.executeBatch();
            //对row赋值所影响的行数
            row = rows.length;
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/12 0012
    * @Description: 批量删除图书
    * @Return: 行数
    */
    public int deleteBatch(){
        //行数
        int row = 0;

        try{
            //获取数据库连接
            conn = dbconn.getConnection();
            //删除数据的sql语句
            String sql = "delete from booktable where id = ?";
            //获取PreparedStatement
            ps = conn.prepareStatement(sql);
            //循环删除数据(根据id删除)
            for(int i = 11; i <= 20; i++){
                //对占位符进行赋值
                ps.setInt(1,i);
                // 添加批处理命令
                ps.addBatch();
            }
            //执行批处理操作并返回计数组成的数组
            int[] rows = ps.executeBatch();
            //对row赋值所影响的行数
            row = rows.length;
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
