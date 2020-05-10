<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.function.CategoryManagement" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../CSS/addCategory.css">
<link href="../../css/AddBrd.css" rel="stylesheet" type="text/css">
<title>Category & Sub-Category</title>
</head>
<body>
	
	
	<form id="form" action="../../CategoryManagement" method="GET">
	<h2>Welcome to Add Category page</h2>
		<div class="contain">
			<div class="cat">
				Category Name: 
				<input type="text" placeholder="eg.bags" name="txtCategory">				
			</div>
			
				<label for="item">+ Add Sub-Category </label>
				<input type="checkbox" name="one" id="item"	>
			
			<div class="subcat">
			 Sub-Category Name:
				<input type="text" placeholder="eg.messenger,backpac..." name="txtSubCat">
			</div>		
		</div>
		
		<input type="submit" name="btnAdd" value="Add Category">
	</form>
	
</body>
</html>