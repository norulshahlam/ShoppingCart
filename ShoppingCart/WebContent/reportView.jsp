<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "com.function.*" %>
    <%@ page import = "com.servlet.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>

<script type="text/javascript">
  window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer", {

      title:{
        text: "Montly Report Sales By Category"              
      },
      data: [          
        { 

        
         type: "bar",
         dataPoints: [
         { label: "T-Shirt", y: ${category_Tshirt} },
         { label: "Bottom", y: ${category_Hat} },                                    
         { label: "Hats", y: ${category_Bottom} }
         ]
       }
       ]
     });

    chart.render();
  }
  </script>
  <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>

	


<div>
	<center> <h3> Generate Monthly Report </h3> </center>
	<hr><br/>
	<form action ="reportController" method="post">
		 Montly Target(If any) : $<input type="number" name="targetSales">
		 <br/><br/>
		 
		 Select Month : 
		 	<select name="Month">
    			<option value="01">January</option>
   				<option value="02">February</option>
    			<option value="03">March</option>
    			<option value="04">April</option>
   				<option value="05">May</option>
    			<option value="06">June</option>
    			<option value="07">July</option>
   				<option value="08">August</option>
    			<option value="09">September</option>
    			<option value="10">October</option>
    			<option value="11">November</option>
    			<option value="12">December</option>
  			</select>
  			
  			  
		 	<select name="years">
    			<option value="2008">2008</option>
   				<option value="2009">2009</option>
    			<option value="2010">2010</option>
    			<option value="2011">2011</option>
   				<option value="2012">2012</option>
    			<option value="2013">2013</option>
    			<option value="2014">2014</option>
   				<option value="2015">2015</option>
    			<option value="2016">2016</option>
    			<option value="2017" selected>2017</option>
    			<option value="2018">2018</option>
  			</select>
  		
  			<input type="submit" value="submit">
  		</form>
</div>


<div id="mainContainer" style="display:flex">
	<div id="chartContainer" style="height: 300px; width: 50%;"></div>
	
	
	<div id="container_data" style="text-align:center;margin-left:100px;margin-top:50px">
		<table style="width:500px">
 		
 		<tr>
 		   <th>Category</th>
    	   <th>Sales</th> 
    	   <th>Quantity </th>
 		</tr>
 			
 			
 		<tr>
  			<td name="hats1">Hats</td>
    		<td name="prices"> $ ${category_Hat}</td>
    		<td name="qq12"> ${quantity_Hat}</td>
  	    </tr>
  
        <tr>
    		<td>TShirt</td>
    		<td> $ ${category_Tshirt}</td>
    		<td> ${quantity_Tshirt}</td>
  		</tr>
  
  		<tr>
    		<td>Bottom</td>
    		<td> $ ${category_Bottom}</td>
    		<td> ${quantity_Bottom}</td>
  		</tr>
  		
  		<tr>
  		   <td colspan="2" style="text-align:left !important"><strong>  Total Sales</strong></td>
  		   <td><strong> $ ${totalSales} </strong></td>
  		</tr>
  		
  		<tr>
  		   <td colspan="2" style="text-align:left !important"><strong>  Total Quantity</strong></td>
  		   <td><strong> ${totalQuantity} </strong></td>
  		</tr>
  		<tr>
  		   <td colspan="2" style="text-align:left !important"><strong> Percentage </strong></td>
  		   <td><strong> ${percent} </strong></td>
  		</tr>
  		
		</table>
	</div>
</div>


<form action="pdfController" method="get">

<input type="hidden" value="${category_Tshirt}" name="price_T" />
<input type="hidden" value="${category_Hat}" name="price_H" />
<input type="hidden" value="${category_Bottom}" name="price_B" />

<input type="hidden" value="${quantity_Tshirt}" name="quantity_T" />
<input type="hidden" value="${quantity_Hat}" name="quantity_H" />
<input type="hidden" value="${quantity_Bottom}" name="quantity_B" />

<input type="hidden" value="${totalSales}" name="totalSales" />
<input type="hidden" value="${totalQuantity}" name="TotalQuantity" />
<input type="hidden" value="${percent}" name="Percentage" />

	<input type="submit" value="Generate Report PDF"/>
</form>


<hr/>


</body>
</html>