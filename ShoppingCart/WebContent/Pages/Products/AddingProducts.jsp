<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, com.model.*,com.function.ProductManagement"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Manage Products</title>
<link href="../../css/AddBrd.css" rel="stylesheet" type="text/css">
</head>
<body>

	<% 	
    	List<BrandsTable> lst = BrandsTable.drop();
		request.setAttribute("blst",lst);	
		List<CategoryTable> clst = CategoryTable.getCategoryDrop();
		request.setAttribute("Catlst",clst);
		List<SubCategory> sclst = SubCategory.getSubList();
		request.setAttribute("SClist",sclst);		
 	%>
 	
<form id="form" action="../../ProductManagement" method="post" enctype='multipart/form-data' name="frm" onsubmit="return valForm()">
	<h3 style="align:center;"> Welcome to Add Product</h3>
	
	Product name: <input type="text" name="product_name"><br/>
	Product description: <textarea name="product_desc" rows="4" cols="40"></textarea><br/>
	Product Price: <input type="text" name="product_price" pattern='^\d+(?:\.\d{0,2})$' placeholder="eg. 20.0, 0.50"><br/>
	Product Quantity: <input type="text" name="product_Qnty"><br/>
	
	Product Brand: <select id="brandsRecords" name="Sbrand" style="margin-left:54px;">
						<option value="0" selected>Select Brand</option>
						<c:forEach var="brand" items="${blst}">							
							<option value="${brand.getID()}">${brand.getNme()}</option>	
						</c:forEach>				
				   </select><br/>
				   
	Product Category: <select id="categoryRecords" name="SCat" " style="margin-left:32px;">
						<option value="0" selected>Select Category</option>
						<c:forEach var="category" items="${Catlst}">
							<option value="${category.getCatID()}">${category.getCatName()}</option>								
						</c:forEach>				
				  	  </select><br/>
				  	  
				  	  <c:out value="${category.getCatID()}"/>
				  	  
 	Product Sub-Category: <select id="Sub_Categorys" name="SsubCat">
 							<option value="0" selected>Select Sub-Category</option>	
							<c:forEach var="SubCat" items="${SClist}">													
								<option value="${SubCat.getSubCatID()}"}"> ${SubCat.getSubCatName()}</option>					
							</c:forEach>				
				   		  </select><br/>	
	
	Product Image: <input type="file" name="pImg" id="pimg" size="70"><br/>
	<input  type="submit" value="Add Product" class="submit">

	<br/><br/>

</form>

<script>
	function valForm(){
		var nme = document.forms["frm"]["product_name"].value;
		var dsc = document.forms["frm"]["product_desc"].value;
		var price = document.forms["frm"]["product_price"].value;
		var qty = document.forms["frm"]["product_Qnty"].value;
		var b = document.getElementById("brandsRecords");
		var br = b.options[b.selectedIndex].value;
		var c = document.getElementById("categoryRecords");
		var ca = c.options[c.selectedIndex].value;
		var s = document.getElementById("Sub_Categorys");
		var sc = s.options[s.selectedIndex].value;

		if(nme == "" || nme.trim() == ""){
				alert("No Product Name!");
				return false;
		}else if(dsc == "" || dsc.trim()==""){
				alert("No Description entered!");	
				return false;
		}else if(qty == "" || qty.trim()==""){
			alert("Quantity Invalid!");	
			return false;
		}else if(br == 0){
			alert("Please Choose a Brand");
			return false;
		}else if(ca == 0){
			alert("Please Choose a Category");
			return false;
		}else if(sc == 0){
			alert("Please Choose a Sub-Category");
			return false;
		}else if (document.getElementById("pimg").files.length == 0){				// Validation for image files
			alert("Don't forget to add the image!");
			return false;
		}
}
</script>
</body>
</html>