package javaServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaDAO.ApplicationDAO;

@WebServlet("/user/AssignmentEdit")
public class AssignmentEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/AssignmentEdit.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		double percent =Double.valueOf(req.getParameter("percent"));
		int id = Integer.valueOf(req.getParameter("id"));
		int enrol = Integer.valueOf(req.getParameter("enrol"));
		
		ApplicationDAO.updateGrade(id, name, percent);
		
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/AssignmentView.jsp?enrol=" + enrol);
		dispatch.forward(req, resp);
	}
	

}
