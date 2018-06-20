<%@page import="Bean.Homework"%>
<%@page import="Dao.HomeworkStudentDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>您正在进行中的作业</title>
</head>

<body>
	<%@include file="nav.jsp"%>
<%
//获取学生最后一次提交作业所得分数
					HomeworkStudentDao hsd=new HomeworkStudentDao();
					int score=-1;
					ArrayList list = (ArrayList)session.getAttribute("homeworks"); 
 %>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<h2>您正在进行中的作业情况</h2><hr/>
			<table class="table table-striped">
				<thead>
				<h4>您一共有<%=list.size() %>份作业</h4><br/>
					<tr>
						<th>作业编号</th>
						<th>标题</th>
						<th>老师</th>
						<th>结束时间</th>
						<!--th>我的成绩</th-->
					</tr>
				</thead>
				<tbody>
					<% 
					
					for (int i = 0; i < list.size(); ++i) {
            		Homework homework = (Homework)list.get(i);
            		score=hsd.getScoreByStudentIdHomeworkId(homework.getId(),(String)session.getAttribute("Id"));
            		%>
					<tr>
						<td><%= homework.getId() %></td>
						<td><a
							href="showhomeworkcontent.jsp?homeworkId=<%= homework.getId()%>&studentId=<%= session.getAttribute("Id")%>"><%= homework.getTitle() %></a>
						</td>
						<td><%= homework.getTeacherName() %></td>
						<td><%= homework.getFinishTime() %></td>
						<!--td><%= score==-1?"未批阅":score %></td-->
					</tr>
					<%} %>

				</tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>






</body>
</html>
