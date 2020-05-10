<%@ page import="com.profile.ProfileAction" %>

<html> 
<head> 
<title>Profile Page</title> 
</head> 
<body> 

<h3>View user profile settings</h3> 
<br> Customer's ID : ${Cust_ID} <br>  
<br> Customer's Name :${CustName} <br>  
<br> Customer's Username :${CustUserName}<br>  
<br> Customer's Password :<br>  
<br> Customer's Email :${CustEmail}<br>  
<br> Customer's Gender :${CustGender}<br>  
<br> Customer's Date of Birth :${CustDOB}<br>   
<br> Customer's primary contact is :${CustContact_1}<br>  
<br> Customer's secondary contact is :${CustContact_2}<br>  
<br> Customer's payment method is :${CustPayment_Method}<br>  
<br> Customer's primary address is :${CustAddress_1}<br>  
<br> Customer's secondary address is :${CustAddress_2}<br>  
<form action='ProfileControllerPath' method='Post'> 
<input type='submit' value='Edit Settings'> 
</form> 	
</body> 
</html>  