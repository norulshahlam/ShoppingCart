package com.model;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class ProductsTable {
	private int Product_ID,Quantity,Rating,Brand_ID,Category_ID,Sub_Category_ID;
	private double Price;
	private String Product_Name,Product_Desc;
	private InputStream ProductImage;
	
	
	public ProductsTable(){
		// default constructor
	}
	
	public int getProductID(String pName)
	{	//gets product ID
		
		int pID=0,counter=0;
		String pnme=pName;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("SELECT Product_ID FROM Customers WHERE Product_Name=?");
			pstm.setString(1, pnme);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next())
			{
				pID=rs.getInt(1);
				counter++;
			}
			System.out.println(counter +" result(s) recieved.");
			con.close();
		}
		catch(Exception e)
		{System.out.println(e);}
		
		
		return  pID;
	}

	
	public static List<ProductsTable> getProductList(){
		
		List<ProductsTable> list = new ArrayList<ProductsTable>(); 
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT Product_ID,Product_Name,Product_Desc, Price, Quantity, Brand_ID, Category_ID, Sub_Cat_Id FROM Products");
			
			while(rs.next()){
				ProductsTable pt = new ProductsTable();
				pt.setProductId(rs.getInt(1));
				pt.setProductName(rs.getString(2));
				pt.setProductDesc(rs.getString(3));
				pt.setProductPrice(rs.getDouble(4));
				pt.setProductQuantity(rs.getInt(5));
				pt.setProductBrand(rs.getInt(6));
				pt.setProductCategory(rs.getInt(7));
				pt.setProductSubCat(rs.getInt(8));
				list.add(pt);
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}		
		return list;
	}
	
	
	public byte[] getPimage(int id){
		
		int pID = id;
		Blob bb = null;
		byte[] blobby = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT Product_Img from Products WHERE product_ID='"+pID+"'");
			
			while(rs.next()){
				bb= rs.getBlob(1);
				int blobLength = (int) bb.length();  
				blobby = bb.getBytes(1, blobLength);
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return blobby;
	}
	
	public boolean delProduct(int id){
		
		boolean stats = false;
		this.Product_ID = id;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement pstm = con.prepareStatement("DELETE FROM Products WHERE Product_ID=?");
			pstm.setInt(1, Product_ID);
			int r = pstm.executeUpdate();
			if (r>0){
				stats = true;
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return stats;
	}
	
	
	public boolean insertProduct(String pName, String pDesc, double pPrice, int pQuantity, int pBrand, int pCat, int pSubCat, InputStream pImage){
		this.Product_Name = pName;
		this.Product_Desc = pDesc;
		this.Price = pPrice;
		this.Quantity = pQuantity;
		this.Brand_ID = pBrand;
		this.Category_ID = pCat;
		this.Sub_Category_ID = pSubCat;
		this.ProductImage = pImage;
		
		boolean status = false;
		try{
				System.out.println("it's in insertProducts");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				PreparedStatement pstm = con.prepareStatement("INSERT INTO PRODUCTS (Product_ID,Product_Name,Product_Desc, Price, Quantity, Brand_ID, Category_ID, Sub_Cat_ID, Product_Img)" +
						"VALUES (Products_seq.NEXTVAL,?,?,?,?,?,?,?,?)");
				
				pstm.setString(1,Product_Name);
				pstm.setString(2,Product_Desc);
				pstm.setDouble(3,Price);
				pstm.setInt(4,Quantity);
				pstm.setInt(5,Brand_ID);
				pstm.setInt(6,Category_ID);
				pstm.setInt(7,Sub_Category_ID);
				pstm.setBinaryStream(8, ProductImage);
				pstm.executeQuery();
			
				status = true;
		}catch(Exception e){
			System.out.println(e);
			status = false;
		}
		
		
		
		
		return status;
	}
	
	//Getter(s)
	public int getProductID(){
		return this.Product_ID;
	}
	public String getProductName(){
		return this.Product_Name;
	}
	public String getProductdesc(){
		return this.Product_Desc;
	}
	public double getProductPrice(){
		return this.Price;
	}
	public int getProductQuantity(){
		return this.Quantity;
	}
	public int getProductRating(){
		return this.Rating;
	}
	public int getProductBrandID(){
		return this.Brand_ID;
	}
	public int getProductCategoryID(){
		return this.Category_ID;
	}
	public int getProductSubCatID(){
		return this.Sub_Category_ID;
	}
	
	//Setters
	public void setProductId(int id){
		this.Product_ID = id;
	}
	public void setProductName(String pName)
	{
		this.Product_Name=pName;
	}
	public void setProductDesc(String pDesc)
	{
		this.Product_Desc=pDesc;
	}
	public void setProductPrice(double pPrice)
	{
		this.Price=pPrice;
	}
	public void setProductQuantity(int pQuantity)
	{
		this.Quantity=pQuantity;
	}
	public void setProductRating(int pRating)
	{
		this.Rating=pRating;
	}
	public void setProductImage(InputStream pImage)
	{
		this.ProductImage=pImage;
	}
	public void setProductBrand(int pBrand)
	{
		this.Brand_ID=pBrand;
	}
	public void setProductCategory(int pCat)
	{
		this.Category_ID=pCat;
	}
	public void setProductSubCat(int pSubCat)
	{
		this.Sub_Category_ID=pSubCat;
	}
	
}
