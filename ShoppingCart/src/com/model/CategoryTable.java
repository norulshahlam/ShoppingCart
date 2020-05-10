package com.model;

import java.sql.*;
import java.util.*;

public class CategoryTable {
	//Properties of categorytable
	private int Category_ID;
	private String Category_Name;
	public String stats;
	
	
	public CategoryTable()     //default constructor
	{}
	
	public String insertCategory(String CategoryName)
	{
		this.Category_Name=CategoryName;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO Category VALUES (Category_Seq.NEXTVAL,?)");
			pstm.setString(1, Category_Name );
			pstm.executeQuery();
			
			con.close();
			stats = "Successful";
		}
		catch(Exception e)
		{System.out.println(e);
		 stats=e.toString();}
	
		return stats;
	}
	
	public String insertCat_Sub(String CatName, String SubCatName){
		
		this.Category_Name = CatName;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm1 = con.prepareStatement("INSERT INTO Category VALUES (Category_Seq.NEXTVAL,?)");
			pstm1.setString(1, CatName);
			pstm1.executeQuery();
			
			Statement stm = con.createStatement();			
			ResultSet rs = stm.executeQuery("SELECT Category_ID FROM Category WHERE Category_Name='"+Category_Name+"'");			
			while(rs.next()){
				this.Category_ID=rs.getInt(1);
			}
			if(Category_ID>0){
				SubCategory sbCat = new SubCategory();
				sbCat.insertSubCategory(Category_ID, SubCatName);
			}
			else{
				System.out.println("Invalid Category ID or Null Value FOUND!");
			}
			stats = "Successful";
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
			stats=e.toString();
		}
		return stats;
	}
	
	
	public static List<CategoryTable> getCategoryDrop()
	{
		List<CategoryTable> clist = new ArrayList<CategoryTable>();
		int counter = 0;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Category");
			
			while(rs.next())
			{
				CategoryTable ct = new CategoryTable();
				ct.setCatID(rs.getInt(1));
				ct.setCatNme(rs.getString(2));
				clist.add(ct);
				counter++;
			}
			System.out.println(counter + " results received");
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
			
		return clist;
	}
	
	
	
	
	
	
	//Setters 
	public void setCatID(int ID)
	{
		this.Category_ID = ID;
	}
	public void setCatNme(String Nme)
	{
		this.Category_Name = Nme;
	}
	//Getters
	public int getCatID()
	{
		return Category_ID;
	}
	public String getCatName()
	{
		return Category_Name;
	}
	
	
	
	
}
