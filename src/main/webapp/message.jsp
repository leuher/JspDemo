<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.entity.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>提示信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/userStyle.css">

</head>

<body>
<div class="head">提示信息</div>
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
<div class="out">
    <%
        //获取提示信息
        String info = String.valueOf(request.getAttribute("info"));
        //如果提示信息不为空,则输出提示信息
        if (info != "null") {
            out.print(info);
        }
        //获取登录的用户信息
        User user = (User) session.getAttribute("user");
        //判断用户是否登录
        if (user != null) {
    %>
    <div class="divmsg">
        <table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
            <tr>
                <td align="center" colspan="2">
                    <span style="font-weight: bold;font-size: 18px;"><%=user.getUsername() %></span>登录成功！
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">头像:</td>
                <td><img src="<%=user.getPhoto() %>"></td>
            </tr>
            <tr>
                <td align="right">性别:</td>
                <td><%=user.getSex() %>
                </td>
            </tr>
            <tr>
                <td align="right">联系电话：</td>
                <td><%=user.getTel()%>
                </td>
            </tr>
            <tr>
                <td align="right">电子邮箱：</td>
                <td><%=user.getEmail()%>
                </td>
            </tr>
        </table>
    </div>
    <%
        } else {
            out.print("<br>对不起，您还没有<a href='loginUser.jsp'>登录</a>！");
        }
    %>
</div>
</body>
</html>