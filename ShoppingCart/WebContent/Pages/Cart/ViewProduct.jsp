<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.function.*, com.jdbc.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style >
	.hoverTable{ 
		width:55%;
		padding:7px; 
		border:#4e95f4 1px solid;
	}
	.hoverTable td{ 
		padding:7px; 
		border:#4e95f4 1px solid;
	}

	/* Define the hover highlight color for the table row */
    .hoverTable tr:hover {
          background-color: #ffff99;
    }
    .button {
  		  font: bold 11px Arial;
          text-decoration: none;
          text-align:center;
          display:block;
  		  background-color: #CCFFFF;
		  color: #333333;
		  padding: 4px 12px 4px 12px;
		  border-top: 1px solid #CCCCCC;
		  border-right: 1px solid #333333;
		  border-bottom: 1px solid #333333;
		  border-left: 1px solid #CCCCCC;
	}
	

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List Page</title>
</head>
<body>		 
		 <table border="2" cellpadding="5" cellspacing="1">
    		<tr><td>
    			<label>Customer Name</label>
    			<input type="text" name="CustUsername"/> 
    			<input type="submit" style="font-weight:bold;color:#ff0000;" value="VIEW CART">
			</td></tr>
		</table>



	<h3>Product List</h3>
	<%
		List<Product> list = ProductDAO.queryProducts();
		request.setAttribute("list", list); 
	%>
	<table border="1" cellpadding="5" cellspacing="1" class="hoverTable">
    
    	<tr> 
    		<th>ID</th> 
    		<th>Name</th> 
    		<th>Price</th> 
    		<th>Brand Name</th> 
    		<th>Category</th> 
    		<th>Image</th>
    		<th>Details</th>
    	</tr>	
   <c:forEach items="${list}" var="product"  >
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getBrandName()}</td>
            <td>${product.getCategoryName()}</td>
            <td><img src="../../imageServlet?id=${product.getId()}" width="110" height="110"/></td>
            <td> <a href="ProductDetails.jsp?id=${product.id}" class="button">MORE INFO</a> 
            </td> 
        </tr>
    </c:forEach>
	</table>
	
	<script>
		function valCustName(){
			var cust_name = document.forms["viewCustCart"]["CustUsername"].value;

			if(cust_name == "" || cust_name.trim() == ""){
				alert("Error! Please enter your username before submitting!");
				return false;
			}
		}
	</script>
</body>
</html>