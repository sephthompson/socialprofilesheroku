<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<center>
		<table border="1" width="300px">
			<tbody>
				<tr>
					<td align="right">
						<form action=registersubmit method="post">
							Email Address: <input type="text" name="email"><br>
							Password: <input type="text" name="password"><br>
							First Name: <input type="text" name="firstname"><br>
							Last Name: <input type="text" name="lastname"><br>
							<center>
								<br>
								<button type="submit">
									<strong>REGISTER 
								</button>
							</center>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<p>
			<a href=index.jsp>HOME</a>
		</p>
		<%@include file="/debugoutput.jsp"%>
	</center>
</body>
</html>