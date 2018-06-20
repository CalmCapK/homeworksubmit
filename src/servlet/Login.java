package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Student;
import Bean.Teacher;
import Dao.StudentDao;
import Dao.TeacherDao;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String loginTypeString = (String)request.getParameter("logintype");
		
		if (loginTypeString.equals("student")) {

			String studentId = (String) request.getParameter("name");
			String pwd = (String) request.getParameter("pwd");
			StudentDao studentDao = new StudentDao();
			Student student=studentDao.findStudent(studentId);
			if ( !pwd.isEmpty() && pwd.equals(student.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("Id", studentId);
				session.setAttribute("UserName", student.getName());
				session.setAttribute("loginType", "student");
				response.sendRedirect("ShowHomework");
			} else {
				out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"> <html lang=\"zh-CN\" charset = \"utf-8\"> <head> <title>登录失败%>_<%</title> </head> <body>登录失败，请<a href = \"../login.jsp\">点击此处</a>重新登录！</body></html>");
				//response.sendRedirect("../login.jsp");
			}
		}
		else if(loginTypeString.equals("teacher")) {
			String teacherId = (String)request.getParameter("name");
			String pwd = (String)request.getParameter("pwd");
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacher=teacherDao.findById(teacherId);
			if (pwd != null && pwd.equals(teacher.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("Id", teacherId);
				session.setAttribute("UserName", teacher.getName());
				session.setAttribute("loginType", "teacher");
				response.sendRedirect("../indexteacher.jsp");
			} else {
				out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"> <html lang=\"zh-CN\" charset = \"utf-8\"> <head> <title>登录失败%>_<%</title> </head> <body> 登录失败，请<a href = \"../login.jsp\">点击此处</a>重新登录！</body></html>");
			}
			
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
