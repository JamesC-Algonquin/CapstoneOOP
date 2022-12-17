package javaServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaDAO.ApplicationDAO;
import javaObjects.Student;

@WebServlet("/user/EnrolView")
public class EnrolView extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("course") != null) {
			int courseId = Integer.valueOf(req.getParameter("course"));
			
			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("user");
			int studentId = student.getId();
			
			ApplicationDAO.enrol(studentId, courseId);
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/EnrolView.jsp");
		dispatch.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}