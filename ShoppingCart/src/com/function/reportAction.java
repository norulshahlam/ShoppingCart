package com.function;

import com.jdbc.quantityQuery;
import com.jdbc.reportQuery;

public class reportAction {
	
	private static int sumValue;

	
	   // -----  Get total sales Amount ----	
		public static int getTShirt(int year , int month){
			
			reportQuery rq1 = new reportQuery();
			sumValue = rq1.reportQuery("t-shirt" , year , month);
			return sumValue;
		}
		
		
		public static int getHat(int year , int month){
			reportQuery rq1 = new reportQuery();
			sumValue = rq1.reportQuery("hat" , year , month);
			return sumValue;
		}
		
		public static int getBottom(int year , int month){
			reportQuery rq1 = new reportQuery();
			sumValue = rq1.reportQuery("bottom" , year , month);
			return sumValue;
		}
		
		
		// --- Get Quantity from each Category at qunatityQuery ---- 
		
		public static int getQuantiy_TShirt(int year , int month){
			quantityQuery qq = new quantityQuery();
			sumValue = qq.quantitytQuery("t-shirt" , year , month);
			return sumValue;
		}
		
		public static int getQuantiy_Hat(int year , int month){
			quantityQuery qq = new quantityQuery();
			sumValue = qq.quantitytQuery("hat" , year , month);
			return sumValue;
		}
		
		public static int getQuantiy_Bottom(int year , int month){
			quantityQuery qq = new quantityQuery();
			sumValue = qq.quantitytQuery("bottom" , year , month);
			return sumValue;
		}
}
