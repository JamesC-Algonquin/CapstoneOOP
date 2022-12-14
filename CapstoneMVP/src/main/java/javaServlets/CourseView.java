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
import javaObjects.Professor;

@WebServlet("/user/CourseView")
public class CourseView extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/CourseView.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseName = req.getParameter("name");
		HttpSession session = req.getSession();
		Professor prof = (Professor) session.getAttribute("user");
		int id = prof.getId();
		ApplicationDAO.insertCourse(courseName, id);
		doGet(req, resp);
		
	}

}
