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

import com.jdbc.ViewHistoryQuery;

@WebServlet("/ViewHistoryController")

public class ViewHistoryController extends HttpServlet {
private static final long serialVersionUID = 1L;
private ServletResponse res;   
   
public ViewHistoryController() 
{
	super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	PrintWriter pw = response.getWriter();
	HttpSession session=request.getSession(false);  
	int CustID =(Integer)session.getAttribute("customer_id");
	List<ViewHistoryQuery> list = ViewHistoryQuery.getHistory(CustID);
	int val = ViewHistoryQuery.results();
	
	if(list.isEmpty())
	{
		response.sendRedirect("Pages/ViewHistory/ViewHistoryNoResults.jsp");
		//request.getRequestDispatcher("/Pages/ViewHistory/ViewHistoryNoResults.jsp").forward(request, response);
	}
	else
	{
		response.sendRedirect("Pages/ViewHistory/ViewHistoryResults.jsp");
		//request.setAttribute("posts", list);
		//request.getRequestDispatcher("/Pages/ViewHistory/ViewHistoryResults.jsp").forward(request, response);
	}
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
