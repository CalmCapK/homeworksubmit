<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
        <!-- 最新 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet"
        href="css/bootstrap.min.css">
        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="js/jquery.min.js"></script>

        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script
            src="js/bootstrap.min.js"></script>
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <title>欢迎</title>
        <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    </head>

    <body>
    	<%@include file="navteacher.jsp"%>


       

    </body>
</html>
