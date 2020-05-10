<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.function.*, com.jdbc.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Cart Item</title>
</head>
<body>

	<%
		String cust_name = request.getParameter("CustUsername");		
		String pqty = request.getParameter("ProdQty");		
		String id = request.getParameter("productId");
		int productId = Integer.parseInt(id);
		int qty = Integer.parseInt(pqty);
		
		int cartId = CartDAO.getCartIdByCust(cust_name);
		//add cart item
		try{
			CartDAO.addCartItem(cartId, productId, qty);
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
	%> 
	
		<form action="..//addCartItem" method="post">
		<table border="1" cellpadding="5" cellspacing="1">
    		<tr><td>
    			<label>Customer Name</label>
    			<br>
    			<input type="text" name="custName" value="<%=cust_name%>" readonly="readonly"/>
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
	
	
</body>


</html>