package com.servlet.controller;
import com.jdbc.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCartItem
 */
@WebServlet(name = "deleteCartItem", urlPatterns = { "/deleteCartItem" })
public class DeleteCartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartItemController() {
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
		// TODO Auto-generated method stub
		
		String cust_name = request.getParameter("custName");
		String id = request.getParameter("prodId");
		int productId = Integer.parseInt(id);
		boolean isDeleted = false;
		System.out.println("cust name and prodid " + cust_name + " " + productId);
		
		int cartID = CartDAO.getCartIdByCust(cust_name);
		
		try{
			isDeleted = CartDAO.deleteCartItem(cartID, productId);
			
			if(isDeleted == true){
				System.out.println("Cart Item has been successfully deleted!");
				   
				   response.sendRedirect("Pages/Cart/ViewCart.jsp?CustUsername=" + cust_name);
				
			}
			else if(isDeleted == false){
				System.out.println("Failed to delete cart item from cart items table!");
				response.sendRedirect("Pages/Cart/ViewProduct.jsp");
			}
			else{
				System.out.println("No action occurred!");
				//send back to home page
				//response.sendRedirect("");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
