<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>二级菜单联动</title>

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
        $(function () {
            //给下拉列表添加事件
            $("#city1").change(function () {
                //测试
                // alert($(this).val() + " " + $("city1 option:selected").text());
                //post传输，固定四个参数
                //第一个参数是url：发送请求地址
                //第二个参数data：待发送的值key/value
                //第三个参数callback：发送返回时回调函数
                //第四个参数type：返回内容格式，常用text，json
                $.post("SecondMenu", {city1: $(this).val()},
                    function (result) {
                        //获取第二级城市的id
                        var city2 = $("#city2");
                        //清空第二级里面的城市
                        city2.empty();
                        for (var i = 0; i < result.length; i++) {
                            city2.append("<option value=" + result[i].name + ">" + result[i].name + "</option>");
                        }
                    }, "json");
            });
         });
    </script>
</head>

<body>
<h2>城市</h2>
<select id="city1">
    <option value="0">请选择</option>
    <option value="gd">广东</option>
    <option value="hn">湖南</option>
</select>

<select id="city2">
    <option value="0000">请选择</option>
</select>
</body>
</html>