<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, com.model.*, com.function.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Manage Product(s)</title>
<link href="../../css/MBrands.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		List<ProductsTable> pList = ProductsTable.getProductList();
		request.setAttribute("Plist",pList);
	%>


	<form action="" method="get">
		<H2>Welcome to Product Management Page</H2>
			<table class="table-fill">
			<tr>
				<th class="text-left">Product ID</th>
				<th class="text-left">Product Name</th>
				<th class="text-left">Product Desc</th>
				<th class="text-left">Price($)</th>
				<th class="text-left">Quantity</th>
				<th class="text-left">Brand</th>
				<th class="text-left">Category</th>
				<th class="text-left">Sub-Category</th>
				<th class="text-center">Product Image</th>
				<th class="text-left">Update</th>
				<th class="text-left">Delete</th>
			</tr>		
			<tbody class="table-hover">
			<c:forEach items="${Plist}" var="product" >
		        <tr>
			        <td class="text-left"> ${product.getProductID()}</td>
			        <td  class="text-left">${product.getProductName()}</td>
			        <td  class="text-left">${product.getProductdesc()}</td>
			        <td  class="text-left">$ ${product.getProductPrice()}</td>
			        <td  class="text-left">${product.getProductQuantity()}</td>
			        <td  class="text-left">${product.getProductBrandID()}</td>
			        <td  class="text-left">${product.getProductCategoryID()}</td>
			        <td  class="text-left">${product.getProductSubCatID()}</td>
			        <td  class="text-center"><img src="../../ProductManagement?pid=${product.getProductID()}" width="40%"/></td>
			        <td><a class="button" href="../../ProductUpdate?pid=${product.getProductID()}&btnUpdt=UPDATE">UPDATE</a></td>
			        <td><a class="button" href="../../ProductUpdate?pid=${product.getProductID()}&btnDlte=DELETE" onclick="conFirm()">DELETE</a></td>
		       	</tr>
	    	</c:forEach>	
	    	</tbody>	
		</table>	

	</form>
	
<script>
	function conFirm(){
		alert("You are about to delete the product.");
	}
</script>
</body>
</html>