package coreservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet {

	private static final long serialVersionUID = -3026082420636603845L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// fetch the session from request, create new session if session
		// is not present in the request
		HttpSession session = request.getSession(false);

		session.invalidate();

		response.sendRedirect("index.jsp");
	}

}
