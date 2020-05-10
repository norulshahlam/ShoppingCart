<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.function.*, com.jdbc.*" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details Page</title>
	<style>
	#navcontainer {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	}
	
	#navcontainer li {
	    float: left;
	}
	
	#navcontainer li a {
	    display: block;
	    padding: 8px;
	    background-color: #dddddd;
	}
	</style>
</head>
<body>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	Product prod = ProductDAO.getProductById(id);
%>

	<ul id="navcontainer">
  	  <li><a href="#home">Home</a></li>
	  <li><a href="ViewProduct.jsp">VIEW PRODUCTS</a></li>
 	  <li><a href="#contact">Contact</a></li>
 	  <li><a href="#about">About</a></li>
	</ul>
	<br>
	<h3> Product Details </h3>

	<form action="AddCartItem.jsp" >
	
	<input type="hidden" name="productId" value="<%=prod.getId()%>">
      
      <ul id="detailsList">
         <li><p><b>Product Name:</b>
            <%=prod.getName()%>
         </p></li>
         <li><p><b>Product Price ($):</b>
            <%= prod.getPrice()%>
         </p></li>
          <li><p><b>Description :</b>
            <%= prod.getDesc()%>
         </p></li>
      </ul>
      
      <table width="20%" border="1"> 
      	 <td>
               <img src="../../imageServlet?id=<%=prod.getId()%>" />
         </td>
      </table>	
	</form>
	
	<form action="../../addCartItem" method="post" name ="addCartForm" onsubmit="return valAddCart()">
		<input type="hidden" name="prodId"  value="<%=prod.getId()%>"/>	
		<table border="1" cellpadding="5" cellspacing="1">
    		<tr>	
			<td>
    			<label>Customer Name</label>
    			<input type="text" name="custName"/>
			</td>
			<td>
    			<label>Quantity</label>
    			<input type="text" name="qty" />
			</td>
			<td>
    			<input type="submit" style="font-weight:bold;color:#ff0000;" name="addtocart" value="ADD TO CART"/>
			</td></tr>
		</table>
	</form>
	
	<script>
		function valAddCart(){
				var cust_name = document.forms["addCartForm"]["custName"].value;
				var quantity = document.forms["addCartForm"]["qty"].value;

				if(cust_name == "" || cust_name.trim() == "" || quantity == "" || quantity.trim() == ""){
					alert("Error! Please complete details before submitting!");
					return false;
				}
				else if(isNaN(quantity)){
					alert("Error! Enter a number for the quantity input!");
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