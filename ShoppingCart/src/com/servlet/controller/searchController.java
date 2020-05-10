package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.ViewHistoryQuery;
import com.search.SearchQuery;

/**
 * Servlet implementation class searchController
 */
@WebServlet("/searchControllerPath")
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String keyword = req.getParameter("searchBar");
		List<SearchQuery> list = SearchQuery.SearchItem(keyword);
		if(list.isEmpty())
		{
			res.sendRedirect("Pages/UI/DisplayNoProducts.jsp");
			
			//req.getServletContext().getRequestDispatcher("/Pages/UI/index.jsp").forward(req, res);
			//req.getServletContext().getRequestDispatcher("/Pages/UI/DisplayNoProducts.jsp").forward(req, res);
		}
		
		else
		{
			req.setAttribute("search", list);
			req.getServletContext().getRequestDispatcher("/Pages/UI/DisplayProducts.jsp").forward(req, res);
		}
	}

}
