<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>注册页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //用户名文本框绑定失去焦点事件
            $("#username").blur(function () {
                // alert("blur: " + $(this).val());
                $.ajax({
                    url:"UserCheckAjax2",//设置服务器地址，即为servlet配置的url-pattern,注意不用"/"符号
                    type:"post",//提交方式
                    data:{username:$(this).val()},//提交到服务器的数据，多个值以逗号分割
                    success:function (data) { //回调函数，data是返回的数据
                        // alert("data: " + data);
                        $("#errorUsername").html(data);
                    }
                });
            });
        });
    </script>
</head>

<body>
    <form action="" method="post">
        <table>
            <caption>注册页面</caption>
            <tr>
                <td align="right">账号：</td>
                <td>
                    <input type="text" name="username" id="username">
                    <div id="errorUsername" name="errorUsername" style="color: red;display: inline"></div>
                </td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td align="right">确定密码:</td>
                <td><input type="text" name="repassword"></td>
            </tr>
            <tr>
                <td align="right">性别:</td>
                <td>
                    <input type="radio" name="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td align="right">头像:</td>
                <td>
                    <select name="photo" id="photo" onchange="change();">
                        <option value="images/boy.png" selected="selected">boy</option>
                        <option value="images/girl.png">girl</option>
                    </select>
                    <img id="photoImg" src="images/boy.png">
                </td>
            </tr>
            <tr>
                <td align="right">联系电话:</td>
                <td><input type="text" name="tel"></td>
            </tr>
            <tr>
                <td align="right">电子邮箱:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>