package com.function;

public class Cart {
	private int id;
	private String ProductName;
	private String username;
	private int qty;
	private int CartID;
	private double UnitPrice;
	private double TotalPrice;
	
	//default constructor
	public Cart(){
		
	}
	//parameterized constructor
	public Cart(String username, int id, String ProductName, int qty, 
			int CartID, double UnitPrice, double TotalPrice)
	{
		this.username = username;
		this.id = id;
		this.ProductName = ProductName;
		this.qty = qty;
		this.CartID = CartID;
		this.UnitPrice = UnitPrice;
		this.TotalPrice = TotalPrice;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getProdName(){
		return ProductName;
	}
	
	public void setProdName(String ProductName){
		this.ProductName = ProductName;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public int getQty(){
		return qty;
	}
	
	public void setQty(int qty){
		this.qty = qty;
	}
	
	public int getCartId(){
		return CartID;
	}
	
	public void setCartId(int CartID){
		this.CartID = CartID;
	}
	
	public double getUnitPrice(){
		return UnitPrice;
	}
	
	public void setUnitPrice(double UnitPrice){
		this.UnitPrice = UnitPrice;
	}
	
	public double getTotalPrice(){
		return TotalPrice;
	}
	
	public void setTotalPrice(double TotalPrice){
		this.TotalPrice = TotalPrice;
	}
}
