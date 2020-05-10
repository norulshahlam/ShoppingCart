<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.jdbc.ViewHistoryQuery"%>
<%@page import="com.servlet.controller.ViewHistoryController"%>


<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <style type="text/css">
  <%@include file="../UI/css/main.css" %>
</style>

  </head>
  <body>
  <body>
<%
	int i = 1;
%>
  <div class="main">
    <div style="width:98%;">
      <!-- Header -->
      <div class="one">
        <ul>
          <li class="one"><a href="index.jsp">| Home |</a></li>
          <li class="one"><a href="product.jsp">| Product |</a></li>
          <li class="one"><a href="contact.jsp">| Contact Us |</a></li>
          <li class="one"><a href="about.jsp">| About Us |</a></li>
          
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
        
        <h2>No results found.</h2>
        
       <footer class="footer">
        <div class="center" style="width:100%; height: auto; border:1px solid #808080;">
            <h4>Online shopping</h4>
            Done By JJ, Farid, Johnathan, Shah, Haritha, Shahul & Ambuj
        </footer>
     	
        
</body>
</html>