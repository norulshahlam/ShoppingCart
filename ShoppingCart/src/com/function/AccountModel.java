package com.function;
import java.lang.*;
import java.sql.*;

public class AccountModel 
{
	private String Uname;
	private String Upass;
	private String Urole;
	static boolean correct=false;

	
	public boolean login(String Username,String Password)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT username,password,role_id WHERE username ='"+Username+"'");
			
			while(rs.next())
			{
				Uname = rs.getString(1);
				Upass = rs.getString(2);
				Urole = rs.getString(3);
			}
			
			if (Username.equals(Uname))
			{
				if (Password.equals(Upass))
				{
					if (Urole.equals("a"))
					{
						correct = true;
						System.out.println("Welcome Administrator"+Uname+".");
					}
					else
					{
						correct = true;
						System.out.println("Welcome back "+Uname+".");
					}
				}
				
				else
				{
					System.out.println("Password is wrong. Please re-enter password.");
				}
			}
			
			else
			{
				System.out.println("Please enter a valid username");
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return correct;
	}
}
