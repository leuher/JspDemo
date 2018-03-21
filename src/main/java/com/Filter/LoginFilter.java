package com.Filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ray on 2018/3/13 0013.
 **/
public class LoginFilter implements Filter {

    private FilterConfig config;

    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }
    //拦截请求
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession();

        //不拦截的地址
        String noLoginPaths = config.getInitParameter("noLoginPaths");

        if(noLoginPaths != null){
            //使用";"分割
            String[] strArray = noLoginPaths.split(";");
            for(int i = 0; i < strArray.length; i++){
                if(strArray[i] == null || "".equals(strArray[i])){
                    continue;
                }
                //httpServletRequest.getRequestURI()获取请求页面的相对路径
                //indexOf如果此字符串中没有这样的字符，则返回 -1
                if(httpServletRequest.getRequestURI().indexOf(strArray[i]) != -1){
                    chain.doFilter(request,response);
                    return;
                }
            }
        }
        //获取session中的username(sessinon在用户访问第一次访问服务器时创建)
        if(httpSession.getAttribute("username") != null){
            chain.doFilter(request,response);
        }else{
            httpServletResponse.sendRedirect("login.jsp");
        }
    }
    //销毁
    public void destroy() {

    }
}
