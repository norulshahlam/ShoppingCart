<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, com.model.*, com.function.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Brands</title>
<link href="../../css/MBrands.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="../../BrandUpdate" METHOD="GET">
	<h2>Brands Available</h2><br/>
	<% 
		List<BrandsTable> blist = BrandsTable.getBrands();
		request.setAttribute("blst",blist);	
	%>
		<table class="table-fill">
			<tr>
				<th class="text-left">Brand ID</th>
				<th class="text-left">Brand Name</th>
				<th class="text-left">Brand Description</th>
				<th class="text-left">Brand Image</th>
				<th class="text-left">Update</th>
				<th class="text-left">Delete</th>
			</tr>		
			<tbody class="table-hover">
			<c:forEach items="${blst}" var="brand" >
		        <tr>
			        <td class="text-left">${brand.getID()}</td>
			        <td  class="text-left">${brand.getNme()}</td>
			        <td  class="text-left">${brand.getDsc()}</td>
			        <td  class="text-center"><img src="../../BrandManagement?bid=${brand.getID()}" width="40%"/></td>
			        <td><a class="button" href="../../BrandUpdate?bid=${brand.getID()}&btnUpdt=UPDATE"> UPDATE</a></td>
			        <td><a class="button" href="../../BrandUpdate?bid=${brand.getID()}&btnDlte=DELETE" onclick="conFirm()">DELETE</a> </td>
			       
			        
		       	</tr>
	    	</c:forEach>	
	    	</tbody>	
		</table>	
</form>
<script>
	function conFirm(){
		alert("You are about to delete product!");
	}
</script>
</body>
</html>