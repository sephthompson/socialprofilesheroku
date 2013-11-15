package coreservlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

public class updateprofile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3543421213400202288L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String about = request.getParameter("about");

		String updateQuery = "UPDATE profiles SET firstname = '"
				+ firstname + "', lastname = '" + lastname + "', about = '"
				+ about + "' FROM accounts WHERE accounts.user_id = profiles.user_id"
				+ " AND accounts.email = '"	+ email + "';";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/demo", "postgres",
					"password");
			Statement stmt = con.createStatement();
			boolean rs = stmt.execute(updateQuery);
			// boolean isEmpty = rs.next();

			HttpSession session = request.getSession(true);

			session.setAttribute("email", email);
			session.setAttribute("firstname", firstname);
			session.setAttribute("lastname", lastname);
			session.setAttribute("about", about);

			response.sendRedirect("userprofile.jsp");

		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}