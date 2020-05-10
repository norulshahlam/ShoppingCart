<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Termination of session -->
<% session.invalidate(); // To Kill session %>
	<form action="../../loginController" method="post">
		<table>
		<tr>
			<td> Username : </td> 
			<td> <input type="text" id="name" name="username" required/> </td>
		</tr>
		<tr>
			<td> password : </td> 
			<td> <input type="password" name="password" required/> </td>
		</tr>
		<tr>
			<td><button type="submit"> Submit </button></td>
			<td><input type="checkbox" name="remember_pass"/>Remember Login</td>
		</tr>
	</table>
	</form>
<h3> Thank you for shopping with us</h3>

</body>
</html>