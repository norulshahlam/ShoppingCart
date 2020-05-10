package com.servlet.controller;
import com.jdbc.*;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCartItem
 */
@WebServlet(name = "addCartItem", urlPatterns = { "/addCartItem" })
public class AddCartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartItemController() {
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
		String pqty = request.getParameter("qty");		
		String id = request.getParameter("prodId");
		int productId = Integer.parseInt(id);
		int qty = Integer.parseInt(pqty);
		boolean isAddCart = false;
		
		int cartID = CartDAO.getCartIdByCust(cust_name);
		
		try{
			isAddCart = CartDAO.addCartItem(cartID, productId, qty);
			
			if(isAddCart == true){
				
				System.out.println("Product item has been added to your cart!");
				response.sendRedirect("Pages/Cart/ViewCart.jsp?CustUsername=" + cust_name);
			
			}
			else if(isAddCart == false){
				System.out.println("Failed to add product item to your cart!");
			}
			else{
				System.out.println("No action occurred!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
