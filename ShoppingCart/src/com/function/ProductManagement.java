package com.function;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.ProductsTable;

@WebServlet("/ProductManagement")
@MultipartConfig(maxFileSize = 3617721)
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductManagement() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int pID = Integer.parseInt(request.getParameter("pid"));
			ProductsTable pt = new ProductsTable();
			
			response.getOutputStream().write(pt.getPimage(pID));				
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("product_name");
		String pdesc = request.getParameter("product_desc");
		String price = request.getParameter("product_price");
		System.out.println(pname);
		double pPrice = Double.parseDouble(price); 
		int pQuantity = Integer.parseInt(request.getParameter("product_Qnty"));
		int pBrandID = Integer.parseInt(request.getParameter("Sbrand"));
		int pCategoryID = Integer.parseInt(request.getParameter("SCat"));
		int pSubCategoryID = Integer.parseInt(request.getParameter("SsubCat"));
		
		InputStream iStream = null;
		Part filePart = request.getPart("pImg");
		PrintWriter out = response.getWriter();
		if(filePart != null)
		{
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());			
			iStream = filePart.getInputStream();
			
			ProductsTable pt = new ProductsTable();
			pt.insertProduct(pname, pdesc, pPrice, pQuantity, pBrandID, pCategoryID, pSubCategoryID, iStream);
			
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Product Successfully Added! HURRAY!!');");
		    out.println("window.location='Pages/Admin/ManagementMain.jsp';");
		    out.println("</script>");
		}
		else 
			response.sendRedirect("http://www.google.com.sg/");		
	}

}
