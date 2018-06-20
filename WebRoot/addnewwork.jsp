<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Dao.ClassDao" %>
<%@ page import="Bean.Class" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<!-- 最新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="js/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="js/bootstrap.min.js"></script>
		<script src="js/bootstrap-datetimepicker.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>又布置新作业了！</title>
		<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
	</head>

	<body>

		<%@include file="navteacher.jsp"%>
		<div class="row">
			<div class="col-md-2">
			
			
			</div>
			<div class="col-md-8">


				<form role="form" action="servlet/AddNewWork" method="post">
					<div class="form-group">
						<h3>
							标题
						</h3>
						<input type="text" class="form-control" name="title">
					</div>
					<div class="form-group">
					<h4>班级</h4>
						<select name='classId' class="input-append date">
			<% 
			ArrayList<Class> classes=new ArrayList<Class>();
			ClassDao classdao=new ClassDao();
			classes=classdao.listAllClasses();
			for(int i=0;i<classes.size();++i)
			{
				Class cls=(Class)classes.get(i);
				System.out.println(i+":"+cls.getClassId()+":"+cls.getClassName());
			%>	
			<option value = '<%=cls.getClassId()%>' ><%=cls.getClassName() %></option>
			
			<%} %>
			 </select>
						<div class="form-group">
							<h4>
								题目类型
								1选择题
								2简单数值题
								3问答题
							</h4>
							<input type="text"  name="hwType">
						</div>

						<h4>
							结束时间
						</h4>
						<div id="datetimepicker" class="input-append date">
							<input type="text" name="finishTime" />
							<span class="add-on"> <i data-time-icon="icon-time"
								data-date-icon="icon-calendar">选择时间</i> </span>
						</div>
						<script type="text/javascript"
							src="js/bootstrap-datetimepicker.min.js">
	
</script>
						<script type="text/javascript">
	$('#datetimepicker').datetimepicker( {
		format : 'yyyy-MM-dd hh:mm:ss',
		language : 'en',
		pickDate : true,
		pickTime : true,
		hourStep : 1,
		minuteStep : 15,
		secondStep : 30,
		inputMask : true
	});
</script>




					</div>
					<div class="form-group">
					<h4>作业内容</h4>
						<textarea class="form-control" rows="14" name="content"></textarea>
					</div>
					<div class="form-group">
						<h4>答案</h4>
						<textarea class="form-control" rows="2" name="answer"></textarea>
					</div>
					<input type="hidden" name="teacherId"
						value="<%=session.getAttribute("Id")%>" />

					<button type="submit" class="btn btn-default">
						提交
					</button>
				</form>

			</div>
			<div class="col-md-2"></div>
		</div>




	</body>
</html>
