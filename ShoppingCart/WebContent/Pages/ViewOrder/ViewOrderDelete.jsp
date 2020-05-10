<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.jdbc.ViewOrderQuery"%>

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  <%@include file="../UI/css/main.css" %>
</style>
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

<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

		String id = request.getParameter("customer_id");	
		System.out.println("product id is " + id);
		
		String query = "delete from orders where cart_id='"+id+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
		pstmt = conn.prepareStatement(query);
		int i=pstmt.executeUpdate();	//count the number of results
		rs = pstmt.executeQuery();
		out.println("<h1>DELETED!</h1>");	
		
		//response.sendRedirect("ViewOrder.jsp");
		
%>
<br><li class="one"><a href="../../index.jsp">| Back to home |</a></li>
	

</body>
</html>