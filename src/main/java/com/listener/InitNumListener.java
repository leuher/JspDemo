package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

/**
 * Created by Ray on 2018/3/17 0017.
 **/

public class InitNumListener implements ServletContextListener {

    //初始化上下文
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        //创建接口
        ServletContext servletContext = sce.getServletContext();
        //访问总数的文件路径
        String filename = servletContext.getRealPath("/WEB-INF/count.txt");
        File file = new File(filename);
        //初始化访问总数
        Integer totalcount = 0;

        if(file.exists()){
            try{
                //读取文件内容
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                totalcount = Integer.valueOf(bufferedReader.readLine());
                //关闭流
                bufferedReader.close();
                fileReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //设置属性name的值为value
        servletContext.setAttribute("totalcount",totalcount); //访问总数
        servletContext.setAttribute("accesscount",0); //在线用户数
    }

    //销毁上下文
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      //创建接口
      ServletContext servletContext = sce.getServletContext();
      //访问总数的文件路径
      String filename = servletContext.getRealPath("/WEB-INF/count.txt");
      File file = new File(filename);
      try{
          //将内容写入文件
          FileWriter fileWriter = new FileWriter(file);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          bufferedWriter.write(servletContext.getAttribute("totalcount").toString());
          //关闭流
          bufferedWriter.close();
          fileWriter.close();
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
