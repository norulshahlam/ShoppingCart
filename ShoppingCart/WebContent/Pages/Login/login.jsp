<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<style type="text/css">
  <%@include file="../../css/login.css" %>
</style>

</head>
<body>

<%
String username_ck = ""; //-- cookies for username
Cookie[] theCookies = request.getCookies();
if(theCookies != null){
	for(Cookie tempCookie : theCookies){
		if("us_ck".equals(tempCookie.getName())){
			username_ck = tempCookie.getValue();
			break;
		}
	}
}
%>
<button onclick="location.href = '../UI/index.jsp'"> Home Page </button>
<hr>
<div class="login-text">

 		<form action="../../loginController" method="post">
  		<center>
  		<table>
  		<tr>
			<td> Username : </td> 
			<td> <input type="text" id="name" name="username" class="login-email" autofocus="true" required="true" value="<%=username_ck %>"/> </td>
		</tr>
		<tr>
			<td> password : </td> 
			<td> <input type="password" name="password" class="login-password" required="true" placeholder="Password" required="true"/> </td>
		</tr>
		<tr>
			
			<td><button type="submit" class="login-submit"> Log in </button></td>
			<td><input type="checkbox" name="remember" value="on"/>Remember Login</td>	
		</tr>
  		
  		</table>	
  		</center>
  		
		</form>
		
		<p>${logOut_message}</p>
		<p>${message}</p>
				<a href="../Forget-password/forgetPass.jsp" class="login-forgot-pass">forgot password?</a>
				<div style="color:red">${errorMessage}</div>
 </div> 


</body>
</html>