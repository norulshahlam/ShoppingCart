package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.profile.ProfileAction;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfilePath")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String Customer_Name = req.getParameter("CustName");
		String Password = req.getParameter("CustPassword");
		
		if(Password.equals(""))
		{
			Password = null;
		}
		String Email = req.getParameter("CustEmail");
		String Gender = req.getParameter("CustGender");
		String DOB = req.getParameter("CustDOB");	
		int Contact_1 = Integer.parseInt(req.getParameter("CustContact_1"));
		int Contact_2 = Integer.parseInt(req.getParameter("CustContact_2"));
		String Payment_Method = req.getParameter("CustPayment_Method");
		String Address_1 = req.getParameter("CustAddress_1");
		String Address_2 = req.getParameter("CustAddress_2");
		
		HttpSession session=req.getSession(false);  
		String Username =(String)session.getAttribute("Username");
		
		ProfileAction PL = new ProfileAction();
		PL.UpdateProfile(Customer_Name,Username,Password,Email,Gender,DOB,Contact_1,Contact_2,Payment_Method,Address_1,Address_2);

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("Account successfully updated.");
		pw.println("<form action='Pages/UI/index.jsp' method='Get'> ");
		pw.println("<input type='submit' value='Back to index'>");
		pw.println("</form>");
        pw.println("</body>");
        pw.println("</html> ");
	}
}

