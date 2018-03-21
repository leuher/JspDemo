package com.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ray on 2018/3/17 0017.
 **/



public class UserEnterListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        ServletContext servletContext = se.getSession().getServletContext();
        //返回属性name的值
        Integer totalcount = (Integer) servletContext.getAttribute("totalcount");
        Integer accesscount = (Integer) servletContext.getAttribute("accesscount");
        //使用指定的属性名字绑定一个对象并储存到session中
        servletContext.setAttribute("totalcount",totalcount+1);
        servletContext.setAttribute("accesscount",accesscount+1);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext servletContext = se.getSession().getServletContext();
        //返回属性name的值
        Integer accesscount = (Integer) servletContext.getAttribute("accesscount");
        //使用指定的属性名字绑定一个对象并储存到session中
        servletContext.setAttribute("accesscount",accesscount-1);
    }
}
