package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.function.Cart;


public class CartDAO {

	public static List<Cart> queryCart(String Uname) throws SQLException {
		List<Cart> list = new ArrayList<Cart>();
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			pstmt = conn.prepareStatement("SELECT cust.UserName, p.ProductId, p.ProductName, p.UnitPrice, ci.Quantity, " +
					"p.Unitprice * nvl(ci.Quantity,1) AS TotalPrice " +
					"FROM Cart c, CartItems ci, Customer cust, Dummyprod p " +
					"WHERE ci.CartID = c.CartID AND ci.ProductID = p.ProductID " +
					"AND c.CustomerId = cust.CustomerId AND cust.UserName = ?");
			
			pstmt.setString(1, Uname);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Cart cart = new Cart();
				String username = rs.getString("UserName");
				int productid= rs.getInt("ProductID");
				String productname = rs.getString("ProductName");
				double unitprice = rs.getDouble("UnitPrice");
				int quantity = rs.getInt("Quantity");
				double total = rs.getDouble("TotalPrice");
				cart.setUsername(username);
				cart.setId(productid);
				cart.setProdName(productname);
				cart.setUnitPrice(unitprice);
				cart.setQty(quantity);
				cart.setTotalPrice(total);
				list.add(cart);
			}
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
	
	//add item to cart
	
	public static int getCartIdByCust(String uname){
		
		//Cart cart = new Cart();
		int cart_id = 0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"scott","tiger");
			PreparedStatement pstmt = conn.prepareStatement("SELECT c.CartId FROM Customer cust, Cart c " +
					"WHERE cust.CustomerID = c.CustomerID AND cust.UserName = ?");
			pstmt.setString(1, uname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				cart_id = rs.getInt("CartId");
			}
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return cart_id ;
	}
	
	public static boolean checkCustName(String uname){
		
		boolean isValidCustomer;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"scott","tiger");
			PreparedStatement pstmt = conn.prepareStatement("SELECT username FROM Customer WHERE username = ?");
			pstmt.setString(1, uname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				uname = rs.getString("username");
			}
			conn.close();
			isValidCustomer = true;
		}
		catch(Exception e){
			e.printStackTrace();
			isValidCustomer = false;
		}
		
		return isValidCustomer;
	}
	
	public static boolean addCartItem(int cart_ID, int productID, int qty){
		
		boolean isAddCart;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"scott","tiger");
			pstmt = conn.prepareStatement("INSERT INTO CartItems VALUES (items_id.nextval, ?, ?, ?)");
			pstmt.setInt(1, cart_ID);
			pstmt.setInt(2, productID);
			pstmt.setInt(3, qty);
			
			pstmt.executeQuery();
			conn.close();
			
			isAddCart = true;
		}
		catch(Exception e){
			e.printStackTrace();
			isAddCart = false;
		}
		return isAddCart;
	}
	
	public static boolean updateCartItem(int qty, int cartID, int prodID){
		boolean isUpdate;
		Connection conn;
		PreparedStatement pstmt;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"scott","tiger");
			pstmt = conn.prepareStatement("UPDATE CartItems SET Quantity = ? WHERE CartID = ? AND ProductID = ?");
			pstmt.setInt(1, qty);
			pstmt.setInt(2, cartID);
			pstmt.setInt(3, prodID);
			
			pstmt.executeQuery();
			conn.close();
			
			isUpdate = true;                                                                      
		}
		catch(Exception e){
			e.printStackTrace();
			isUpdate = false;
		}

		return isUpdate;
	}
	
	public static boolean deleteCartItem(int cartID, int prodID){
		
		boolean isDeleteCart;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"scott","tiger");
			pstmt = conn.prepareStatement("DELETE CartItems WHERE ProductID = ? AND CartID = ?");
			pstmt.setInt(1, prodID);
			pstmt.setInt(2, cartID);
			
			pstmt.executeQuery();
			conn.close();
			
			isDeleteCart = true;
		}
		catch(Exception e){
			e.printStackTrace();
			isDeleteCart = false;
		}
		
		return isDeleteCart;
	}
}
