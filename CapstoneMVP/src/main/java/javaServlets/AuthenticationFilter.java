package javaServlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/user/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		
		//testing
		System.out.println("filtered");
		
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			//Load Login Page
			RequestDispatcher dispatch = req.getRequestDispatcher("/LoginServlet");
			dispatch.forward(req, arg1);
		}
		arg2.doFilter(req, arg1);
	}
}
