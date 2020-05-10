<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Maintainance Page</title>	
	<link href="../../css/mgeMain.css" rel=stylesheet type="text/css" >
	</head>
	<style>
		.card{
			height:16em !important;
		}
	</style>
<body>
<center>	<h3>Management Page</h3> </center>
	<div class="box1" style="display:flex">
		
		
		<div class="card">
			<a href="../Products/AddingProducts.jsp">
			<img src="../../Images/products_img1.jpg" style="width:100%;"></a>
			<div class="container">
				<h4><b>Add Products</b></h4>
				<p>eg/dress/pants/watches</p>
			</div>
		</div>
		<div class="card">
			<a href="../AdminCategory/AddingCategory.jsp">
			<img src="../../Images/category_img1.png" style="width:100%;"></a>
			<div class="container">
				<h4><b>Add Category</b></h4>
				<p>eg/Season-SALE/SPORTS/HOLIDAY</p>
			</div>
		</div>
		<div class="card">
			<a href="../AdminBrands/AddingBrands.jsp">
			<img src="../../Images/brands.ico" style="width:100%;">
			</a>
			<div class="container">
				<h4><b>Add Brands</b></h4>
				<p>eg/NIke/Adidas/Mango</p>				
			</div>
		</div>
		<div class="card">
			<a href="../../reportView.jsp">
			<img src="../../Images/reportGenerator" style="width:100%;">
			</a>
			<div class="container">
				<h4><b>Report Generator</b></h4>
				<p>Montly Report generator</p>				
			</div>
		</div>
		
		
			
	</div>
	
	<div class="box2">
		<div class="sCard">
			<a href="../Products/ManageProduct.jsp">	
			<div class="ttl">Manage-Product</div>
			</a>
			<img src="../../Images/cProd.jpg" style="width:100%; height:100%; opacity:0.5; border-radius:4px;">	
		</div>	
		
		<div class="sCard">	
			<a href="../AdminBrands/ManageBrands.jsp">		
			<div class="ttl">Manage-Brands</div>
			</a>
			<img src="../../Images/sbrands.jpg" width="100%" height="100%"  style="opacity:0.5; border-radius:4px;">
		</div>	
		
		<div class="sCard">
			<a href="../AdminCategory/ManageCategory.jsp">	
			<div class="ttl">Manage-Category</div></a>
			<img src="../../Images/sCat.jpg" style="width:100%; height:100%; opacity:0.5; border-radius:4px;">	
		</div>	
		
	</div>
</body>
</html>