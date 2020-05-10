package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.forgetQuery;

/**
 * Servlet implementation class forgetController
 */
@WebServlet("/forgetController")
public class forgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String emailid = (request.getParameter("emailAdd"));
		 PrintWriter pw = response.getWriter();
		 
		 
		 /*-- Call forget pasword if its valid or not --*/
		 forgetQuery fq1 = new forgetQuery();
		 String forgetRS = fq1.forgetQuery(emailid);
		 System.out.println(forgetRS);
		 if (forgetRS.equals("invalid"))
		 {
			 pw.println("Please enter an existing email address.");
		 }
		 
		 
		 else
		 {
			 pw.println("Your new password is: "+forgetRS+".");
			 pw.println("Please login with your new password and change your password as soon as possible.");
			 pw.println("<form action='Pages/Login/login.jsp' method='Get'> ");
		     pw.println("<input type='submit' value='Login'>");			 
		 }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
