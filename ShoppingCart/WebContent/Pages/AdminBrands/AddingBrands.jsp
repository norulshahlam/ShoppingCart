<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.function.BrandManagement" %>

<!DOCTYPE html>
<html>
<head>
<title>Brand Management</title>
<link href="../../css/AddBrd.css" rel="stylesheet" type="text/css">
</head>

<body>
	<form id="form" name="frm" action="../../BrandManagement" method="POST" enctype='multipart/form-data' class="topBefore" onsubmit="return valForm()">
	
	<h2>Add Brands</h2>
	 <input type="text" name="txtName" placeholder="Brand-Name"><br/>
	 <textarea name="brand_desc" rows="4" cols="40" placeholder="Brand-Description"></textarea><br/>
	<input class="submit" type="file" name="bImg" id="bimg"><br/>
	<input class="submit" type="submit"  value="Add Brand">
	</form>


<script>
	function valForm(){
			var nme = document.forms["frm"]["txtName"].value;       // checks for Brand name
			var dsc = document.forms["frm"]["brand_desc"].value;	// checks for Brand description
			if(nme == "" || nme.trim() == "" || dsc == "" || dsc.trim() == ""){			// Validation for texts
				alert("!Complete the form before submission.");
				return false;
			}
			else if (document.getElementById("bimg").files.length == 0){				// Validation for image files
				alert("Don't forget to add the image!");
				return false;
			}
		}
</script>
</body>
</html>