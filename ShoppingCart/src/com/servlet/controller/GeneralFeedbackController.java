package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.Feedback;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/GeneralFeedbackPath")
public class GeneralFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneralFeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Customer_Name = req.getParameter("Full Name");
		String email = req.getParameter("email");
		int Contact_Number = Integer.parseInt(req.getParameter("Contact Number"));
		String Feedback_Category = req.getParameter("Feedback_category");
		String Feedback = req.getParameter("Feedback");
		
		Feedback FL = new Feedback();
		FL.UpdateGeneralFeedback(Customer_Name,Contact_Number,Feedback_Category,Feedback);	
		pw.println("<center>Thank you for your feedback.");
		pw.println("<br>We will get in touch with you soon.");
		pw.println("<br>Happy shopping with LTI!</center>");
		pw.println("<form action='main.jsp' ");
		pw.println("<input type='submit' value='Back to main page'>");
		pw.println("</form>");
	}
}
