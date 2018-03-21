package com.control;

import com.entity.City;
import com.model.CityDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 2018/3/18 0018.
 **/
public class SecondMenu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面传输的数据
        String alias = request.getParameter("city1");
        System.out.println("测试数据alias： " + alias);

        //调用模型
        CityDao cityDao = new CityDao();

        //将页面数据进行匹配，如果匹配成功显示下面创建的城市
        List<City> list = cityDao.listAlias(alias);

        //将list转换为json
        JSONArray jsonArray = JSONArray.fromObject(list);
        //测试
        System.out.println(jsonArray);

        //响应页面
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        //打印json，为了页面获取
        out.println(jsonArray);
        out.flush();
        out.close();
    }
}
