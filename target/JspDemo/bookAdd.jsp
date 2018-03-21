<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>新增图书</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
        function check(form) {
            with(form){
                //with(form)相当于if(form.id.value == "")
                if(id.value == ""){
                    alert("图书编号不能为空");
                    return false;
                }
                if(name.value == ""){
                    alert("图书名称不能为空");
                    return false;
                }
                if(price.value == ""){
                    alert("图书价格不能为空");
                    return false;
                }
                if(bookCount.value == ""){
                    alert("图书数量不能为空");
                    return false;
                }
                if(author.value == ""){
                    alert("图书作者不能为空");
                    return false;
                }
                return true;
            }
        }
    </script>

</head>

<body>
    <form action="<%=request.getContextPath()%>/BookAdd" method="post" onsubmit="return check(this)">
        <div>
            <h1>新增图书信息</h1>
            <table>
                <tr>
                    <td>图书编号:</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>图书名称:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>图书价格:</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>图书数量:</td>
                    <td><input type="text" name="bookCount"></td>
                </tr>
                <tr>
                    <td>图书作者:</td>
                    <td><input type="text" name="author"></td>
                </tr>
                <tr>
                    <td colspan="1"><input type="submit" value="新增"></td>
                    <td colspan="1"><input type="reset" value="重置"></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>