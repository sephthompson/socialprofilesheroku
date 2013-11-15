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
		<form action=updateprofile method="post">
			<input type="hidden" name="email"
				value='<%=session.getAttribute("email")%>'>
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
						<td><input type="text" name="firstname"
							value='<%=session.getAttribute("firstname")%>'></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastname"
							value='<%=session.getAttribute("lastname")%>'></td>
					</tr>
					<tr>
						<td>About:</td>
						<td><input type="text" name="about"
							value='<%=session.getAttribute("about")%>'></td>
					</tr>
				</tbody>
			</table>
			<p>
				<button type="submit">
					<strong>Update Profile</strong>
				</button>
			</p>
		</form>
		<p>
			<a href=userprofile.jsp>Go Back To Profile Without Updating</a>
		</p>
		<p>
			<a href=logout>Logout</a>
		</p>
	</center>
</body>
</html>