package com.jdbc;

import java.security.MessageDigest;
import java.sql.*;

import com.function.Security;


public class paymentQuery {
	private String driver,localhost,database_userID,database_passID;
	private boolean validate = false;
	
	public boolean callpaymentQuery(String CARDNAME, String CARDNUM, String CVV, String METHOD, String MONTH, int YEAR)throws Exception
	{
	
	//----------------------------------------SHA-1--------------------------------------//
		String CARDNUM2,CVV2;

		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(CARDNUM.getBytes());
	    byte byteData1[] = md.digest();
	    //convert the byte to hex format method 1
	    StringBuffer sb1 = new StringBuffer();
	    for (int i = 0; i < byteData1.length; i++) 
	    {	sb1.append(Integer.toString((byteData1[i] & 0xff) + 0x100, 16).substring(1));    }
	    CARDNUM2=sb1.toString();
//-------------------------------------------------------------------------------------//  
	    md.update(CVV.getBytes());
	    byte byteData2[] = md.digest();
	    //convert the byte to hex format method 1
	    StringBuffer sb2 = new StringBuffer();
	    for (int k = 0; k < byteData2.length; k++) 
	    {	sb2.append(Integer.toString((byteData2[k] & 0xff) + 0x100, 16).substring(1));    }
	    CVV2=sb2.toString();
	    
//-----------------------------------------END OF SHA-1--------------------------------//
	
		System.out.println("in query\n CARDNAME: " +CARDNAME + "\nCARDNUM: " +CARDNUM + "\nCVV: " +CVV+ "\nMETHOD " +METHOD+ "\nMONTH " +MONTH+ "\nYEAR " +YEAR);
		
		driver = "oracle.jdbc.driver.OracleDriver";
		localhost = "jdbc:oracle:thin:@localhost:1521:xe";
		database_userID = "scott";
		database_passID = "tiger";
		Connection cons = null;
		Statement stmt = null;
		ResultSet rs = null;
		//CARDNUM = PW.toString();
		
		try
		{
			Class.forName(driver);
			cons = DriverManager.getConnection(localhost,database_userID,database_passID);
			stmt = cons.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Card_Details");
			
			while(rs.next())
			{
				if (CARDNAME.equals(rs.getString(1))&&CARDNUM2.equals(rs.getString(2)) && CVV2.equals(rs.getString(3)) && METHOD.equals(rs.getString(4)) && MONTH.equals(rs.getString(5)) && YEAR==(rs.getInt(6)))
					validate=true;		
			}
		}	
		
		catch(Exception e)
		{
			System.out.println(e);
			validate = false;
		}
		return validate; 
	}
}

