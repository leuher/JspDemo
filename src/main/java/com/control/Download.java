package com.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by Ray on 2018/3/16 0016.
 **/
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到要下载的文件名
        String fileName = request.getParameter("filename");
        System.out.println("fileName: " + fileName);
        //要下载的文件的目录
        String fileSavePath = "f:/test";
        //要下载的文件
        File file = new File(fileSavePath + File.separator + fileName);
        System.out.println("得到下载文件: " + file.getName());
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("info","您要下载的资源已被删除!");
            request.getRequestDispatcher("messagedownload.jsp").forward(request,response);
            return;
        }
        //处理文件名
        int index = fileName.lastIndexOf(".");
        String realname = fileName.substring(0,index);
        System.out.println("realname : " + realname);

        //设置响应头,控制浏览器下载该文件
        response.setHeader("content-disposition","attachment;filename*=UTF-8''" + URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20"));
        //读取要下载的文件,保存到文件输入流
        FileInputStream in = new FileInputStream(fileSavePath + File.separator + fileName);
        System.out.println("读取下载文件: " + fileSavePath + File.separator + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while(0<=(len=in.read(buffer))){
            //输出缓冲区的内容到浏览器,实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入输出流
        out.close();
        in.close();
    }
}
