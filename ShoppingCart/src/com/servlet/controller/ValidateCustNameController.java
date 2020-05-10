package com.servlet.controller;
import com.jdbc.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCustName
 */
@WebServlet(name = "validateCustName", urlPatterns = { "/validateCustName" })
public class ValidateCustNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCustNameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isValidCustomer;
		PrintWriter pw = response.getWriter();
		String cust_name = request.getParameter("CustUsername");
		
		try{
			isValidCustomer = CartDAO.checkCustName(cust_name);
			
			if(isValidCustomer == true){
				System.out.println("Customer username exists in database!");
				response.sendRedirect("jsp/ViewCart.jsp?CustUsername=" + cust_name);
			}
			else if(isValidCustomer == false){
				System.out.println("Failed to find customer username in database!");
				
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Error! This customer username doesnt exist in our system!');");
				pw.println("</script>");
			}
			else{
				System.out.println("No event occurred!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
