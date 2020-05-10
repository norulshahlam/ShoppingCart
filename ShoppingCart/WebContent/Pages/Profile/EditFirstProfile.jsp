<%@ page import="com.profile.ProfileAction" %>
<%@ page import="com.servlet.controller.*" %>

<!DOCTYPE html PUBLIC" );
<html> 
<head> 
<title>Profile Page</title> 
<style> 
label {display:block; float:left; width:100px;} 
</style> 
</head> 
<body> 
<form action='../../UpdateFirstProfilePath' method='Post'> 
<h2>Edit user profile settings</h2> 

<br><label>Name</label>: <input type="text" name="CustName" value=${CustName}><br> 
<br><label>Password</label>: <input type="password" name="CustPassword" value=""><br> 
<br><label>Email</label>: <input type="text" name="CustEmail" value=${CustEmail}><br> 
<br><label>Gender</label>: <input type="text" name="CustGender" value=${CustGender}><br> 
<br><label>Date of birth:</label>: <input type="text" name="CustDOB" value=${CustDOB}><br> 
<br><label>Contact_1</label>: <input type="text" name="CustContact_1" value=${CustContact_1}><br> 
<br><label>Contact_2</label>: <input type="text" name="CustContact_2" value=${CustContact_2}><br> 
<br><label>Payment_Method</label>: <input type="text" name="CustPayment_Method" value=${CustPayment_Method}><br> 
<br><label>Address_1</label>: <input type="text" name="CustAddress_1" value=${CustAddress_1}><br> 
<br><label>Address_2</label>: <input type="text" name="CustAddress_2" value=${CustAddress_2}><br> 
<br><input type='submit' value='Save Settings'> 
<tr>  </tr>
<button onclick="location.href = '../UI/index.jsp'"> Back to Home Page </button>
</form> 	
</body> 
</html>  