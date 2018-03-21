<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>操作结果</title>

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
<%
    String catalog = request.getParameter("catalog");
    if (catalog == null || "".equals(catalog)) {
        System.out.println(catalog);
        catalog = "d:/";
    }
    File dir1 = new File(catalog);
    File file[] = dir1.listFiles();
%>
<p>
    <font color="#FF0000">当前路径下的目录有:</font>
    <%
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {
                out.print("<br>" + file[i].toString());
            }
        }
    %>
</p>

<font color="#FF0000">当前路径下的所有文件有:</font>
<p>
    <%
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                out.print("<br>" + file[i].toString());
            }
        }
    %>
</p>

<p>----------------------------------------------------</p>

<%
    //定义数组,存储获取的值
    String[] s = new String[8];
    //获取对应的文本框文件或目录路径
    s[0] = request.getParameter("path1");
    s[1] = request.getParameter("name1");
    s[2] = request.getParameter("path2");
    s[3] = request.getParameter("name2");
    s[4] = request.getParameter("path3");
    s[5] = request.getParameter("name3");
    s[6] = request.getParameter("path4");
    s[7] = request.getParameter("name4");

    for (int i = 0; i < s.length; i++) {
        if (i % 2 == 0) {
            if(s[i] == null || "".equals(s[i])){
                s[i] = "d:/";
                System.out.println("路径:" + s[i]);
            }else{
                System.out.println("路径:" + s[i]);
            }
        }
    }
    File dir2 = new File(s[0], s[1]);
    File dir3 = new File(s[2], s[3]);
    File dir4 = new File(s[4], s[5]);
    File dir5 = new File(s[6], s[7]);
%>

<p>
    <%=s[1]%><font color="#FF0000">目录是否创建成功?</font><%=dir2.mkdir()%>
</p>

<p>
    <%=s[3]%><font color="#FF0000">文件是否创建成功</font><%=dir3.createNewFile()%>
</p>

<p>
    <%=s[5]%><font color="#FF0000">目录是否删除成功?</font><%=dir4.delete()%>
</p>

<p>
    <%=s[7]%><font color="#FF0000">文件是否删除成功?</font><%=dir5.delete()%>
</p>
</body>
</html>