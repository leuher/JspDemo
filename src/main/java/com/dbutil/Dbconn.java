package com.dbutil;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by Ray on 2018/3/10 0010.
 **/
public class Dbconn {
//    数据库,端口号
    private static final String url = "jdbc:mysql://localhost:3306/Book?characterEncoding=utf-8&useSSL=true";
//    数据库用户名
    private static final String username = "root";
//    数据库登录密码
    private static final String password = "root";
//    数据库驱动固定
    private static final String jdbcName = "com.mysql.jdbc.Driver";

   /**
   * @Author: Ray
   * @Date: 2018/3/11 0011
   * @Description: 数据库连接
   * @Return: Connection对象
   */
    public Connection getConnection(){
        //创建Connection连接对象
        Connection conn = null;
        try{
            //加载数据库驱动并将其注册到驱动管理列表中
            Class.forName(jdbcName);
            //连接数据库操作
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回conn
        return conn;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/11 0011
    * @Description: 关闭数据库连接
    * @Return:
    */
    public void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(preparedStatement != null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if(connection != null){
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
