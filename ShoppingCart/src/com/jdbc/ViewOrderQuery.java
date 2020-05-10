package com.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewOrderQuery 
{
	public boolean isTrue = false;
	int OrderID, CartID, Price;
	static int results;
	String Address;
	
	/*public ViewOrderQuery(boolean isTrue, int OrderID, int CartID,int Price, int results,	String Address){
		this.isTrue = isTrue;
		this.OrderID = OrderID;
		this.CartID = CartID;
		this.Price = Price;
		this.results = results;
		this.Address = Address;
	}*/
	
	
	
	public int getOrderID()
	{
		return OrderID;
	}
	public int getCartID()
	{
		return CartID;
	}
	public int getPrice()
	{
		return Price;
	}
	public String getAddress()
	{
		return Address;
	}
	
	
	
	
	public void setOrderID(int OrderID)
	{
		this.OrderID=OrderID;
	}
	public void setCartID(int CartID)
	{
		this.CartID=CartID;
	}
	public void setPrice(int Price)
	{
		this.Price=Price;
	}
	public void setAddress(String Address)
	{
		this.Address=Address;
	}
	
	
	
	
	public static List<ViewOrderQuery> getOrder(int CustID)
	{
		List<ViewOrderQuery> vhqList = new ArrayList<ViewOrderQuery>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String query = "select b.customer_id, a.order_id, b.cart_id, a.address, a.total_price, a.status_id, a.updatedon from orders a, cart b where a.cart_id=b.cart_id AND b.customer_id=? AND a.status_id!=4";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, CustID);
			int i=pstmt.executeUpdate();	//count the number of result
			rs = pstmt.executeQuery();
				
			boolean isTrue = false;
				
				
				while(rs.next())
				{
					if (CustID==(rs.getInt(1))) 
					{	
						if(isTrue=false)
						{
							results=i;
							isTrue=true;
						}
						
					ViewOrderQuery VHQ = new ViewOrderQuery();
						
					VHQ.setOrderID(rs.getInt(2));
					VHQ.setCartID(rs.getInt(3));
					VHQ.setAddress(rs.getString(4));
					VHQ.setPrice(rs.getInt(5));
						
					isTrue = true;
					vhqList.add(VHQ);					
					} 
					
				if(!isTrue) 
				System.out.println("NO ORDER");
				}
				
				conn.close();	
				System.out.println("You have " +i+ " results");
		}
		
		catch(Exception e)
		{System.out.println(e);}
			
	   return vhqList;
	}
	
	public static int results()
	{
		int k=results;
		return k;
	}
}
