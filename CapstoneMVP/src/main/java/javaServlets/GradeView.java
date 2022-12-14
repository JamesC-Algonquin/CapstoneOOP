package javaServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/GradeView")
public class GradeView extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("course") != null) {
			RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/StudentGradeView.jsp");
			dispatch.forward(req, resp);
		}
		else {
			RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/StudentCourseView.jsp");
			dispatch.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}

}