<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>删除图书信息</title>

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
    <form action="<%=request.getContextPath()%>/BookDoDelete" method="post">
        <table align="center">
            <div align="center" style="font-size: 36px;font-weight: bold;">删除列表</div>
            <c:forEach var="bookitem" items="${booklist}">
                <tr>
                    <td>图书编号:</td>
                    <td><input type="text" name="id" value="${bookitem.id}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>图书名称:</td>
                    <td><input type="text" name="name" value="${bookitem.name}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>图书价格:</td>
                    <td><input type="text" name="price" value="${bookitem.price}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>图书数量:</td>
                    <td><input type="text" name="bookCount" value="${bookitem.bookCount}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>图书作者:</td>
                    <td><input type="text" name="author" value="${bookitem.author}" readonly="readonly"></td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="submit" value="删除"></td>
                <td>
                    <button>
                        <a href="<%=request.getContextPath()%>/BookList" style="text-decoration: none">返回</a>
                    </button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>