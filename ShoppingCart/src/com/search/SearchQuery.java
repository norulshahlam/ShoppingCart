package com.search;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.ViewHistoryQuery;

public class SearchQuery
{
	private String product;
	private String description;
	private BigDecimal price;
	private int quantity;
	private int count;

	public String getProductName()
	{
		return product;
	}
	public String getProductDesc()
	{
		return description;
	}
	public BigDecimal getPrice()
	{
		return price;
	}
	public int getQuantity()
	{
		return quantity;
	}
	
	
	
	public void setProductName(String product)
	{
		this.product = product;
	}
	public void setProductDesc(String description)
	{
		this.description = description;
	}
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	
	public static List<SearchQuery> SearchItem(String keyword)
	{
		 List<SearchQuery> SQList = new ArrayList<SearchQuery>();
		 try
		 {
			 
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery("select product_name,product_desc,price,quantity from Products where product_name like '%"+keyword+"%'"); 
		     
		     while (rs.next()) 
		     {
		    	 SearchQuery SQ = new SearchQuery();
		    	 
				 SQ.setProductName(rs.getString(1));
				 SQ.setProductDesc(rs.getString(2));
				 SQ.setPrice(rs.getBigDecimal(3));
				 SQ.setQuantity(rs.getInt(4));
				 
				 SQList.add(SQ);
		     }    
		     
		     con.close();
		 }
		      
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
		 return SQList;
	}
	
}

