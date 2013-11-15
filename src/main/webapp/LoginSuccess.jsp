<!DOCTYPE html>
<html>
<head>
<title>Sample JSP Page</title>
</head>
<body>
	<center>
		<h1>Sample JSP Page</h1>
		<%@ page import="java.util.*"%>
		<h2>
			Time on server:
			<%=new Date()%></h2>
		<p>
			Hello
			<%=session.getAttribute("firstname") + " "
					+ session.getAttribute("lastname")%></p>
		<p>
			<a href="userprofile.jsp">Proceed to your profile!</a>
		</p>
		<p>
			<a href="logout">Logout</a>
		</p>
	</center>
</body>
</html>