<%@page import="Bean.Homework"%>
<%@page import="Bean.HomeworkStudent"%>
<%@page import="Dao.HomeworkStudentDao"%>
<%@page import="Dao.HomeworkDao"%>

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

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<%
					HomeworkStudentDao hmd = new HomeworkStudentDao();
					System.out.println(request.getParameter("homeworkId")+" "+session.getAttribute("Id"));

					ArrayList<HomeworkStudent> list = hmd
							.getHomeworkStudentByStudentIdHomeworkId(Integer.parseInt(request
									.getParameter("homeworkId")), (String) session
									.getAttribute("Id"));
					HomeworkDao homeworkDao = new HomeworkDao();
					Homework homework = new Homework();
					homework = homeworkDao.getByHomeworkId((String) request
							.getParameter("homeworkId"));
				%>


				<div class="page-header">
					<h2><%=homework.getTitle()%></h2>
					<h5>
						结束时间：<%=homework.getFinishTime()%></h5>
				</div>

				<div class="jumbotron">
					<p><%=(homework.getContent())%></p>
				</div>
				<!-- Button trigger modal -->
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal">
					提交作业
				</button><br/><br/>

				<!-- /.modal-dialog -->
				<h4>
					本作业您一共提交了<%=list.size()%>次：
				</h4>
				<hr />
				<table class="table table-striped">
					<thead>
						<tr>
							<th>
								提交编号
							</th>
							<th>
								内容预览
							</th>
							<th>
								选择操作
							</th>
							<th>
								最近得分
							</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < list.size(); ++i) {
								HomeworkStudent homeworkstudent = (HomeworkStudent) list.get(i);
						%>
						<tr>
							<td><%=homeworkstudent.getId()%></td>
							<td>
								<span class=cc><nobr><%=homeworkstudent.getFile()%></nobr>
								</span>
							</td>
							<td>
								<form action="servlet/DeleteHomeworkStudent" method="post">
									<!-- Button trigger modal -->
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#homeworkstudentId<%=homeworkstudent.getId()%>">
										修改答案
									</button>
									<!-- Modal -->
									<!-- DeleteButton-->
									<input type="hidden" name="hsId"
										value="<%=homeworkstudent.getId()%>" />
									<input type="hidden" name="type" value="student" />
									<input type="hidden" name="homeworkId"
										value="<%=homeworkstudent.getHomeworkId()%>" />
									<button type="submit" class="btn btn-primary">
										删除本条
									</button>
								</form>
								<!-- Button -->
							</td>
							<td><%=(homeworkstudent.getScore() == -1 ? "未批阅"
						: homeworkstudent.getScore())%></td>

						</tr>

						<form action="servlet/UpdateHomeworkStudent" method="post">
							<div class="modal fade"
								id="homeworkstudentId<%=homeworkstudent.getId()%>"
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
											<textarea class="form-control" rows="15" name="file"><%=homeworkstudent.getFile()%></textarea>
											<input type="hidden" name="id"
												value="<%=homeworkstudent.getId()%>" />
											<input type="hidden" name="homeworkId"
												value="<%=homeworkstudent.getHomeworkId()%>" />
										</div>
										<div class="modal-footer">
											您本次提交最近一次的得分为：<%=(homeworkstudent.getScore() == -1 ? "未批阅"
						: homeworkstudent.getScore())%>
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
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Modal -->
		<form action="servlet/HomeworkSubmit" method="post">
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请输入作业内容
							</h4>
						</div>
						<div class="modal-body">
							<textarea class="form-control" rows="20" name="file"></textarea>
							<input type="hidden" name="studentId"
								value="<%=(String) session.getAttribute("Id")%>" />
							<input type="hidden" name="homeworkId"
								value="<%=(String) request.getParameter("homeworkId")%>" />
						</div>
						<div class="modal-footer">
							请您检查无误后提交。
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								Close
							</button>
							<button type="submit" class="btn btn-primary">
								确认提交
							</button>


						</div>
					</div>
					<!-- /.modal-content -->
				</div>
		</form>
	</body>
</html>
