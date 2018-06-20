<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Dao.ClassDao" %>
<%@ page import="Bean.Class" %>
<%@ page import="Dao.CollegeDao" %>
<%@ page import="Bean.College" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<!-- 最新 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet"
        href="css/bootstrap2.min.css">
        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        <script src="js/jquery.min.js"></script>

        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script
            src="js/bootstrap.min.js"></script>
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
    
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="css/styles.css">


	</head>
	<body>
			<div class="container">
				<section class="loginBox row-fluid">
				<section class="span7 left">
				<h2>
					用户登录
				</h2>
				<form action="servlet/login" method="post">
					<p>
						<input type="text" name="name" placeholder="UserID" />
					</p>
					<p>
						<input type="password" name="pwd" placeholder="PassWord" />
					</p>
					<section class="row-fluid"/>
					<section class="span8 lh30">
					<input type="radio" name="logintype" value="student"
						checked="checked">
					学生
					<input type="radio" name="logintype" value="teacher">
					老师
					</section>
					<section class="span1">
					<input type="submit" value=" 登录 " class="btn btn-primary">
					</section>


				</form>
				</section>
				</section>
				<section class="span5 right">
				<h2>
					没有帐户？
				</h2>
				<section>
				<p>
					请戳下方注册
				</p>
				<p>
					<!-- Button trigger modal -->
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#studentReg">
						学生注册
					</button>
					<br>
					<br />
					<br>

					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#teacherReg">
						教师注册
					</button>

					<!--Student Registe Modal -->
					<div class="modal fade" id="studentReg" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										&times;
									</button>
									<h4 class="modal-title" id="myModalLabel">
										学生注册
									</h4>
								</div>
								<div class="modal-body">


									<form class="form-horizontal" role="form"
										action="servlet/registe" method="post">
										<input type="hidden" name="registeType" value="student" />
										<div class="form-group" align="left">
											<label for="inputEmail3" class="col-sm-2 control-label">
												姓名：
											</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="name"
													placeholder="Name">*必填
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">
												密码：
											</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" name="pwd"
													placeholder="Password">*必填
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">
												学号：
											</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="studentId"
													placeholder="学号">*必填
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">
											学院：
											</label>
											<div class="col-sm-10">
												<select name='collegeId'>
													<% 
													ArrayList<College> Colleges=new ArrayList<College>();
													CollegeDao Collegedao=new CollegeDao();
													Colleges=Collegedao.listAllColleges();
													for(int i=0;i<Colleges.size();++i)
													{
														College cls=(College)Colleges.get(i);
													%>	
													<option value = '<%=cls.getCollegeId()%>'
													
													<%if(i==0){%>
													selected = 'true'<%} %>
													><%=cls.getCollegeName() %></option>
													
													<%} %>
			 									</select>*必填
			 								</div>
			 							</div>
										
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">
											班级：
											</label>
											<div class="col-sm-10">
												<select name='classId'>
													<% 
													ArrayList<Class> classes=new ArrayList<Class>();
													ClassDao classdao=new ClassDao();
													classes=classdao.listAllClasses();
													for(int i=0;i<classes.size();++i)
													{
														Class cls=(Class)classes.get(i);
													%>	
													<option value = '<%=cls.getClassId()%>' <%if(i==0){%>
													selected = 'true'<%} %> ><%=cls.getClassName() %></option>
													
													<%} %>
			 									</select>*必填
			 								</div>
			 							</div>
										
										
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">
												性别：
											</label>
											<div class="col-sm-10">
												<select name="sex">
													<option value = '1' selected = 'true'> 男 </option>
													<option value = '2'> 女</option>
												</select>
													
											</div>
										</div>
										
										<br />
										<br />
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">
												Close
											</button>
											<button type="submit" class="btn btn-primary">
												提交
											</button>
										</div>
									</form>
								</div>
								<!-- .modal-body -->
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->

					<!-- Teacher Registe Modal -->
					<div class="modal fade" id="teacherReg" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										&times;
									</button>
									<h4 class="modal-title" id="myModalLabel">
										教师注册
									</h4>
								</div>
								<br />
								<br />
								<div class="modal-body">
									<form class="form-horizontal" role="form"
										action="servlet/registe" method="post">
										<input type="hidden" name="registeType" value="teacher" />
										<div class="form-group" align="left">
											<label for="inputEmail3" class="col-sm-2 control-label">
												教师号：
											</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="teacherId"
													placeholder="TeacherId">*必填
											</div>
										</div>
										<div class="form-group" align="left">
											<label for="inputEmail3" class="col-sm-2 control-label">
												密码：
											</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" name="pwd"
													placeholder="Password">*必填
											</div>
										</div>
										<div class="form-group" align="left">
											<label for="inputEmail3" class="col-sm-2 control-label">
												姓名：
											</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="name"
													placeholder="Name">*必填
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">
											学院：
											</label>
											<div class="col-sm-10">
												<select name='collegeId'>
													<% 
													for(int i=0;i<Colleges.size();++i)
													{
														College cls=(College)Colleges.get(i);
													%>	
													<option value = '<%=cls.getCollegeId()%>' <%if(i==0){%>
													selected = 'true'<%} %> ><%=cls.getCollegeName() %></option>
													
													<%} %>
			 									</select>*必填
			 								</div>
			 							</div>
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">
												性别：
											</label>
											<div class="col-sm-10">
												<select name="sex">
													<option value = '1' selected = 'true'> 男 </option>
													<option value = '2'> 女</option>
												</select>
													
											</div>
										</div>
										<br />
										<br />
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">
												Close
											</button>
											<button type="submit" class="btn btn-primary">
												提交
											</button>
										</div>
									</form>
								</div>
								<!-- .modal-body -->
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</p>
				</section>
				</section>
				</section>
				<!-- /loginBox -->
			</div>
			<!-- /container -->
		</body>
</html>
