package com.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/13 0013.
 **/
public class ErrorFilter implements Filter {
    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //拦截请求
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("检测到有误信息");
        chain.doFilter(request,response);
    }

    //销毁
    public void destroy() {

    }
}

