package com.function;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String desc;
	private String brand_name;
	private String category_name;
	
	//default constructor
	public Product(){
		
	}
	//parameterized constructor
	public Product(int id, String name, double price, String desc, String brand_name, String category_name){
		this.id = id;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.brand_name = brand_name;
		this.category_name = category_name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String getCategoryName(){
		return  category_name;
	}
	
	public void setCategoryName(String category_name){
		this.category_name = category_name;
	}
	public String getBrandName(){
		return brand_name;
	}
	
	public void setBrandName(String brand_name){
		this.brand_name = brand_name;
	}
	
	
}
