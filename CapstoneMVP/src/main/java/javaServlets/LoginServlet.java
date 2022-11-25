package javaServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javaDAO.ApplicationDAO;
import javaObjects.User;
import javaObjects.UserFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Load Login Page
		RequestDispatcher dispatch = req.getRequestDispatcher("/HTML/Login.jsp");
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = null;
		
		//Get login creds from POST
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//Check DB for any returns
		int loginStatus = 0;
		try {
			loginStatus = ApplicationDAO.authenticateLogin(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//If none, print error and return to Login
		if (loginStatus == 0) {
			System.out.println("Login Failed");
			String write = String.format("<HTML> <h3> Incorrect Email or Password </h3> </HTML>");
			PrintWriter writer = resp.getWriter();
			writer.write(write);
			dispatch = req.getRequestDispatcher("/HTML/Login.jsp");
			dispatch.include(req, resp);
		}
		//If success, pass email and type to user factory
		else {
			User user = (new UserFactory().getUser(loginStatus, email));
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("type", loginStatus);
			
			//If prof, forward to prof home page
			if (loginStatus == 1) {
				System.out.println("Login Success!");
				dispatch = req.getRequestDispatcher("/user/ProfessorServlet");
				dispatch.forward(req, resp);
			}
			
			//if student, forward to student home page
			else if (loginStatus == 2) {
				System.out.println("Login Success!");
				dispatch = req.getRequestDispatcher("/user/StudentServlet");
				dispatch.forward(req, resp);
			
			}
		}
	}
}
