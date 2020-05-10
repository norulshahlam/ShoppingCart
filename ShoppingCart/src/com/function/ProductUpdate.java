package com.function;

import java.io.IOException;
import java.io.PrintWriter;
import com.model.ProductsTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductUpdate
 */
@WebServlet("/ProductUpdate")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProductUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pID = Integer.parseInt(request.getParameter("pid"));
		String up = request.getParameter("btnUpdt");
		String dl = request.getParameter("btnDlte");
		PrintWriter out = response.getWriter();
		boolean stat = false;
		
		if(dl != null){
			ProductsTable pt = new ProductsTable();
			stat = pt.delProduct(pID);
			if(stat){
				response.sendRedirect("ManagementMain.jsp");
			}else{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('There's an issue!.');");
			    out.println("window.location = 'ManagementMain.jsp';");
			    out.println("</script>");
			}			
		}else if (up != null){
			System.out.println("Update was clicked");
			response.sendRedirect("ManagementMain.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
