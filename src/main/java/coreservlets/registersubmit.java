package coreservlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

public class registersubmit extends HttpServlet {

	private static final long serialVersionUID = 1029849297015934427L;
	private static String pattern1 = "[\\s\\,]";
	private static String pattern2 = "[\\s]";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String email = request.getParameter("email").replaceAll(pattern1, "");
		String password = request.getParameter("password").replaceAll(pattern2,
				"");

		String preppedQuery = "INSERT INTO accounts (email, password)"
				+ " VALUES (?, ?);" + "INSERT INTO profiles (user_id)"
				+ " SELECT accounts.user_id" + " FROM accounts"
				+ " WHERE accounts.email = ?;";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String url = "jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k?user=oougodzmcwhapf&password=srdrgT5PV-VxBxlDGBPtzmFfsg";
			Connection con = DriverManager.getConnection(url);

			System.out.println(preppedQuery); // DEBUG

			PreparedStatement ps = con.prepareStatement(preppedQuery);

			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, email);

			System.out.println("SQL=" + preppedQuery.toString()); // DEBUG

			ps.execute();

			System.out.println("Executed=" + preppedQuery.toString()); // DEBUG

			HttpSession session = request.getSession(true);
			session.setAttribute("user_id", user_id);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			response.sendRedirect("welcome.jsp");

		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
