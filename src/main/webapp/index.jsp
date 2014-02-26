<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Social Login</title>
</head>
<body>
	<center>
		<h2>Hello! Welcome to our Social Login Sample page. Please log in
			below.</h2>
		<table border="1" width="95%">
			<tbody>
				<tr>
					<td align="center">
						<div width="50%">
							<form action=templogincheck method="post">
								Email Address: <input type="text" name="email"><br>
								Password: <input type="password" name="password"><br>
								<button type="submit">Log In</button>
								<br>
							</form>
						</div>
					</td>
					<td align="center" width="50%">Don't have an account?<br>
						<br>
						<form action=register.jsp method="post">
							<button type="submit">
								<strong>Sign up!</strong>
							</button>
						</form>
					</td>
			</tbody>
		</table>
		<%@include file="/debugoutput.jsp"%>
	</center>
</body>
</html>