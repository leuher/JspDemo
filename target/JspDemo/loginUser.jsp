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

    <title>用户登录</title>

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

    //获取cookie数组
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length>0){
        for(Cookie cookie : cookies){
            //获取值
            if(cookie.getName().equals("username")){
                username = cookie.getValue();
                System.out.println("loginCookie username: " + username);
            }
            if(cookie.getName().equals("password")){
                password = cookie.getValue();
                System.out.println("loginCookie password: " + password);
            }
        }
    }
%>
<div class="border">
    <div class="head">登录用户</div>
    <div class="div1">
        <ul>
            <li><a href="registerUser.jsp"> 用户注册 |</a></li>
            <li><a href="loginUser.jsp"> 用户登录 |</a> </li>
            <li><a href="message.jsp"> 当前用户 |</a></li>
            <li><a href="cookie.jsp"> 查看cookie |</a></li>
            <li><a href="ExitLogin"> 退出登录 |</a></li>
            <li><a href="file.jsp"> 文件管理 |</a></li>
            <li><a href="upload.jsp"> 上传文件 |</a></li>
        </ul>
    </div>
    <div class="div2">
        <form action="<%=request.getContextPath()%>/LoginUser" method="post" onsubmit="return login(this)">
            <table align="center" width="300" border="0">
                <tr>
                    <td align="right">用户名:</td>
                    <td><input type="text" name="username" value="<%=username%>"></td>
                </tr>
                <tr>
                    <td align="right">密码:</td>
                    <td><input type="text" name="password" value="<%=password%>"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center" height="50">
                        <input type="checkbox" name="isUseCookie">十天内记住我的登录状态
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" height="50">
                        <input type="submit" value="登录">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>