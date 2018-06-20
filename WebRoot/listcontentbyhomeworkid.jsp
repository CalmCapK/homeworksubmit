<%@page import="Bean.HomeworkStudent"%>
<%@page import="Bean.Homework"%>
<%@page import="Dao.HomeworkDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!--<link rel="stylesheet" type="text/css" href="css/styles.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>查看作业</title>
</head>

<body>
	<%@include file="navteacher.jsp"%>
	<%
		ArrayList list = (ArrayList) session.getAttribute("homeworks");
		Homework hm=new Homework();
		HomeworkDao hmd=new HomeworkDao();
		hm=hmd.getByHomeworkId((String)session.getAttribute("homeworkId"));
		
	%>
	<div class="row">
	<div class="col-md-2"></div>	
		<div class="col-md-8">
			  <div class="page-header">
				<h2><%=hm.getTitle() %></h2><br/>
				<h6>结束时间：<%=hm.getFinishTime() %></h6>
			</div>
			<div class="jumbotron">
						<p><%=hm.getContent()%></p>
			</div>
			<hr/>
			<h4>一共提交了<%=  list.size()%>份作业</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>学生学号</th>
						<th>作业内容</th>
						<th>选择操作</th>
						<th>上次得分</th>
					</tr>
				</thead>
				<tbody>
				

					<%
						for (int i = 0; i < list.size(); ++i) {
							HomeworkStudent homework = (HomeworkStudent) list.get(i);
							System.out.println("id= "+homework.getId()+" homeworkId ="+homework.getHomeworkId()+" score = "+homework.getScore());
					%>
					<tr>
						<td><%=homework.getStudentId()%></td>
						<td><span class=cc><nobr><%=homework.getFile()%></nobr></span></td>
						<td><form action="servlet/DeleteHomeworkStudent" method="post">
						<!-- Button trigger modal -->
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#homeworkstudentId<%=homework.getId() %>">查看详情</button>
						<!-- Modal -->
						<!-- DeleteButton-->						
						<input type="hidden" name="hsId" value="<%=homework.getId() %>"/>
						<input type="hidden" name="homeworkId" value="<%=homework.getHomeworkId() %>"/>
						<input type="hidden" name="type" value="student"/>
						<button type="submit" class="btn btn-primary">删除本条</button>
						</form>
						<!-- Button -->
						</td>
						<td><%= (homework.getScore()==-1?"未批阅":homework.getScore()) %></td>
						
					</tr>
					
					<form action="servlet/UpdateHomeworkScore" method="post">
						<div class="modal fade" id="homeworkstudentId<%=homework.getId() %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">作业详情</h4>
									</div>
									<div class="modal-body">
										<textarea class="form-control" rows="15"  name="file" readonly="readonly"><%= homework.getFile() %></textarea>
										<input type="hidden" name="id" value="<%= homework.getId()%>"/>
										<input type="hidden" name="homeworkId" value="<%= homework.getHomeworkId()%>"/>
									</div>
									<div class="modal-footer">																	
										您的打分为：<input type='text' name='score' placeholder = "<%= (homework.getScore()==-1?"未批阅":homework.getScore()) %>" />	
										<button type="submit" class="btn btn-primary">确认提交</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									</div>
								</div><!-- /.modal-content -->							
							</div><!-- /.modal-dialog -->
						</div><!-- /.modal -->	
					</form>			
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
