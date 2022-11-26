package javaServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaDAO.ApplicationDAO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Load Register Page
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/Register.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password") ;
		String type = req.getParameter("type");
		
		ApplicationDAO.createUser(name, email, password, type);
		
		String write = String.format("<HTML> <h3> User Created </h3> </HTML>");
		PrintWriter writer = resp.getWriter();
		writer.write(write);
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/Login.jsp");
		dispatch.include(req, resp);
	}

}
