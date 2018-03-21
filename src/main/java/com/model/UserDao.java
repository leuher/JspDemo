package com.model;

import com.dbutil.Dbconn;
import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ray on 2018/3/14 0014.
 **/
public class UserDao {

    User user = null;
    Dbconn dbconn = new Dbconn();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
    * @Author: Ray
    * @Date: 2018/3/14 0014
    * @Description: 用户登录
    * @Return: User对象
    */
    public User login(String username,String password){
        //数据库连接
        connection = dbconn.getConnection();
        //查询是否用户和密码
        String sql = "select * from user where username = ? and password = ?";

        try {
            //获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            //对占位符进行动态赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //执行查询并获取结果集
            resultSet = preparedStatement.executeQuery();
            //判断结果集是否有效
            if(resultSet.next()){
                //实例化user对象
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setSex(resultSet.getString("sex"));
                user.setTel(resultSet.getString("tel"));
                user.setPhoto(resultSet.getString("photo"));
                user.setEmail(resultSet.getString("email"));
            }
            //释放资源
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/14 0014
    * @Description: 判断用户名在数据库中是否存在
    * @Return: boolean
    */
    public boolean userIsExist(String username){
        //获取数据库连接
        connection = dbconn.getConnection();
        //根据用户名查询的sql语句
        String sql = "select * from user where username = ?";

        try{
            //获取PreparedStatement对象
            preparedStatement= connection.prepareStatement(sql);
            //对占位符进行动态赋值
            preparedStatement.setString(1,username);
            //执行查询并获取结果集
            resultSet = preparedStatement.executeQuery();
            //判断结果集是否有效
            if(!resultSet.next()){
                //如果无效则证明此用户名可用
                return true;
            }
            //释放资源
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/14 0014
    * @Description: 新增用户
    * @Return:
    */
    public void addUser(User user){
        //获取数据库连接
        connection = dbconn.getConnection();
        //新增用户信息的sql语句
        String sql = "insert into user(username,password,sex,tel,photo,email) values (?,?,?,?,?,?)";

        try{
            //获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            //对占位符进行动态赋值
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setString(4,user.getTel());
            preparedStatement.setString(5,user.getPhoto());
            preparedStatement.setString(6,user.getEmail());
            //执行新增操作
            preparedStatement.executeUpdate();
            //释放资源
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
