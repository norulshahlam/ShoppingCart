package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.Feedback;

/**
 * Servlet implementation class PersonalFeedback
 */
@WebServlet("/ProductFeedbackPath")
public class ProductFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		HttpSession session=req.getSession(false);  
		String Username =(String)session.getAttribute("Username"); 
		
		String Rating = req.getParameter("Rating");
		String Product_Feedback = req.getParameter("Product_Feedback");
		
		Feedback FL = new Feedback();
		FL.UpdateProductFeedback(Username,Rating,Product_Feedback);
		
		pw.println("<center>Thank you for your feedback.");
		pw.println("We look forward to serving you again.</center>");
		pw.println("<form action='main.jsp' ");
		pw.println("<input type='submit' value='Back to main page'>");
		pw.println("</form>");
	}

}
