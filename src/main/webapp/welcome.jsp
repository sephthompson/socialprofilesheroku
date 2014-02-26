<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<br>
		<table border="0" width="50%">
			<tbody>
				<tr>
					<td>DEBUG: Your user ID is:</td>
					<td><%=session.getAttribute("user_id")%></td>
				</tr>
				<tr>
					<td>DEBUG: You have registered as:</td>
					<td><%=session.getAttribute("email")%></td>
				</tr>
				<tr>
					<td>DEBUG: You have set your password as:</td>
					<td><%=session.getAttribute("password")%></td>
				</tr>
			</tbody>
		</table>
		<br> <br>
		<h1>BOOYA!</h1>
		<p>
			<a href="logout">Logout</a>
		</p>
		<p>
			<%@include file="/debugoutput.jsp"%>
		</p>
	</center>
</body>
</html>