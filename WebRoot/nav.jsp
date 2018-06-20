<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 <nav class="navbar navbar-inverse" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">高校作业自助提交系统</a>
            </div>
			
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                <li class="active"><a href="servlet/ShowHomework">查看作业</a></li>
                <li><a href="listhomeworkbystudentid.jsp">作业提交情况统计</a></li>
                <li><a href="updateStudentInfo.jsp">修改个人信息</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <% if (session.getAttribute("Id") != null) { %>
                <li><a>欢迎：<%=session.getAttribute("UserName") %></a></li><li><a href="login.jsp">退出</a></li>
                <%  } else { %>
                    <li><a href="login.jsp">未登录</a></li>
                    <% } %>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">查找</button>
                </form>
            </div><!-- /.navbar-collapse -->            
        </nav>
