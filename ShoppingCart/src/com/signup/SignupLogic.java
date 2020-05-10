package com.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import com.function.Security;


public class SignupLogic 
{
	private String Email;
	private String Username;
	private String Password;
	private String Name;
	private boolean repeat = false;
	private boolean weak = false;
	private boolean SameEmail = false;
	
	public void NewSignUp(String Username, String Password, String Name, String Email)
	{
		try
		{
			// To convert password in hex format and back to string //
			Security SEC = new Security();
			StringBuilder PW = SEC.Convert(Password);
			String password = PW.toString();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");				
			PreparedStatement stmt = con.prepareStatement("INSERT INTO users(Username,Password,Name,Email,Role_id) VALUES(?,?,?,?,?)");	
			
			stmt.setString(1,Username);
			stmt.setString(2,password);
			stmt.setString(3,Name);
			stmt.setString(4,Email);
			stmt.setString(5,"U");
			stmt.executeUpdate();
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public SignupLogic(String Username, String Password, String Name, String Email)
	{
		this.Username = Username;
		this.Password = Password;
		this.Name = Name;
		this.Email = Email;
	}
	
	// True = Repeated username //
	public boolean CheckUser()
	{
		if (repeat == true)
			return true;
		else
			return false;
	}
	// True = Less than 8 characters //
	public boolean CheckPassword()
	{
		if (weak == true)
			return true;
		else
			return false;
	}
	
	public boolean CheckEmail()
	{
		if (SameEmail == true)
			return true;
		else
			return false;
	}

	public void main()
	{
		try
		{
			// Check customer database for repeated username. If repeated, sign-up failed stating username already exists //
			// Set query to find the names inside the database //
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = con.createStatement();	
			Statement stmt1 = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM users");
			ResultSet rs1 = stmt1.executeQuery("SELECT email FROM users");
			
			while (rs.next() && repeat == false)
			{
				if (Username.equals(rs.getString(1)))
					repeat = true;		
			}
			
			while (rs1.next() && SameEmail == false)
			{
				if (Email.equals(rs1.getString(1)))
					SameEmail = true;		
			}
			
			if (Password.length() < 8)
			{
				weak = true;
			}
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
