package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Homework;
import Bean.Student;
import Bean.Teacher;
import Dao.HomeworkClass;
import Dao.HomeworkDao;
import Dao.StudentDao;
import Dao.TeacherDao;

public class UpdateUserInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateUserInfo() {
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

		doPost(request,response);
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
		
		String loginType=(String)request.getParameter("loginType");
		String Id=(String)request.getParameter("Id");
		
		if(loginType.equals("teacher"))
		{
			TeacherDao teacherDao=new TeacherDao();
			Teacher teacher=teacherDao.findById(Id);
			teacher.setCollegeId(Integer.parseInt(request.getParameter("collegeId")));
			teacher.setName(request.getParameter("name"));
			teacher.setPwd(request.getParameter("pwd"));
			teacher.setSex(Integer.parseInt(request.getParameter("sex")));
			teacherDao.updateByteacherId(teacher, Id);
			HttpSession session = request.getSession();
			session.setAttribute("UserName", teacher.getName());
			response.sendRedirect("../indexteacher.jsp");
		}
		else if(loginType.equals("student"))
		{
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.findStudent(Id);
			student.setName((String)request.getParameter("name"));
			student.setPwd((String)request.getParameter("pwd"));
			student.setClassId((Integer.parseInt(request.getParameter("classId"))));
			student.setCollege(Integer.parseInt(request.getParameter("collegeId")));
			student.setSex(Integer.parseInt(request.getParameter("sex")));
			
			studentDao.updateBystudentId(student, Id);
			HttpSession session = request.getSession();
			System.out.println("update: "+student.getName());
			session.setAttribute("UserName", student.getName());
			response.sendRedirect("ShowHomework");
		}
		else
			response.sendRedirect("../login.jsp");

		
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
