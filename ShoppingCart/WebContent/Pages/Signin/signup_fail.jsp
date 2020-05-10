<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <div>
    <div style="border:1px solid black; text-align: center">
      <h3>Sign Up for Free</h3>
    </div> 
      <form action="../../SignUpPath" method="post">
      
      <table>
		<tr>
			<td> Name : </td> 
			<td>  <input name="Name" placeholder="Name" id="name_input" type="text" required autocomplete="off" />  </td>
		</tr>
		<tr>
			<td> Email : </td> 
			<td> <input name="Email" placeholder="Email" id="email_input" type="text" required autocomplete="off" /> </td>
		</tr>
		<tr>
			<td> Username : </td> 
			<td> <input name="Username" placeholder="Username" id="Username_input" type="text" required autocomplete="off" /> </td>
		</tr>
		<tr>
			<td> password : </td> 
			<td><input name="Password" placeholder="Set A Password" id="password_input" type="password" required autocomplete="off" /> </td>
		</tr>
		<tr><br/>
			<td><button type="submit" class="button button-block" value="SignUp"/>Sign up!</button></td>
		</tr>
	</table>
	
	<br> ERROR. Email or username exists. Please enter a valid username or email.
	
  </form>
</div>

</body>
</html>