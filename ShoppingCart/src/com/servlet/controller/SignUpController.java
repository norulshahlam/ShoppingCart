package com.servlet.controller;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.function.Security;
import com.signup.SignupLogic;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public SignUpController() 
    {
    	super();
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String Name = req.getParameter("Name");
		String Email = req.getParameter("Email");
		String Username = req.getParameter("Username");
		String Password = req.getParameter("Password");
		SignupLogic SL1 = new SignupLogic(Username, Password, Name, Email);
		SL1.main();
		
		if (SL1.CheckUser() == true)
		{
			res.sendRedirect("Pages/Signin/signup_fail.jsp");   
		}
		
		else 
		{
			if (SL1.CheckPassword() == true)
			{
				res.sendRedirect("Pages/Signin/signup_passwordweak.jsp"); 			
			}
		
			else
			{
				if (SL1.CheckEmail() == true)
				{		
					res.sendRedirect("Pages/Signin/signup_fail.jsp");  				
				}
				
				else
				{
					if (SL1.CheckUser() == false && SL1.CheckPassword() == false && SL1.CheckEmail() == false)
					{
						// Enter the details of the new account into the database //
						SL1.NewSignUp(Username,Password,Name,Email);
						try
						{			
							HttpSession session  = req.getSession(true);
							session.setAttribute("Username", Username);
							
							pw.println("<p> Account is created successfully. Please fill in your personal details. </p>");
							pw.println("<form action='Pages/Profile/EditFirstProfile.jsp'><input type='submit' value='Edit details'></form>");
							pw.println("<p>Return to Main page</p>");
							pw.println("<form action='Pages/UI/index.jsp'><input type='submit' value='Go to Main Page'></form>");
						}
			
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
			
			
			
		
