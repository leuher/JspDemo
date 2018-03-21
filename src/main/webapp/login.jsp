<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录界面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

    <script type="text/javascript">
        //刷新验证码
        function changeImg(){
            document.getElementById("validateCodeImg").src = document.getElementById("validateCodeImg").src + "?time" + (new Date());
        }
    </script>
</head>

<body>
<form action="<%=request.getContextPath()%>/Login"
      method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkcode">
                <img src="<%=request.getContextPath()%>/DrawImage" alt="看不清,换一张" id="validateCodeImg" onclick="changeImg()">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
