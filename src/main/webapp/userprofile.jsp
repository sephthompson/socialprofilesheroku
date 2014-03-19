<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
									<img src="${root}/images/anonymous_avatar.png" />
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

<%
if(session.getAttribute("email")==null)
{
response.sendRedirect("/templogincheck");
}
%>