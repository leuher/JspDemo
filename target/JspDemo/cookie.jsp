<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>查看cookie</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/userStyle.css">

</head>

<body>
<%
    String username = "";
    String password = "";

    //将所有的Cookie防盗一个Cookie对象数组里
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0){
        for(Cookie cookie : cookies){
            //获取值
            if(cookie.getName().equals("username")){
                //获取cookie的内容
                username = cookie.getValue();
                System.out.println("cookie username: " + username);
            }
            if(cookie.getName().equals("password")){
                password = cookie.getValue();
                System.out.println("cookie password: " + password);
            }
        }
    }
%>
<div class="border">
    <div class="head">查看cookie</div>
    <div class="div1">
        <ul>
            <li><a href="registerUser.jsp"> 用户注册 |</a></li>
            <li><a href="loginUser.jsp"> 用户登录 |</a> </li>
            <li><a href="message.jsp"> 当前用户 |</a></li>
            <li><a href="cookie.jsp"> 查看cookie |</a></li>
            <li><a href="ExitLogin"> 退出登录 |</a></li>
            <li><a href="file.jsp"> 文件管理 |</a></li>
        </ul>
    </div>
    <div class="divreg">
        用户名:<%=username%>
        <br>
        <br>
        密码:<%=password%>
    </div>
</body>
</html>