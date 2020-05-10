package com.servlet.controller;
import com.jdbc.*
;

import com.function.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/updateCart")
public class updateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custName = request.getParameter("custName");
		int productID = Integer.parseInt(request.getParameter("prodId"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		boolean isUpdate = false;
		
		System.out.println(custName +" "+ productID +" "+ quantity);
		
		int cartID = CartDAO.getCartIdByCust(custName);
		
		try{
			isUpdate = CartDAO.updateCartItem(quantity, cartID, productID);
			
			if(isUpdate == true){
				System.out.println("Update Cart Item is a success!");
				response.sendRedirect("Pages/Cart/ViewCart.jsp?CustUsername=" + custName);
			}
			else if(isUpdate == false){
				System.out.println("Failed to update cart item! Try again!");
			}
			else{
				System.out.println("No action occurred!");
			}
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
		//response.sendRedirect("http://www.google.com.sg/");
	}

}
