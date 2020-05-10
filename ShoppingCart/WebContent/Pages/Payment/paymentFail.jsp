<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../UI/css/Payment.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment page</title>
</head>
<body>
<h1>Invalid Details Re-Enter</h1>
<Form action="../../PaymentController" method="post">  
<div id ="rcorners2"><h2>

		Cardholder's Name : <BR><INPUT Type="text" Name="CARDNAME" autofocus="true" required="true"><BR>
		<BR>Card Number : <BR><INPUT Type="number" Name="CARDNUM" required="true" maxlength="16"/><BR>
		<BR>Payment Method : <BR>
		<select name="method" required="true">
    	<option value="VISA">VISA</option>
   		<option value="MASTERCARD">MASTERCARD</option>
 		</select>
		<BR><br>CVV: <BR><INPUT Type="number" Name="CVV" maxlength="3" />
		<BR><br>Card Expiry : <BR><select id="exMonth" Name="MONTH" required="true" title="select a month">
		<option value="0">Month</option>
   		<option value="JANUARY">January</option>
  	  	<option value="FEBRUARY">February</option>
  	  	<option value="MARCH">March</option>
   		<option value="APRIL">April</option>
	    <option value="MAY">May</option>
	    <option value="JUNE">June</option>
    	<option value="JULY">July</option>
    	<option value="AUGUST">August</option>
    	<option value="SEPTEMBER">September</option>
    	<option value="OCTOBER">October</option>
   	 	<option value="NOVEMBER">November</option>
    	<option value="DECEMBER">December</option>
		</select>
		<BR><br><select id="exYear" Name="YEAR" required="true" title="select a year">
 		<option value="0">Year</option>
    	<option value="2013">2013</option>
    	<option value="2014">2014</option>
    	<option value="2015">2015</option>
    	<option value="2016">2016</option>
    	<option value="2017">2017</option>
    	<option value="2018">2018</option>
    	<option value="2019">2019</option>
    	<option value="2020">2020</option>
		</select>
		<BR><br><input type="checkbox" id="RememberMe" name="rememberMe"><label for="RememberMe">Remember Card</label>
		<BR><BR><INPUT Type="submit" Value="Proceed Payment"/></h2>
</div>
</FORM>

</body>
</html>