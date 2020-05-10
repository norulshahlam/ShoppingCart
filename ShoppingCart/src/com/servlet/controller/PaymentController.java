package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jdbc.paymentQuery;


@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PaymentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		boolean validation=false;
		System.out.println(validation);
			
		String CARDNAME = request.getParameter("CARDNAME"); /*Declaring Session */
		String CARDNUM = request.getParameter("CARDNUM");	 /*Declaring GetParameters for username , password */
		String CVV = request.getParameter("CVV");
		String METHOD = request.getParameter("method");
		String MONTH = request.getParameter("MONTH");
		int YEAR = Integer.parseInt(request.getParameter("YEAR"));	
		System.out.println("In controller\nCARDNAME: " +CARDNAME + "\nCARDNUM: " +CARDNUM + "\nCVV: " +CVV+ "\nMethod " +METHOD+ "\nMONTH " +MONTH+ "\nYEAR " +YEAR);

		paymentQuery a1 = new paymentQuery();

		try 
		{
			HttpSession session = request.getSession(false);
			int loginAttempts=0;
			validation=a1.callpaymentQuery(CARDNAME, CARDNUM, CVV, METHOD, MONTH, YEAR);

			if(validation)
			{
				pw.println("<h1>PAYMENT SUCCESSFUL</h1>");
				System.out.println("PAYMENT SUCCESSFUL");
			}

			if(!validation)
			{
				pw.println("<h1>PAYMENT FAILED</h1>");
				System.out.println("PAYMENT FAILED");
			}
				   
			System.out.println(validation);
			   
		}
			
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			 }
		}
}
