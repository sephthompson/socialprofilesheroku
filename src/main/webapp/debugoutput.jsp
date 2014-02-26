<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%!public Connection cOpen() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager
					.getConnection("jdbc:postgresql://ec2-23-23-81-171.compute-1.amazonaws.com:5432/d3der2cpdnsd7k?user=oougodzmcwhapf&password=srdrgT5PV-VxBxlDGBPtzmFfsg");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return con;
	}
	
	int users_total = 0;

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String SQL = "";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr/>
	<center>
		<h1>DEBUG: Accounts</h1>
		<form action="DebugOutput" method="post">
			<table border="1" width="50%">
				<tbody>
					<tr style="margin:5px;">
						<h3>
							<td>User_ID</td>
							<td>Email</td>
							<td>Password</td>
						</h3>
					</tr>
					<%
						try {
							int usersTotal = 0;
							con = cOpen();
							SQL = "SELECT user_id, email, password FROM accounts ORDER BY user_id ASC;";
							stmt = con.prepareStatement(SQL);
							rs = stmt.executeQuery();
							while (rs.next()) {
							usersTotal++;
					%>
					<tr>
						<td><%=rs.getString("user_id")%></td>
						<td><%=rs.getString("email")%></td>
						<td><%=rs.getString("password")%></td>
					</tr>
					<%
						}
						
					%>
					
					<tr>
						<td><%="TOTAL USERS: " + usersTotal %></td>
					</tr>
					
					<%	
						} catch (SQLException e) {
							e.printStackTrace(System.out);
						} finally {
							try {
								stmt.close();
							} catch (Exception e) {
							}
							try {
								rs.close();
							} catch (Exception e) {
							}
							try {
								if (null != con) {
									con.close();
								}
							} catch (SQLException ex) {
								ex.printStackTrace(System.out);
							}
						}
					%>
				</tbody>
			</table>
		</form>
	</center>
</body>
</html>