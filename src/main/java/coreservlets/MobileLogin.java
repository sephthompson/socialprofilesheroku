package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

public class MobileLogin extends HttpServlet {

	private static final long serialVersionUID = 1029849297015934427L;
	private static String pattern1 = "[\\s\\,]";
	private static String pattern2 = "[\\s]";

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String searchQuery = "SELECT * FROM accounts, profiles"
				+ " WHERE email = '" + email + "'" + " AND password = '"
				+ password + "'" + " AND accounts.user_id = profiles.user_id;";
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String url = "jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k?user=oougodzmcwhapf&password=srdrgT5PV-VxBxlDGBPtzmFfsg?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			// This is where the request is actually happening.
			ResultSet rs = stmt.executeQuery(searchQuery);
			boolean isEmpty = rs.next();
			if (!isEmpty) {
				// Redirect to error page
				response.sendRedirect("LoginFailure.jsp");
			} else if (isEmpty) {
				/*
				 * Fetch the session from request, create new session if session
				 * is not present in the request.
				 */
				HttpSession session = request.getSession(true);
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("firstname", rs.getString("firstname"));
				session.setAttribute("lastname", rs.getString("lastname"));
				session.setAttribute("about", rs.getString("about"));

				// Redirect to success page
				response.sendRedirect("LoginSuccess.jsp");

			}
		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* response.getOutputStream()
				.println(
						"You are accessing this servlet via the get method.  Congratulations, it works.  Now get out of here."); */
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
