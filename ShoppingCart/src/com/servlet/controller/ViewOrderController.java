package com.servlet.controller;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.ViewOrderQuery;

@WebServlet("/ViewOrderController")

public class ViewOrderController extends HttpServlet {
private static final long serialVersionUID = 1L;
private ServletResponse res;   
   
public ViewOrderController() 
{
	super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	PrintWriter pw = response.getWriter();
	HttpSession session=request.getSession(false);  
	int CustID =(Integer)session.getAttribute("customer_id");	
	List<ViewOrderQuery> list = ViewOrderQuery.getOrder(CustID);	
	int val = ViewOrderQuery.results();
	
	if(list.isEmpty())
	{
		request.getRequestDispatcher("/Pages/ViewOrder/ViewOrderNoResults.jsp").forward(request, response);
	}
	else
	{
		request.setAttribute("posts", list);
		request.getRequestDispatcher("/Pages/ViewOrder/ViewOrderResults.jsp").forward(request, response);
	}
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
