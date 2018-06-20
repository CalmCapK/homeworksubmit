<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="js/bootstrap.min.js"></script>
<base href="<%=basePath%>">

<title>欢迎注册</title>


</head>

<body>
	<form action="servlet/registe" method="post">
		<input type="text" name="username"><br /> <input type="text"
			name="pwd"><br /> <input type="submit" value="登陆"><br />
	</form>
	
</body>
</html>
