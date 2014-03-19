package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MobileLogin extends HttpServlet {

	private static final long serialVersionUID = 1029849297015934427L;
	// private static String pattern1 = "[\\s\\,]";
	// private static String pattern2 = "[\\s]";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String searchQuery = "SELECT * FROM accounts, profiles"
				+ " WHERE email = '" + email + "'" + " AND password = '"
				+ password + "'" + " AND accounts.user_id = profiles.user_id;";
		
		Connection con = null;
		Statement stmt = null;
		// PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String url = "jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k?user=oougodzmcwhapf&password=srdrgT5PV-VxBxlDGBPtzmFfsg";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean isEmpty = rs.next();
			
			PrintWriter rw = response.getWriter(); // WRITER
			
			if (!isEmpty) {
				
				rw.print("failure");

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

				// Cookies defined here
				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(60*60); // 1 hour
				response.addCookie(cookie);

				// Print response
				
				rw.print("success");

			}
		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
	}
}
