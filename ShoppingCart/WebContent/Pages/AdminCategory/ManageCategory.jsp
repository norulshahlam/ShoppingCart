<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, com.model.*, com.function.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Category-Management-Page</title>
<link href="../../css/MBrands.css" rel="stylesheet" type="text/css">
</head>
<body>

<%
	List<CategoryTable> cList = CategoryTable.getCategoryDrop();
	request.setAttribute("Clist",cList);
	List<SubCategory> scList = SubCategory.getSubList();
	request.setAttribute("SClist",scList);
%>
	

	<form action="" method="get">
		<H2> Category & Sub-Category Management Page</H2>
			<table class="table-fill">
				<tr>
					<th class="text-left">Category ID</th>
					<th class="text-left">Category Name</th>
					<th class="text-left">Update</th>
					<th class="text-left">Delete</th>
				</tr>
				<tr>
				<c:forEach items="${Clist}" var="categ" >
		        <tr>
			        <td class="text-left"> ${categ.getCatID()}</td>
			        <td  class="text-left">${categ.getCatName()}</td>
					<td><input type="submit" value="UPDATE" name="btnUpdt"></td>
			        <td><input type="submit" value="DELETE" name="btnDlte"></td>			
				</tr>
				</c:forEach>							
			</table>
			<br/><br/>
			<table class="table-fill">
				<tr>
					<th class="text-left">Sub-Category ID</th>
					<th class="text-left">Sub-Category Name</th>
					<th class="text-left">Category</th>
					<th class="text-left">Update</th>
					<th class="text-left">Delete</th>
				</tr>
				<tr>
				<c:forEach items="${SClist}" var="SubCat" >
		        <tr>
			        <td class="text-left"> ${SubCat.getSubCatID()}</td>
			        <td  class="text-left">${SubCat.getSubCatName()}</td>
			        <td  class="text-left">${SubCat.getCategoryID()}</td>
					<td><input type="submit" value="UPDATE" name="btnUpdt"></td>
			        <td><input type="submit" value="DELETE" name="btnDlte"></td>			
				</tr>
				</c:forEach>							
			</table>
	</form>
</body>
</html>