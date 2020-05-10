<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>" 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm to Delete Cart Item</title>
<STYLE>
	ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	}
	
	li {
	    float: left;
	}
	
	li a {
	    display: block;
	    padding: 10px;
	    background-color: #dddddd;
	}
</STYLE>
</head>
<body>
		<%
			String id = request.getParameter("id");
			String custname = request.getParameter("custname");
		%>
		<ul>
  	  		<li><a href="#home">Home</a></li>
	  		<li><a href="ViewProduct.jsp">VIEW PRODUCTS</a></li>
 	  		<li><a href="#contact">Contact</a></li>
 	 		 <li><a href="#about">About</a></li>
		</ul>
		
		<form action="../../deleteCartItem" method="post">
	
			
			<table border="1" cellpadding="5" cellspacing="1">
    		<tr><td>
    			<label>Customer Username</label>
    			<br>
    			<input type="text" name="custName" value="<%=custname%>" readonly="readonly"/>
			</td></tr>
			<tr><td>
    			<label>Product ID</label>
    			<br>
    			<input type="text" name="prodId" value="<%=id%>" readonly="readonly"/>
			</td></tr>
			<tr><td>
    			<input type="submit" name="delete" value="DELETE"/>
			</td></tr>
			</table>
		</form>
		
</body>
</html>