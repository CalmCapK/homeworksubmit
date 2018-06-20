package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Student;
import Bean.Teacher;
import Dao.StudentDao;
import Dao.TeacherDao;

public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
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
		System.out.println("in doGet");
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

		request.setCharacterEncoding("utf8");
		String type=(String)request.getParameter("registeType");
		if(type.endsWith("student"))
		{
			Student student = new Student();
			student.setName((String)request.getParameter("name"));
			student.setPwd((String)request.getParameter("pwd"));
			student.setClassId((Integer.parseInt(request.getParameter("classId"))));
			student.setCollege(Integer.parseInt(request.getParameter("collegeId")));
			student.setSex(Integer.parseInt(request.getParameter("sex")));
			student.setStudentId(Integer.parseInt((String)request.getParameter("studentId")));
			System.out.println((String)request.getParameter("username"));
			StudentDao studentDao = new StudentDao();
			studentDao.insert(student);
			HttpSession session = request.getSession();
			session.setAttribute("Id", (String)request.getParameter("studentId"));
			session.setAttribute("UserName", student.getName());
			session.setAttribute("loginType", "student");
			response.sendRedirect("ShowHomework");
		}
		else if(type.endsWith("teacher"))
		{
			Teacher teacher = new Teacher();
			teacher.setName((String)request.getParameter("name"));
			teacher.setTeacherId(Integer.parseInt((String)request.getParameter("teacherId")));
			teacher.setPwd((String)request.getParameter("pwd"));
			teacher.setCollegeId(Integer.parseInt((String)request.getParameter("collegeId")));
			teacher.setSex(Integer.parseInt((String)request.getParameter("sex")));
			TeacherDao teacherDao = new TeacherDao();
			teacherDao.insert(teacher);
			
			HttpSession session = request.getSession();
			session.setAttribute("Id", (String)request.getParameter("teacherId"));
			session.setAttribute("UserName", teacher.getName());
			session.setAttribute("loginType", "teacher");
			response.sendRedirect("../indexteacher.jsp");
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
