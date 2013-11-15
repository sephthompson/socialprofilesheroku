package coreservlets;

import java.io.IOException;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.http.HttpSession;

public class registersubmit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029849297015934427L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String updateQuery = "INSERT INTO accounts (email, password)"
				+ " VALUES ('"
				+ email + "','"
				+ password + "');";

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
			
			response.sendRedirect("welcome.jsp");

		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
