<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome User ...... <br/>
	
	<!-- Getting session ID -->
	 <%String sessionID = session.getId();
     out.println("<br/> Session ID : " + sessionID);
     %>
     
     
	<form action="../Login/logOut.jsp">
		<button type="submit">Log out</button>
	</form>
	
	
<form action='../../ProfileControllerPath' method='Get'> 
<input type='submit' value='View Settings'> 
</form> 	
</body>
</html>