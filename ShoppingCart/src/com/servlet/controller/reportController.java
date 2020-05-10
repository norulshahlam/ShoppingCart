package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.function.reportAction;

/**
 * Servlet implementation class reportController
 */
@WebServlet("/reportController")
public class reportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("reportView.jsp");
		//PrintWriter pw = response.getWriter();
		//pw.println("success");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
PrintWriter pw = response.getWriter();
		
		//convert to int 
		int cc_month = Integer.parseInt(request.getParameter("Month"));
		int cc_year = Integer.parseInt(request.getParameter("years"));
		
		
		//Getting total Values
		reportAction ra = new reportAction();
		int getSum_T = ra.getTShirt(cc_year,cc_month);
		int getSum_H = ra.getHat(cc_year, cc_month);
		int getSum_B = ra.getBottom(cc_year, cc_month);
		
		
		//getting Quantity Sold
		int getQuantity_T =  ra.getQuantiy_TShirt(cc_year, cc_month);
		int getQuantity_H = ra.getQuantiy_Hat(cc_year, cc_month);
		int getQuantity_B = ra.getQuantiy_Bottom(cc_year, cc_month);
		
		
		// Calling Method to call to View Page
		request.setAttribute("quantity_Tshirt", getQuantity_T);
		request.setAttribute("quantity_Hat", getQuantity_H);
		request.setAttribute("quantity_Bottom", getQuantity_B);
		
		
		//Do calculation Total sales & Total Quantity
		double totalSales = getSum_T + getSum_H + getSum_B;
		int totalQuantity = getQuantity_T + getQuantity_H + getQuantity_B;
		
		
		if(request.getParameter("targetSales") != null && !request.getParameter("targetSales").isEmpty()){
			double cc_target = Double.parseDouble(request.getParameter("targetSales"));
			System.out.println(cc_target + " Converted percent ");
			double f_percent = (totalSales / cc_target) * 100;
			double f_percentRound = Math.round(f_percent*100)/100;

			System.out.println("division" + " cc_percent " + cc_target + " f_percent " + f_percent);
			request.setAttribute("percent",  f_percentRound + "%");
		}
	
		
		//set to request
		request.setAttribute("totalSales", totalSales);
		request.setAttribute("totalQuantity", totalQuantity);
		request.setAttribute("category_Tshirt", getSum_T);
		request.setAttribute("category_Hat", getSum_H);
		request.setAttribute("category_Bottom", getSum_B);
		request.getRequestDispatcher("/reportView.jsp").forward(request, response);
		//response.sendRedirect("reportView.jsp");
	}

}
