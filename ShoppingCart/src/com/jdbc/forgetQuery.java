package com.jdbc;
import java.sql.*;
import java.util.UUID;

import com.function.Security;

public class forgetQuery {
	private String message="";
	private boolean isTrue = false;
	private String username;
	
	public void UpdateNewPassword(String message, String email)
	{
		try
		{	
			Security SEC = new Security();
			StringBuilder SB = SEC.Convert(message);
			message = SB.toString();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement stmt = con.prepareStatement("UPDATE Customers SET password=? WHERE email=?");	
			PreparedStatement stmt1 = con.prepareStatement("UPDATE Users SET password=? WHERE email=?");	
			stmt.setString(1,message);
			stmt.setString(2,email);
			stmt.executeUpdate();
			stmt1.setString(1,message);
			stmt1.setString(2,email);
			stmt1.executeUpdate();
			con.close();
		}
			
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
	public String forgetQuery(String email){
		boolean isTrue = false;
		Connection cons = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cons = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
			stmt = cons.createStatement();
			rs = stmt.executeQuery("select email from users where email='"+email+"'");

			while (rs.next()) 
			{
				if (email.equals(rs.getString(1))) 
				{
					isTrue = true;
					String message = UUID.randomUUID().toString();
					UpdateNewPassword(message,email);
					System.out.println(message);
				} 
			}
			 
			if (!isTrue) 
			{
					message = "invalid";
			}
		
			cons.close();
			/* if(cons!=null)cons.close();
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close(); */
			
			
			}catch(Exception e){
				System.out.println(e);
				message = "invalid";
			}
		return message;
	}
}
