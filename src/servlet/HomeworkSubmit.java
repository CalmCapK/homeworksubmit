package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Homework;
import Bean.HomeworkStudent;
import Dao.HomeworkDao;
import Dao.HomeworkStudentDao;

public class HomeworkSubmit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HomeworkSubmit() {
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
		HomeworkStudent hs = new HomeworkStudent();
		hs.setFile((String)request.getParameter("file"));
		hs.setHomeworkId(Integer.parseInt(request.getParameter("homeworkId")));
		hs.setStudentId(Integer.parseInt((String)request.getParameter("studentId")));

		HomeworkDao homeworkDao = new HomeworkDao();
		Homework hm = homeworkDao.getByHomeworkId(hs.getHomeworkId());
		if(hm.getType() == 1 || hm.getType() == 2){
			if(hs.getFile().equals(hm.getAnswer())){
				hs.setScore(100);
			}
			else {
				hs.setScore(0);
			}
		}
		HomeworkStudentDao homeworkStudentDao = new HomeworkStudentDao();
		homeworkStudentDao.insert(hs);
		//System.out.println((String)request.getParameter("file"));
		response.sendRedirect("../studenthomework.jsp");
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
