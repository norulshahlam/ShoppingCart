package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.function.Product;

public class ProductDAO {
	
	public static List<Product> queryProducts() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"scott","tiger");
			pstmt = conn.prepareStatement("SELECT Product_ID, Product_Name, Price, Brand_Name, Category_Name FROM Products p, Brand b, Category c" +
					"WHERE b.Brand_ID = p.Brand_ID AND c.Category_ID = p.Category_ID");
		    rs = pstmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				int id = rs.getInt("Product_ID");
				String name = rs.getString("Product_Name");
				double price = rs.getDouble("Price");
				String brandname = rs.getString("Brand_Name");
				String categoryname = rs.getString("Category_Name");
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setBrandName(brandname);
				product.setCategoryName(categoryname);
				list.add(product);
				
			}
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			if(conn != null){
				conn.close();
			}
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
		}
		return list;
	}
	
	public static Product getProductById(int id){
		Product prod = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			pstmt = conn.prepareStatement("SELECT * FROM Products WHERE Product_ID = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				prod = new Product();
				prod.setId(rs.getInt("ProductID"));
				prod.setName(rs.getString("ProductName"));
				prod.setPrice(rs.getDouble("Price"));
				prod.setDesc(rs.getString("Product_Desc"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return prod;
	}
	
}
