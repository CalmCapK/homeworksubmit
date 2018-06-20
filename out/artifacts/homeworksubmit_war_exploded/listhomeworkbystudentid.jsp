<%@page import="Bean.Homework"%>
<%@page import="Bean.HomeworkStudent"%>
<%@page import="Dao.HomeworkStudentDao" %>
<%@page import="Dao.HomeworkDao" %>
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

<title>查看统计信息</title>
</head>

<body>

<%
ArrayList<HomeworkStudent> hs=new ArrayList<HomeworkStudent>();
HomeworkStudentDao hsd=new HomeworkStudentDao();
hs=hsd.findByStudentId((String)session.getAttribute("Id"));
HomeworkDao homeworkDao=new HomeworkDao();
%>

	<%@include file="nav.jsp"%>
	
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<h1>以下是您所有的作业提交情况</h1><hr/>
		<h4>您一共提交了<%=hs.size() %>次作业</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>编号</th>
						<th>作业题目</th>
						<th>结束时间</th>
						<th>得分情况</th>
						<th>选择操作</th>
					</tr>
				</thead>
				<tbody>
					<%for (int i = 0; i < hs.size(); ++i) {
					HomeworkStudent hm = hs.get(i);
					Homework homework=homeworkDao.getByHomeworkId(hm.getHomeworkId());          		
            		%>
					<tr>
						<td><%=hm.getId() %></td>
						<td><a href = "showhomeworkcontent.jsp?homeworkId=<%=hm.getHomeworkId() %>"><%= homework.getTitle() %></a></td>
						<td><%= homework.getFinishTime() %></td>
						<td><%= hm.getScore()==-1?"未批阅":hm.getScore() %></td>
						<td>
								<form action="servlet/DeleteHomeworkStudent" method="post">
									<!-- Button trigger modal -->
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#homeworkstudentId<%=hm.getId()%>">
										修改答案
									</button>
									<!-- Modal -->
									<!-- DeleteButton-->
									<input type="hidden" name="hsId"
										value="<%=hm.getId()%>" />
									<input type="hidden" name="type" value="student" />
									<input type="hidden" name="homeworkId"
										value="<%=hm.getHomeworkId()%>" />
									<button type="submit" class="btn btn-primary">
										删除本条
									</button>
								</form>
								<!-- Button -->
							</td>
					</tr>
					
					<form action="servlet/UpdateHomeworkStudent" method="post">
							<div class="modal fade"
								id="homeworkstudentId<%=hm.getId()%>"
								tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												您最近一次提交的作业详情
											</h4>
										</div>
										<div class="modal-body">
											<textarea class="form-control" rows="15" name="file"><%=hm.getFile()%></textarea>
											<input type="hidden" name="id"
												value="<%=hm.getId()%>" />
											<input type="hidden" name="homeworkId"
												value="<%=hm.getHomeworkId()%>" />
										</div>
										<div class="modal-footer">
											您本次提交最近一次的得分为：<%=(hm.getScore() == -1 ? "未批阅"
						: hm.getScore())%>
											<button type="submit" class="btn btn-primary">
												确认提交
											</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">
												Close
											</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</form>
					<%} %>

				</tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>

</body>
</html>
