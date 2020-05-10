<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.function.*, com.jdbc.*, java.util.*, com.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Cart Item</title>
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
		String pid = request.getParameter("id");
		int productId = Integer.parseInt(pid);	
		String custname = request.getParameter("custname");
	%>
	
	<ul>
  	  <li><a href="#home">Home</a></li>
	  <li><a href="ViewProduct.jsp">VIEW PRODUCTS</a></li>
 	  <li><a href="#contact">Contact</a></li>
 	  <li><a href="#about">About</a></li>
	</ul>
	
	<form action="../../updateCart" method="post" name="updateCartForm" onsubmit="return valQty()">
		<table border="1" cellpadding="5" cellspacing="1">
    		<tr><td>
    			<label>Customer Name</label>
    			<br>
    			<input type="text" name="custName" value="<%=custname%>" readonly="readonly"/>
			</td></tr>
			<tr><td>
    			<label>Product ID</label>
    			<br>
    			<input type="text" name="prodId" value="<%=productId %>" readonly="readonly"/>
			</td></tr>
			<tr><td>
    			<label>Quantity</label>
    			<br>
    			<input type="text" name="qty" />
			</td></tr>
			<tr><td>
    			<label></label><input type="submit" name="update" value="UPDATE"/>
			</td></tr>
		</table>
	</form>
	
	<script>
		function valQty(){
			var quantity = document.forms["updateCartForm"]["qty"].value;

			if(isNaN(quantity)){
				alert("Please enter a number for the quantity input!");
				return false;
			}
			else if(quantity < 1 || quantity > 10){
				alert("Error! Quantity Input needs to be below 10 and above 1");
				return false;
			}
		}
	</script>
</body>
</html>