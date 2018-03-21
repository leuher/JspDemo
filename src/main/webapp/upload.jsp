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

    <title>文件上传</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
    <h1>文件上传</h1>
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
<form method="post" action="<%=request.getContextPath()%>/Upload" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile"/>
    <br><br>
    <input type="submit" value="上传">
</form>
    <%
        } else {
            out.print("<br>对不起，您还没有<a href='loginUser.jsp'>登录</a>！");
        }
    %>
</body>
</html>