package com.model;
import java.sql.*;

public class AdminTable 
{
	private String user,pass;
	
	ResultSet rs1 = null;
	PreparedStatement pstm = null;
	Connection con = null;


	public AdminTable(String u, String p)
	{
		this.user=u;    //Storing Username
		this.pass=p;   //Storing Password
	}
	
	public boolean adminLog()
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			pstm = con.prepareStatement("SELECT Username,Password FROM Admin_User WHERE Username=?");			
			pstm.setString(1,user);
			rs1 = pstm.executeQuery();
			
			while(rs1.next())
			{
				if((rs1.getString(2)).equals(pass))
				{
					return true;
				} 
				else if(!(rs1.getString(2)).equals(pass))
				{
					return false;
				}
			}
			System.out.println(rs1.getString(1));
			
			
			
			
			
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		
		
		return false;
	}
	
	
}
