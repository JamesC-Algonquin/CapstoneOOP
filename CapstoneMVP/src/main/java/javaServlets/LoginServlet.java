package javaServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaDAO.ApplicationDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/Login.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = null;
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		
		int loginStatus = 0;
		try {
			loginStatus = ApplicationDAO.authenticateLogin(email, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (loginStatus == 1) {
			System.out.println("Login Success!");
		}
		else if (loginStatus == 2) {
			System.out.println("Login Success!");
		}
		else {
			System.out.println("Login Failed");
			String write = String.format("<HTML> <h3> Incorrect Email or Password </h3> </HTML>");
			PrintWriter writer = resp.getWriter();
			writer.write(write);
			dispatch = req.getRequestDispatcher("/HTML/Login.jsp");
			dispatch.include(req, resp);
		}
	}

}
