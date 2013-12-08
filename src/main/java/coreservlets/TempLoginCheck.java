package coreservlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TempLoginCheck extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6456056469627150345L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k", "oougodzmcwhapf",
					"srdrgT5PV-VxBxlDGBPtzmFfsg");
			Statement stmt = con.createStatement();
			// This is where the request is actually happening.
			ResultSet rs = stmt.executeQuery(searchQuery);
			boolean isEmpty = rs.next();
			if (!isEmpty) {
				// redirect to error page
				response.sendRedirect("LoginFailure.jsp");
			} else if (isEmpty) {
				// fetch the session from request, create new session if session
				// is not present in the request
				HttpSession session = request.getSession(true);
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("firstname", rs.getString("firstname"));
				session.setAttribute("lastname", rs.getString("lastname"));
				session.setAttribute("about", rs.getString("about"));
				// redirect to success page
				response.sendRedirect("LoginSuccess.jsp");

				/*
				 * // COOKIES SET HERE Cookie emailCookie = new Cookie("abc",
				 * email); Cookie passCookie = new Cookie("def", password); //
				 * setMaxAge is measured in seconds, so: // 60 secs (1 minute)
				 * times 60 (1 hour) times 24 (1 day) // Which equals 86400
				 * seconds in a day. emailCookie.setMaxAge(60 * 60 * 24);
				 * passCookie.setMaxAge(60 * 60 * 24);
				 * 
				 * response.addCookie(emailCookie);
				 * response.addCookie(passCookie);
				 * 
				 * System.out.println("Email address: " + email + "\n" +
				 * "Password: " + password); System.out.println(
				 * "<a href=\"BrowseCookie\">View All Cookies</a>");
				 */
			}
		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
