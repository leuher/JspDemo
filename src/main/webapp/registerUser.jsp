<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/userStyle.css">

    <script type="text/javascript">
        function reg(form){
            if(form.username.value == ""){
                alert("用户名不能为空!");
                return false;
            }
            if(form.password.value == ""){
                alert("密码不能为空!");
                return false;
            }
            if(form.repassword.value == ""){
                alert("确认密码不能为空!");
                return false;
            }
            if(form.password.value != form.repassword.value){
                alert("两次密码输入不一致!");
                return false;
            }
            if(form.tel.value == ""){
                alert("联系电话不能为空!");
                return false;
            }
            if(form.email.value == ""){
                alert("电子邮箱不能为空!");
                return false;
            }
        }

        function change(){
            var photo = document.getElementById("photo");
            var photoImg = document.getElementById("photoImg");
            photoImg.src = photo.value;
        }
    </script>

</head>

<body>
    <div class="head">用户注册</div>
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
        <form action="<%=request.getContextPath()%>/Register" method="post" onsubmit="return reg(this)">
            <table align="center" width="450" border="0">
                <tr>
                    <td align="right">用户名:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td align="right">密码:</td>
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
    </div>
</body>
</html>