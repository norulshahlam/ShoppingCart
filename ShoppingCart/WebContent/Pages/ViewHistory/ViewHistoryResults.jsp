<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.jdbc.ViewHistoryQuery"%>
<%@page import="com.servlet.controller.ViewHistoryController"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <style type="text/css">
  <%@include file="../UI/css/main.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int i = 1;
%>
<div class="main">
    <div style="width:98%;">
      <!-- Header -->
      <div class="one">
        <ul>
          <li class="one"><a href="../UI/index.jsp">| Home |</a></li>
          <li class="one"><a href="../UI/product.jsp">| Product |</a></li>
          <li class="one"><a href="../UI/contact.jsp">| Contact Us |</a></li>
          <li class="one"><a href="../UI/about.jsp">| About Us |</a></li>
          <%if(session.getAttribute("Username") != null){ %>
          <li class="one"><a href="ProfileControllerPath" method="get">| Profile |</a></li>
          <li class="one"><a href="Pages/Cart/ViewCart.jsp">| Cart |</a></li>
          <li class="one"><a href="ViewHistoryController">| View History |</a></li>
          <li class="one"><a href="ViewOrderController">| View Orders |</a></li>
          <% } %>
          
          <%if(session.getAttribute("Username") == null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="login" onclick="location.href = '../../Pages/Login/login.jsp'"> Log In </button></li>
       	  <li class="two"><button style="margin-top:15px; margin-left:3px" name="Signup" onclick="location.href = '../../Pages/Signin/signup.jsp'"> Sign up </button></li>
          <% } %>
           
          <%if(session.getAttribute("Username") != null){ %>
          <li class="two"><button style="margin-top:15px; margin-left:3px ; margin-right:3px;" name="Logout" onclick="location.href = '../../Pages/Login/logOut.jsp'"> Log Out </button></li>
          <% } %>
          <form action="searchControllerPath" method="post">
          <input name="searchBar" class="search" type="search" placeholder="Search" autocomplete="off" value="" />
          </form>
        </ul>

<h1>Order history</h1>
	<TABLE BORDER="1" cellpadding="5" cellspacing="1">
	<THEAD>
	<tr>
		<th>Index</th>
		<th>Order ID</th>
		<th>CArt ID</th>
		<th>Address</th>
		<th>Amount</th>
	</tr>
	</THEAD>
	
	<c:forEach items="${posts}" var="post" >
		<tr>
			<td><%=i++%></td>
			<td>${post.getOrderID()}</td>
			<td>${post.getCartID()}</td>
			<td>${post.getAddress()}</td>
			<td>${post.getPrice()}</td>
		</tr>
	</c:forEach>
	</table>
	
	<br><li class="one"><a href="../../main.jsp">| Back to home |</a></li>
</body>
</html>