package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class quantityQuery {
	private String driver,localhost,database_userID,database_passID;
	private String validation , maxProduct , category;
	int result;
	private boolean isTrue = false;
	
	
	
	public int quantitytQuery(String category , int year , int month){
		driver = "oracle.jdbc.driver.OracleDriver";
		localhost = "jdbc:oracle:thin:@localhost:1521:xe";
		database_userID = "scott";
		database_passID = "tiger";
		
		Connection cons = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{
			Class.forName(driver);
			cons = DriverManager.getConnection(localhost,database_userID,database_passID);
			stmt = cons.createStatement();
			//rs = stmt.executeQuery("select sum(price) from sales where to_char(sell,'MM')='"+month+"' AND to_char(sell,'YYYY')='"+year+"' AND CATEGORY= '"+category+"'");     
			rs = stmt.executeQuery("SELECT count('"+category+"') FROM sales WHERE EXTRACT(MONTH from sell) = '"+month+"' and EXTRACT(YEAR from sell) = '"+year+"' AND CATEGORY= '"+category+"'");
			rs.next();
			result = rs.getInt(1); 
		    
		if(cons!=null)cons.close();
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		
		}catch(Exception e){
			//result = "No Result";
			System.out.println(e);
		} finally{
			
		}
		
		return result;
	}
}
