package com.jdbc;
import java.sql.*;

import com.function.Security;


public class loginQuery {
	private String driver,localhost,database_userID,database_passID;
	private String validation ,userID , passID ,roleID,  message, Name, Email, Username, Password;
	private int customer_id;
	private boolean isTrue = false;
	//Deptwise_Salary_Report 
	
	public int getCustomer_id(String username)
	{
		try
		{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT customer_id FROM Customers WHERE username = '"+username+"'");

			while(rs.next())
			{
				customer_id = rs.getInt(1);
			}
			return customer_id;
		}
			
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}		
	}
	
	public String callloginQuery(String username , String password){
		driver = "oracle.jdbc.driver.OracleDriver";
		localhost = "jdbc:oracle:thin:@localhost:1521:xe";
		database_userID = "scott";
		database_passID = "tiger";
		
		Connection cons = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String roleID_admin = "a";
		String roleID_cust = "u";
		
		try{
			Class.forName(driver);
			cons = DriverManager.getConnection(localhost,database_userID,database_passID);
			stmt = cons.createStatement();
			//rs = stmt.executeQuery("Select * from user_login");
			//rs = stmt.executeQuery("select * from users");
			rs = stmt.executeQuery("select Username,Password,Roll_id from Users WHERE username ='"+username+"'");
			
			while(rs.next()){
				
				userID = rs.getString(1);
				passID = rs.getString(2);
				roleID = rs.getString(3);
			}
			
			if (roleID.equals("a") || roleID.equals("A"))
			{
				if(password.equals(passID))
					validation = "AdminUser";														
				else
					validation = "Fail";
			}
			
			else
			{
				if(roleID.equals("u") || roleID.equals("U"))
				{
					if(password.equals(passID))
						validation = "User";														
					else
						validation = "Fail";
				}
			}
		if(cons!=null)cons.close();
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		
		}catch(Exception e){
			validation = "UserNotFound";
		} finally{
			
		}
		return validation;
	}
}
