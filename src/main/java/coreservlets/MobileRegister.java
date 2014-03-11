package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MobileRegister extends HttpServlet {

	private static final long serialVersionUID = -4697608774711048440L;
	private static String pattern1 = "[\\s\\,]";
	private static String pattern2 = "[\\s]";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String user_id = request.getParameter("user_id");
		String email = request.getParameter("email").replaceAll(pattern1, "");
		String password = request.getParameter("password").replaceAll(pattern2, "");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		PrintWriter rw = response.getWriter(); // WRITER

		String preppedQuery = "INSERT INTO accounts (email, password)"
				+ " VALUES (?, ?);" + "INSERT INTO profiles (user_id)"
				+ " SELECT accounts.user_id" + " FROM accounts"
				+ " WHERE accounts.email = ?;" + "UPDATE profiles SET"
				+ " firstname = ?, lastname = ?"
				+ " FROM accounts WHERE accounts.user_id = profiles.user_id"
				+ " AND accounts.email = ?;";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String url = "jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k?user=oougodzmcwhapf&password=srdrgT5PV-VxBxlDGBPtzmFfsg";
			con = DriverManager.getConnection(url);
			
			try {

				System.out.println(preppedQuery); // DEBUG
	
				ps = con.prepareStatement(preppedQuery);
	
				ps.setString(1, email);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setString(4, firstname);
				ps.setString(5, lastname);
				ps.setString(6, email);
				
				try {
					rs = ps.executeQuery();
					boolean isEmpty = rs.next();
					
					if (!isEmpty) {
						rw.print("failure");
					} else if (isEmpty) {
					
						HttpSession session = request.getSession(true);
						session.setAttribute("user_id", user_id);
						session.setAttribute("email", email);
						session.setAttribute("password", password);
						session.setAttribute("firstname", firstname);
						session.setAttribute("lastname", lastname);
						
						// SUCCESS RESPONSE TO CLIENT
						rw.print("success");
						
					}
					rs.close();
					
				} catch (Exception e) {
					// e.printStackTrace();
					rw.print("PS.EXECUTEQUERY RESULTS: " + e); // PROBLEM HERE
				}
				
				}
			catch (Exception e) {
				// e.printStackTrace();
				rw.print("PS.EXECUTEQUERY POST RESULTS: " + e);
			} finally {
				if (ps != null) {
			        try {
			            ps.close();
			        } catch (SQLException e) {
			        	// e.printStackTrace();
			        	rw.print("PS.CLOSE RESULTS: " + e);
			        	}
			    }
			}
			
			// RESPONSE TO CLIENT -- HAPPENS WHATEVER THE OUTCOME
			rw.print("BOOYA");

		} catch (SQLException e) {
			System.out.println("SQLException occured: " + e.getMessage());
			// e.printStackTrace();
			rw.print("BEFORE CON.CLOSE RESULTS: " + e);
		} finally {
		    
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {
		        	// e.printStackTrace();
		        	rw.print("CON.CLOSE RESULTS: " + e);
		        	}
		    }
		}
	}
}
