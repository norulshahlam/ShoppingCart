package com.function;

import com.model.AdminTable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminManagement
 */
@WebServlet("/AdminManagement")
public class AdminManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean status;
		
		String user = request.getParameter("usernme");
		String pass = request.getParameter("passwrd");
		AdminTable ad1 = new AdminTable(user,pass);
		status=ad1.adminLog();
		
		if(status==true)
		{
			System.out.println("You are the rightful user!");
			response.sendRedirect("ManagementMain.jsp");
		}
		else
		{	
			System.out.println("NOT!!");
			request.setAttribute("stats",true);
			//request.getRequestDispatcher("ManagementPage.jsp").forward(request,response);
			
			response.sendRedirect("ManagementPage.jsp");		
		}
	}

}
