<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="com.entity.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>显示文件和目录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="css/userStyle.css">
</head>

<body>
<div class="head">文件操作</div>
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
        <h2>默认路径(不填写):d:/</h2>
        <form action="manager.jsp" method="post">
            <table>
                <tr>
                    <td>文件/目录浏览</td>
                    <td>输入路径:</td>
                    <td><input type="text" name="catalog"></td>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td>创建目录:</td>
                    <td>输入路径:</td>
                    <td><input type="text" name="path1"></td>
                    <td>输入目录名:</td>
                    <td><input type="text" name="name1"></td>
                    <td><input type="submit" value="创建"></td>
                </tr>
                <tr>
                    <td>创建文件:</td>
                    <td>输入路径:</td>
                    <td><input type="text" name="path2"></td>
                    <td>输入文件名:</td>
                    <td><input type="text" name="name2"></td>
                    <td><input type="submit" value="创建"></td>
                </tr>
                <tr>
                    <td>删除目录:</td>
                    <td>输入路径:</td>
                    <td><input type="text" name="path3"></td>
                    <td>输入目录名:</td>
                    <td><input type="text" name="name3"></td>
                    <td><input type="submit" value="删除"></td>
                </tr>
                <tr>
                    <td>删除文件:</td>
                    <td>输入路径:</td>
                    <td><input type="text" name="path4"></td>
                    <td>输入文件名:</td>
                    <td><input type="text" name="name4"></td>
                    <td><input type="submit" value="删除"></td>
                </tr>
            </table>
        </form>
    </div>
        <%
    } else {
        out.print("<br>对不起，您还没有<a href='loginUser.jsp'>登录</a>！");
    }
%>
</body>
</html>