package com.servlet.controller;
import com.profile.ProfileAction;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class 
 */
@WebServlet("/ProfileControllerPath")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		HttpSession session=req.getSession(false);  
		String Username =(String)session.getAttribute("Username");

		/* Cookies method 
		Cookie ck[] = req.getCookies();
		Cookie ck1[] = req.getCookies();
		int CustID = Integer.parseInt(ck[0].getValue());
		String CustUserName = ck1[0].getValue();  */
		
		ProfileAction PL = new ProfileAction();
		PL.DisplayProfile(Username);
		int Cust_ID = PL.getCustomer_ID();
		String CustName = PL.getCustomer_Name();
		String CustUserName = Username;
		String CustPassword = PL.getPassword();
		String CustEmail = PL.getEmail();
		String CustGender = PL.getGender();
		Date CustDOB = PL.getDOB();
		int CustContact_1 = PL.getContact_1();
		int CustContact_2 = PL.getContact_2();
		String CustPayment_Method = PL.getPayment_Method();
		String CustAddress_1 = PL.getAddress_1();
		String CustAddress_2 = PL.getAddress_2();	
		
		req.setAttribute("Cust_ID", Cust_ID);
		req.setAttribute("CustName", CustName);
		req.setAttribute("CustUserName", CustUserName);
		req.setAttribute("CustPassword", CustPassword);
		req.setAttribute("CustEmail", CustEmail);
		req.setAttribute("CustGender", CustGender);
		req.setAttribute("CustDOB", CustDOB);
		req.setAttribute("CustContact_1", CustContact_1);
		req.setAttribute("CustContact_2", CustContact_2);
		req.setAttribute("CustPayment_Method", CustPayment_Method);
		req.setAttribute("CustAddress_1", CustAddress_1);
		req.setAttribute("CustAddress_2", CustAddress_2);
		req.getServletContext().getRequestDispatcher("/Pages/Profile/ShowProfile.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
		PrintWriter pw = res.getWriter();
	    res.setContentType("text/html");
		
		/* Cookies method
		Cookie ck[] = req.getCookies();
		Cookie ck1[] = req.getCookies();
		int CustID = Integer.parseInt(ck[0].getValue());
		String CustUserName = ck1[0].getValue();   */
		
		HttpSession session=req.getSession(false);  
		String CustUserName =(String)session.getAttribute("Username");
		ProfileAction PL = new ProfileAction();
		PL.DisplayProfile(CustUserName);
		
		try
		{
			int Cust_ID = PL.getCustomer_ID();
			String CustName = PL.getCustomer_Name();
			String CustPassword = PL.getPassword();
			String CustEmail = PL.getEmail();
			String CustGender = PL.getGender();
			Date CustDOB = PL.getDOB();
			int CustContact_1 = PL.getContact_1();
			int CustContact_2 = PL.getContact_2();
			String CustPayment_Method = PL.getPayment_Method();
			String CustAddress_1 = PL.getAddress_1();
			String CustAddress_2 = PL.getAddress_2();	
			
			req.setAttribute("Cust_ID", Cust_ID);
			req.setAttribute("CustName", CustName);
			req.setAttribute("CustUserName", CustUserName);
			req.setAttribute("CustPassword", CustPassword);
			req.setAttribute("CustEmail", CustEmail);
			req.setAttribute("CustGender", CustGender);
			req.setAttribute("CustDOB", CustDOB);
			req.setAttribute("CustContact_1", CustContact_1);
			req.setAttribute("CustContact_2", CustContact_2);
			req.setAttribute("CustPayment_Method", CustPayment_Method);
			req.setAttribute("CustAddress_1", CustAddress_1);
			req.setAttribute("CustAddress_2", CustAddress_2);
			req.getRequestDispatcher("/Pages/Profile/EditProfile.jsp").forward(req, res);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
