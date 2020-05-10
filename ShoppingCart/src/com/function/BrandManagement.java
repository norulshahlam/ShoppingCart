package com.function;
import com.model.*;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class BrandManagement
 */
@WebServlet("/BrandManagement")
@MultipartConfig(maxFileSize = 16177215)   // upload file's size up to 16MB
public class BrandManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrandManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bID = Integer.parseInt(request.getParameter("bid"));	
		BrandsTable bt1 = new BrandsTable();
		bt1.getBImage(bID);
		
		response.getOutputStream().write(bt1.getBImage(bID));
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Bname = request.getParameter("txtName");
		String Bdesc = request.getParameter("brand_desc");
		PrintWriter out = response.getWriter();
		InputStream iStream = null;
		
		
		Part filePart = request.getPart("bImg");
		if(filePart != null)
		{
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());			
			iStream = filePart.getInputStream();
			
			BrandsTable bt = new BrandsTable(Bname,Bdesc,iStream);
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('This Brand have been Successfully Added.');");
		    out.println("window.location = 'Pages/Admin/ManagementMain.jsp';");
		    out.println("</script>");
		}
		else 
			response.sendRedirect("http://www.google.com.sg/");
	}

}
