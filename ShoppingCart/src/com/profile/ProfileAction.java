package com.profile;

import java.lang.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.function.Security;

public class ProfileAction 
{
	private int Customer_ID;
	private String Customer_Name;
	private String Username;
	private String Password;
	private String Email;
	private String Gender;
	private Date DOB;
	private int Contact_1;
	private int Contact_2;
	private String Payment_Method;
	private String Address_1;
	private String Address_2;
	
	public int getCustomer_ID()
	{
		return Customer_ID;
	}
	
	public String getCustomer_Name()
	{
		return Customer_Name;
	}
	
	public String getUsername()
	{
		return Username;
	}
	
	public String getPassword()
	{
		return Password;
	}
	
	public String getEmail()
	{
		return Email;
	}
	
	public String getGender()
	{
		return Gender;
	}
	
	public Date getDOB()
	{
		return DOB;
	}
	
	public int getContact_1()
	{
		return Contact_1;
	}
	
	public int getContact_2()
	{
		return Contact_2;
	}
	
	public String getPayment_Method()
	{
		return Payment_Method;
	}
	
	public String getAddress_1()
	{
		return Address_1;
	}
	
	public String getAddress_2()
	{
		return Address_2;
	}
	
	public void CreateProfile(String Customer_Name,String Username,String Password,String Email,String Gender,Date DOB,
			int Contact_1,int Contact_2,String Payment_Method,
			String Address_1,String Address_2)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement stmt1  = con.prepareStatement("INSERT INTO Customers(CUSTOMER_ID,CUSTOMER_NAME,USERNAME,PASSWORD," +
					"EMAIL,GENDER,DOB,CONTACT_1,CONTACT_2,PAYMENT_METHOD,ADDRESS_1,ADDRESS_2)" +
					"values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			Security SEC = new Security();
			StringBuilder PW = SEC.Convert(Password);
			String password = PW.toString();
			
			
			Random rand = new Random();
			int Customer_id = rand.nextInt(50) + 1;

			stmt1.setInt(1,Customer_id);
			stmt1.setString(2,Customer_Name);
			stmt1.setString(3,Username);
			stmt1.setString(4,password);
			stmt1.setString(5,Email);
			stmt1.setString(6,Gender);
			stmt1.setDate(7,(java.sql.Date)DOB);
			stmt1.setInt(8,Contact_1);
			stmt1.setInt(9,Contact_2);
			stmt1.setString(10,Payment_Method);
			stmt1.setString(11,Address_1);
			stmt1.setString(12,Address_2);

			stmt1.executeUpdate();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void UpdateProfile(String Customer_Name,String Username,String Password,String Email,String Gender,String DOB,
			int Contact_1,int Contact_2,String Payment_Method,
			String Address_1,String Address_2)
	{
		
		if(Password != null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				PreparedStatement stmt1  = con.prepareStatement("UPDATE Customers SET CUSTOMER_NAME=?,PASSWORD=?," +
						"EMAIL=?,GENDER=?,DOB=?,CONTACT_1=?,CONTACT_2=?,PAYMENT_METHOD=?,ADDRESS_1=?,ADDRESS_2=? WHERE Username =? ");
				PreparedStatement stmt2  = con.prepareStatement("UPDATE Users SET name=?,email=?,password=? WHERE username=?");
				
				Security SEC = new Security();
				StringBuilder PW = SEC.Convert(Password);
				String password = PW.toString();
				
				stmt1.setString(1,Customer_Name);
				stmt1.setString(2,password);
				stmt1.setString(3,Email);
				stmt1.setString(4,Gender);
				stmt1.setDate(5,java.sql.Date.valueOf(DOB));
				stmt1.setInt(6,Contact_1);
				stmt1.setInt(7,Contact_2);
				stmt1.setString(8,Payment_Method);
				stmt1.setString(9,Address_1);
				stmt1.setString(10,Address_2);
				stmt1.setString(11,Username);
				
				stmt2.setString(1,Customer_Name);
				stmt2.setString(2,Email);
				stmt2.setString(3,password);
				stmt2.setString(4,Username);
				
				stmt1.executeUpdate();
				stmt2.executeUpdate();
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				PreparedStatement stmt1  = con.prepareStatement("UPDATE Customers SET CUSTOMER_NAME=?," +
						"EMAIL=?,GENDER=?,DOB=?,CONTACT_1=?,CONTACT_2=?,PAYMENT_METHOD=?,ADDRESS_1=?,ADDRESS_2=? WHERE Username =? ");
				PreparedStatement stmt2  = con.prepareStatement("UPDATE Users SET name=?,email=? WHERE username=?");
				
				stmt1.setString(1,Customer_Name);
				stmt1.setString(2,Email);
				stmt1.setString(3,Gender);
				stmt1.setDate(4,java.sql.Date.valueOf(DOB));
				stmt1.setInt(5,Contact_1);
				stmt1.setInt(6,Contact_2);
				stmt1.setString(7,Payment_Method);
				stmt1.setString(8,Address_1);
				stmt1.setString(9,Address_2);
				stmt1.setString(10,Username);
				
				stmt2.setString(1,Customer_Name);
				stmt2.setString(2,Email);
				stmt2.setString(3,Username);
				
				stmt1.executeUpdate();
				stmt2.executeUpdate();
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}
	
	public void DisplayProfile(String uname)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt = con.createStatement();	
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE username = '"+uname+"'");
			while(rs.next())
			{
				Customer_ID = rs.getInt(1);
				Customer_Name = rs.getString(2);
				Username = rs.getString(3);
				Password = rs.getString(4);
				Email = rs.getString(5);
				Gender = rs.getString(6);
				DOB = rs.getDate(7);
				Contact_1 = rs.getInt(8);
				Contact_2 = rs.getInt(9);
				Payment_Method = rs.getString(10);
				Address_1 = rs.getString(11);
				Address_2 = rs.getString(12);
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
