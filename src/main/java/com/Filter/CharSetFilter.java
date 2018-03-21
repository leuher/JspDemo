package com.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/12 0012.
 **/
public class CharSetFilter implements Filter{

    private FilterConfig config;

    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----过滤器初始化----");
        config = filterConfig;
    }

    //拦截请求
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String charset = config.getInitParameter("charset");
        if(charset == null){
            charset = "UTF-8";
        }
        servletRequest.setCharacterEncoding(charset);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}
