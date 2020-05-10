package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.profile.ProfileAction;

/**
 * Servlet implementation class UpdateFirstProfileController
 */
@WebServlet("/UpdateFirstProfilePath")
public class UpdateFirstProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFirstProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String Customer_Name = req.getParameter("CustName");
		String Password = req.getParameter("CustPassword");
		String Email = req.getParameter("CustEmail");
		String Gender = req.getParameter("CustGender");
		String DOBstr = req.getParameter("CustDOB");
		
		try
		{
			int Contact_1 = Integer.parseInt(req.getParameter("CustContact_1"));
			int Contact_2 = Integer.parseInt(req.getParameter("CustContact_2"));
			String Payment_Method = req.getParameter("CustPayment_Method");
			String Address_1 = req.getParameter("CustAddress_1");
			String Address_2 = req.getParameter("CustAddress_2");
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = sdf1.parse(DOBstr);
			java.sql.Date DOB = new java.sql.Date(date.getTime());
			
			HttpSession session=req.getSession(false);  
			String Username =(String)session.getAttribute("Username");
			
			ProfileAction PL = new ProfileAction();
			PL.CreateProfile(Customer_Name,Username,Password,Email,Gender,DOB,Contact_1,Contact_2,Payment_Method,Address_1,Address_2);
			
			int Customer_ID = PL.getCustomer_ID();
			session.setAttribute("customer_id", Customer_ID);
			
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
			pw.println("<html>");
			pw.println("<head>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("Account successfully updated.");
			pw.println("<form action='Pages/UI/index.jsp' method='Get'> ");
			pw.println("<input type='submit' value='Main Menu'>");
			pw.println("</form>");
	        pw.println("</body>");
	        pw.println("</html> ");
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
}
