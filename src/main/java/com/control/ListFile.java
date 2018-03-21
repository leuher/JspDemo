package com.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ray on 2018/3/16 0016.
 **/
public class ListFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取指定目录
        String FilePath = "f:/test";
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String, String>();
        //递归遍历filepath目录下的所有文件和目录,将文件名存储到map集合中
        listfile(new File(FilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        //将Map集合发送到listfile.jsp页面显示
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("listfile.jsp").forward(request,response);
//        for(String key : fileNameMap.keySet()){
//            System.out.println("key : " + key);
//        }
//        for(String value : fileNameMap.values()){
//            System.out.println("value : " + value);
//        }
    }

    /**
    * @Author: Ray
    * @Date: 2018/3/17 0017
    * @Description: 递归遍历指定目录下的所有文件和目录,并将文件名存储到Map集合中
    * @Return:
    */
    public void listfile(File file,Map<String,String> map){
        //如果file代表的不是一个文件,而是一个目录
        if(!file.isFile()){
            //列出该目录下的所有文件和目录
            File[] files = file.listFiles();
            //遍历files[]数组
            for(File f:files){
                //递归
                listfile(f,map);
            }
        }else{
            String fileOrgName = file.getName();
            int index = fileOrgName.lastIndexOf(".");
            String fileName = fileOrgName.substring(0,index);
            System.out.println(file.getName());
            map.put(file.getName(),fileName);
        }
    }
}
