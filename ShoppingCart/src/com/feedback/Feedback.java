package com.feedback;

import java.lang.*;
import java.sql.*;

public class Feedback
{
	private String Customer_Name;
	private int Contact_Number;
	private String Feedback_Category;
	private String Feedback;
	 
	public void UpdateGeneralFeedback(String Customer_Name, int Contact_Number, String Feedback_Category, String Feedback)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement stmt  = con.prepareStatement("INSERT INTO Feedback(Cname,Cnumber,Cfeedbackcat,Cfeedback) VALUES(?,?,?,?)");
			stmt.setString(1,Customer_Name);
			stmt.setInt(2,Contact_Number);
			stmt.setString(3,Feedback_Category);
			stmt.setString(4,Feedback);
			stmt.executeQuery();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdateProductFeedback(String Customer_Username, String Rating, String Product_Feedback)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			PreparedStatement stmt  = con.prepareStatement("INSERT INTO ProductFeedback(Cusername,Crating,Cproduct_feedback,) VALUES(?,?,?)");
			stmt.setString(1,Customer_Username);
			stmt.setString(2,Rating);
			stmt.setString(3,Product_Feedback);
			stmt.executeQuery();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
