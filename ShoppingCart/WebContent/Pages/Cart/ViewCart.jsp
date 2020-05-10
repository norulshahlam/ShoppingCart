<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.function.*, com.jdbc.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
  <%@include file="/css/main.css" %>
  </style>
<style>
	.hoverTable{ 
		width:70%;
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
<title>View Cart</title>
</head>
<body>
<div class="main">
    <div style="width:98%;">
      <!-- Header -->
      <div class="one">
        <ul>
          <li class="one"><a href="../UI/index.jsp">| Home |</a></li>
          <li class="one"><a href="../UI/product.jsp">| Product |</a></li>
          <li class="one"><a href="../UI/contact.jsp">| Contact Us |</a></li>
          <li class="one"><a href="../UI/about.jsp">| about Us |</a></li>
          
          <%if(session.getAttribute("Username") != null){ %>
          <li class="one"><a href="../../ProfileControllerPath" method="get">| Profile |</a></li>
          <li class="one"><a href="../Cart/ViewCart.jsp">| Cart |</a></li>
          <li class="one"><a href="../../ViewHistoryController">| View History |</a></li>
          <li class="one"><a href="../../ViewOrderController">| View Orders |</a></li>
          <% } %>
          
          <%if(session.getAttribute("Username") == null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="login" onclick="location.href = '../../Pages/Login/login.jsp'"> Log In </button></li>
       	  <li class="two"><button style="margin-top:15px; margin-left:3px" name="Signup" onclick="location.href = '../../Pages/Signin/signup.jsp'"> Sign up </button></li>
          <% } %>
           
          <%if(session.getAttribute("Username") != null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="Logout" onclick="location.href = '../../Pages/Login/logOut.jsp'"> Log Out </button></li>
          <% } %>
          <form action="../../searchControllerPath" method="post">
          <input name="searchBar" class="search" type="search" placeholder="Search" autocomplete="off" value="" />
          </form>
          
        </ul>
      </div>
	<%String cust_uname = request.getParameter("CustUsername"); 
	List<Cart> list = CartDAO.queryCart(cust_uname);
    request.setAttribute("list", list); 
	%>
	
	<h3>View Cart for <%=cust_uname%></h3>
	<table border="1" cellpadding="5" cellspacing="1" class="hoverTable">
    
    	<tr> 
    		<th>UserName</th> 
    		<th>Product ID</th>
    		<th>Product Name</th> 
    		<th>Image</th>
    		<th>Quantity</th> 
    		<th>Unit Price</th>
    		<th>Total Price</th>
    	</tr>	
   <c:forEach items="${list}" var="cart"  >
        <tr>
            <td>${cart.getUsername()}</td>
            <td>${cart.getId()}</td>
            <td>${cart.getProdName()}</td>
            <td><img src="../../imageServlet?id=${cart.getId()}" width="100" height="100"/></td>
            <td>${cart.getQty()}</td>
            <td>${cart.getUnitPrice()}</td>
            <td>${cart.getTotalPrice()}</td>
            <td> <a href="UpdateCartItem.jsp?id=${cart.id}&custname=${cart.username}" class="button">UPDATE QTY</a></td>
            <td> <a href="DeleteCartItem.jsp?id=${cart.id}&custname=${cart.username}"  class="button">DELETE ITEM</a></td>
        </tr>
    </c:forEach>
	</table>
	
	<form action="../Payment/PaymentPage.jsp">
    <input type="submit" value="Proceed to payment" />
</form>


</body>
</html>