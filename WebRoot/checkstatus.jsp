<%@page import="Bean.Homework"%>
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

		<title>您已经布置的作业</title>
	</head>

	<body>
		<%@include file="navteacher.jsp"%>
		<%
			ArrayList list = (ArrayList) session.getAttribute("homeworks");
		%>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h3>
					您已经布置的作业
				</h3>
				<hr />
				<table class="table table-striped">
					<thead>
						<h4>
							您一共布置了<%=list.size()%>次作业
						</h4>
						<br />
						<tr>
							<th>
								作业编号
							</th>
							<th>
								作业题目
							</th>
							<th>
								结束时间
							</th>
							<th>
								选择操作
							</th>
						</tr>
					</thead>
					<tbody>

						<%
							for (int i = 0; i < list.size(); ++i) {
								Homework homework = (Homework) list.get(i);
						%>
						<tr>
							<!-- 注意getId. -->
							<td><%=homework.getId()%></td>
							<td>
								<a
									href="servlet/ListContentByHomeworkId?homeworkId=<%=homework.getId()%>"><%=homework.getTitle()%></a>
							</td>
							<td><%=homework.getFinishTime()%></td>
							<td>
								<form action="updatehomework.jsp" method="post">
									<input type="hidden" name="homeworkId"
										value="<%=homework.getId()%>" />
									<button type="submit" class="btn btn-primary">
										修改详情
									</button>
									<!--</form>
						<form action="servlet/DeleteHomework" method="post">
						-->
									<!-- DeleteButton-->
									<input type="hidden" name="teacherId"
										value="<%=homework.getTeacherId()%>" />
									<input type="hidden" name="homeworkId"
										value="<%=homework.getId()%>" />
									<button type="submit" class="btn btn-primary"
										formaction="servlet/DeleteHomework">
										删除本条
									</button>
								</form>
								<!-- Button -->
							</td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>






	</body>
</html>
