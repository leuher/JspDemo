<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.entity.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>图书列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/bookList.css">


</head>

<body>
    <form action="" method="post">
        <table width="80%" align="center">
            <div class="list">图书列表</div>
            <ul>
                <li><a href="bookAdd.jsp">新增图书</a> </li>
                <li><a href="<%=request.getContextPath()%>/BookBatchAdd">批量新增图书</a></li>
                <li><a href="<%=request.getContextPath()%>/BookBatchDelete">批量删除图书</a></li>
                <li><a href="<%=request.getContextPath()%>/BookFind">分页显示图书</a></li>
                <li><a href="<%=request.getContextPath()%>/OutputExcel">导出Excel</a></li>
            </ul>
            <tr>
                <td>图书编号</td>
                <td>图书名称</td>
                <td>图书价格</td>
                <td>图书数量</td>
                <td>图书作者</td>
                <td>图书修改</td>
                <td>图书删除</td>
            </tr>
            <c:forEach var="bookitem" items="${booklist}">
                <tr>
                    <td>${bookitem.id}</td>
                    <td>${bookitem.name}</td>
                    <td>${bookitem.price}</td>
                    <td>${bookitem.bookCount}</td>
                    <td>${bookitem.author}</td>
                    <td><a href="<%=request.getContextPath()%>/BookUpdate?id=${bookitem.id}">修改</a></td>
                    <td><a href="<%=request.getContextPath()%>/BookDelete?id=${bookitem.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>