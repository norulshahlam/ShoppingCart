package com.function;

import java.security.MessageDigest;

public class Security {
	
	public StringBuilder Convert(String password)
    {
		try
		{
	        MessageDigest md = MessageDigest.getInstance("SHA-1");
	        md.update(password.getBytes());
	
	        byte byteData[] = md.digest();
	
	        //convert the byte to hex format method 
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < byteData.length; i++) 
	        {
	        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb;
		}
		catch (Exception e)
		{
			StringBuilder sb=new StringBuilder("Null");  
			System.out.println(e);
			return sb;
		}
    }

}
