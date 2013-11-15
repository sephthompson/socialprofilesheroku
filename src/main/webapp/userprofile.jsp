<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your user profile</title>
</head>
<body>
	<center>
		<table border="1" width="50%">
			<tbody>
				<tr>
					<td>Hello, <%=session.getAttribute("firstname")%>!
					</td>
					<td><div style="margin: 10px; width: 200px; height: 200px;">
							<center>
								Profile Picture (placeholder)
								<p>
									<img
										src="http://gravatar.com/avatar/827c6969ca33df36ba8f5d53d4088b6f?s=150&r=G"
										alt="Smiley face" height="100" width="100">
								</p>
							</center>
						</div></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><%=session.getAttribute("firstname")%></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><%=session.getAttribute("lastname")%></td>
				</tr>
				<tr>
					<td>About:</td>
					<td><%=session.getAttribute("about")%></td>
				</tr>
			</tbody>
		</table>
		<p>
			<strong>DEBUG: <%=session.getAttribute("email")%></strong>
		</p>
		<p>
			<a href=userprofileconfiguration.jsp>Update Your Profile</a>
		</p>
		<p>
			<a href=logout>Logout</a>
		</p>

	</center>
</body>
</html>