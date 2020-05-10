package com.function;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CategoryTable;


@WebServlet("/CategoryManagement")
public class CategoryManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CategoryManagement() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status = "";
		String Category = request.getParameter("txtCategory");
		String SubCate = request.getParameter("txtSubCat");
		PrintWriter out = response.getWriter();
		CategoryTable ct = new CategoryTable();
		
		if(Category == "" || Category.trim()== ""){
		  	out.println("<script type=\"text/javascript\">");
		    out.println("alert('Category should not be empty, please try again');");
		    out.println("window.location = 'Pages/AdminCategory/AddingCategory.jsp';");
		    out.println("</script>");
		}
		else if (Category != null && SubCate == "" || SubCate.trim() == ""){
			status = ct.insertCategory(Category);
			if(status == "Successful"){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Category Successfully Added.');");
			    out.println("window.location = 'Pages/Admin/ManagementMain.jsp';");
			    out.println("</script>");
			}else{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('"+status.trim()+"');");
			    out.println("window.location = 'Pages/AdminCategory/AddingCategory.jsp';");
			    out.println("</script>");
			}			
		}
		else if (Category != null && SubCate!= null){
			status = ct.insertCat_Sub(Category, SubCate);
			if(status == "Successful"){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Category & Sub-Category Successfully Added.');");
			    out.println("window.location = 'ManagementMain.jsp';");
			    out.println("</script>");
			}else{
				System.out.println("All fields with issue");
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('"+status.trim()+"');");
			    out.println("window.location = 'Pages/AdminCategory/AddingCategory.jsp';");
			    out.println("</script>");
			}
			
		}
		else if(SubCate == null || SubCate.trim()== null){
			
			status = ct.insertCategory(Category);
			if (status == "Successful"){
				System.out.println("Only Category is filled up!");
				response.sendRedirect("Pages/Admin/ManagementMain.jsp");
			}else{
				System.out.println("No Sub-Category field with issue");
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('"+ status +"');");
			    out.println("window.location = 'Pages/AdminCategory/AddingCategory.jsp';");
			    out.println("</script>");
			}				
		}
		
	}

		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
