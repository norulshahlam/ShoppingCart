package com.model;

import java.sql.*;
import java.util.*;


public class SubCategory {

	private int CategoryID, SubCategoryID;
	private String SubCatName;
	
	public SubCategory()     //default constructor to store default values
	{
		this.CategoryID=0;
		this.SubCategoryID=0;
		this.SubCatName="";
	}
	
	
	public void insertSubCategory(int catID, String subcatName)
	{
		this.CategoryID = catID;
		this.SubCatName = subcatName;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO Sub_Category VALUES (SUBCAT_SEQ.NEXTVAL,?,?)");
			pstm.setInt(1,CategoryID);
			pstm.setString(2,SubCatName);
			pstm.executeQuery();
		}
		catch(Exception e)
		{System.out.println(e);}
	}
	
	
	public static List<SubCategory> getSubList(){
		
		List<SubCategory> scList = new ArrayList<SubCategory>();   //<-- creating a List to hold values
							  //<-- creating a SubCategory Object to utilize
		int counter = 0;
		try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			 Statement pstm = con.createStatement();
			 ResultSet rs = pstm.executeQuery("SELECT Category_ID, Sub_Cat_ID,Sub_CatName FROM Sub_Category");
			 
			 while(rs.next()){
				SubCategory sc = new SubCategory();
				sc.setCategoryID(rs.getInt(1));
				sc.setSubCatID(rs.getInt(2));
				sc.setSubCatName(rs.getString(3));
				scList.add(sc);
				counter++;
			 }
			
			 con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return scList;
	}
	
	
	
	// Setters 
	public void setCategoryID(int id){ 
		this.CategoryID = id; }
	public void setSubCatID(int subid){ 
		this.SubCategoryID = subid;}
	public void setSubCatName(String name){ 
		this.SubCatName = name; }
	
	// Getters
	public int getCategoryID(){
		return CategoryID;	}
	
	public int getSubCatID(){
		return SubCategoryID;	}
	
	public String getSubCatName(){
		return SubCatName;	}
}
