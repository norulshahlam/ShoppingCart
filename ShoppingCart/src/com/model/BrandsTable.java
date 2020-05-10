package com.model;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BrandsTable {
	private int Brand_ID;
	private String Brand_Name, Brand_Desc;
	private InputStream bImage;	
	private byte[] img;
	
	public BrandsTable()
	{}
	public BrandsTable(String bName, String bDesc, InputStream bImg)
	{
		this.Brand_Name=bName;
		this.Brand_Desc=bDesc;
		this.bImage=bImg;
		this.Brand_ID = getBrandID(Brand_Name,Brand_Desc,bImage); //use a function to collect BrandID
	}
	
	public boolean delBrand(int bid){
		boolean status = false;
		this.Brand_ID = bid;
		
		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("DELETE FROM Brands WHERE Brand_ID = ?");
			pstm.setInt(1, Brand_ID);
			int r = pstm.executeUpdate();
			
			if (r > 0){
				status = true;
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	public int getBrandID(String bName, String bDesc, InputStream bImage)
	{
		int bID=0,counter=0;
			
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO Brands VALUES (Brands_Seq.NEXTVAL,?,?,?)");
			pstm.setString(1, bName);
			pstm.setString(2, bDesc);			
			pstm.setBinaryStream(3, bImage);			
			pstm.executeQuery();
			
			
			PreparedStatement pstm1 = con.prepareStatement("SELECT Brand_ID FROM Brands WHERE Brand_Name=?");
			pstm1.setString(1,bName);
			ResultSet rs = pstm1.executeQuery();
			
			while(rs.next())
			{
				bID = rs.getInt(1);   //Gets the Brand_ID based of the name entered
				counter++;			//Keeps count of results returned
			}
			System.out.println(counter + " results received.");
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		
		return bID;
	}
	
	public static List<BrandsTable> drop()
	{
		List<BrandsTable> lst = new ArrayList<BrandsTable>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm = con.createStatement();
			ResultSet rs =	stm.executeQuery("SELECT Brand_ID,Brand_Name FROM Brands");
			
			while(rs.next())
			{
				BrandsTable bt = new BrandsTable();
				bt.setbID(rs.getInt(1));
				bt.setbNme(rs.getString(2));	
				
				lst.add(bt);
			}
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}		
		
		return lst;
	}
	
	public  byte[] getBImage(int bID){
		
		int brandid = bID;
		Blob bs = null;
		byte[] blobAsBytes = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT Brand_Img from Brands WHERE Brand_ID='"+brandid+"'");
			
			while(rs.next()){
				bs= rs.getBlob(1);
				int blobLength = (int) bs.length();  
				blobAsBytes = bs.getBytes(1, blobLength);
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return blobAsBytes;
	}
	
	public static List<BrandsTable> getBrands()
	{
		List<BrandsTable> list = new ArrayList<BrandsTable>();
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement pstm = con.createStatement();
			ResultSet rs =	pstm.executeQuery("SELECT Brand_ID,Brand_Name,Brand_Desc FROM Brands");
						 
			while(rs.next())
			{
				
				BrandsTable bt = new BrandsTable();
				bt.setbID(rs.getInt(1));
				bt.setbNme(rs.getString(2));
				bt.setbDsce(rs.getString(3));				
				list.add(bt);				
			}
			
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		
		
		return list;
	}
	
	
	
	
	
	// SETTERS FOR DATA(s)
	public void setbID(int id)
	{ this.Brand_ID=id;}
	public void setbNme(String nme)
	{ this.Brand_Name=nme;}
	public void setbDsce(String dsc)
	{ this.Brand_Desc=dsc;}
	public void setImg(InputStream img)
	{ this.bImage=img;}
	public void setImgByte(byte[] i)
	{ this.img = i;}
	
	// GETTERS FOR VARIABLE(s)
	public int getID()
	{return Brand_ID;}
	public String getNme()
	{return Brand_Name;}
	public String getDsc()
	{return Brand_Desc;}
	public InputStream getImg()
	{return bImage;}
	public byte[] getImgByte()
	{ return this.img;}
}
