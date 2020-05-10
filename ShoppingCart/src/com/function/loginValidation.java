package com.function;
import com.jdbc.loginQuery;

public class loginValidation {
	
	public static String login(String username , String password){
		
		loginQuery lg1 = new loginQuery();
		String message , role;
		role = lg1.callloginQuery(username , password);
		
		if(role.equals("AdminUser")){
			//message = "Welcome " + username + "\n You have admin Rights";
			message = "admin";
		}else if(role.equals("User")){
			//message = "Welcome " + username + "\n You have user Rights";
			message = "user";
		} else if(role.equals("UserNotFound")){
			message = "UserNotFound"; 
		}else{
			message = "Inc_pasword";
		}
	
		return message;
	}
}
