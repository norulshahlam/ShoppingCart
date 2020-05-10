package com.function;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.BrandsTable;

/**
 * Servlet implementation class BrandUpdate
 */
@WebServlet("/BrandUpdate")
public class BrandUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BrandUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid = Integer.parseInt(request.getParameter("bid"));
		String up = request.getParameter("btnUpdt");
		String dl = request.getParameter("btnDlte");
		PrintWriter out = response.getWriter();
		boolean stat = false;
		
		if(dl != null){
			System.out.println("delete was clicked!");
			BrandsTable bt = new BrandsTable();
			stat = bt.delBrand(bid);
			if(stat){
				response.sendRedirect("ManagementMain.jsp");
			}else{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('There's an issue!.');");
			    out.println("window.location = 'ManagementMain.jsp';");
			    out.println("</script>");
			}
			
			
		}else if(up != null){
			System.out.println("Update was clicked");
			response.sendRedirect("ManagementMain.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
