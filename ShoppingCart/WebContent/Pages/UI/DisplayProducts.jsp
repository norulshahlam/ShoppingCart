<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.math.BigDecimal" %>
<%@page import="com.search.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.search.SearchQuery"%>
<%@page import="com.servlet.controller.searchController"%>

<html>
  <head>
  <style>
table {
    width:50%;
}
table, th, td {
    border: 0px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}

</style>
         <style type="text/css">
  <%@include file="css/main.css" %>
</style>
         <style type="text/css">
  <%@include file="css/product.css" %>
</style>
  </head>
  <body>
  <% int i=1; %>
  <div class="main">
    <div style="width:98%;">
      <!-- Header -->
      <div class="one">
        <ul>
          <li class="one"><a href="Pages/UI/index.jsp">| Home |</a></li>
          <li class="one"><a href="Pages/UI/product.jsp">| Product |</a></li>
          <li class="one"><a href="Pages/UI/contact.jsp">| Contact Us |</a></li>
          <li class="one"><a href="Pages/UI/about.jsp">| About Us |</a></li>

          
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
      <br>
		<table id="t01">
  <tr>
    <th>Product</th>
    <th>Description</th> 
    <th>Price</th>
    <th>Quantity</th>
  </tr>
  <tr>
  
    <c:forEach items="${search}" var="post" >
		
		<tr>		
			<td>${post.getProductName()}</td>
			<td>${post.getProductDesc()}</td>
			<td>${post.getPrice()}</td>
			<td>${post.getQuantity()}</td>
		</tr>
	</c:forEach>

  </tr>

</table>
       <footer>
        <div class="center" style="width:100%; height: auto; border:1px solid #808080;">
            <h4>Online shopping</h4>
            Done By JJ, Farid, Johnathan, Shah, Haritha, Shahul
        </footer>
    </div>
  </body>
</html>
</div>