<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>

<body onunload="noBack();"
    onpageshow="if (event.persisted) noBack();" >



<%
//session.setAttribute("give","give me sess");
//String hello = (String)session.getAttribute("give");
String back = (String)session.getAttribute("back");
%>

<br/>

<%if(back == null){
	//setting a refresh function 
	//get the last time of visit
	//refresh at 0 seconds
	response.sendRedirect("../Login/login.jsp");
	
}
%>
<br/>

<h2>Payment Successful</h2>
<a href="../../index.jsp">Continue Shopping</a>
<br><br><br><a href="../Login/logOut.jsp">Log Out</a>
</body>
</html>