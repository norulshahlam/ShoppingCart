package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class pdfController
 */
@WebServlet("/pdfController")
public class pdfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pdfController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 Date date = new Date();
		 int getYear = date.getYear();
		 int getMonth = date.getMonth();
		 int getDay = date.getDay();
		
		//Declaration of object
		   String getT_price = request.getParameter("price_T");
          String getH_price = request.getParameter("price_H");
          String getB_price = request.getParameter("price_B");
          
          
          
          String getT_quantity = request.getParameter("quantity_T");
          String getH_quantity = request.getParameter("quantity_H");
          String getB_quantity = request.getParameter("quantity_B");
          
          
          String getT_totalSales = request.getParameter("totalSales");
          String getQ_quantity = request.getParameter("TotalQuantity");
          String getP_percent = request.getParameter("Percentage");
          
          
		
		
		response.setContentType("application/pdf");
	    ServletOutputStream out=response.getOutputStream();
   
	    try {
           Document document = new Document();
           /* Basic PDF Creation inside servlet */
           //PdfWriter.getInstance(document, out);
           PdfWriter writer = PdfWriter.getInstance(document, out);
           document.open();
           
           
     
           
           Font bold = new Font(FontFamily.HELVETICA, 18, Font.UNDERLINE );
           Font normal = new Font(FontFamily.HELVETICA, 12 );
           Font footerContent = new Font(FontFamily.HELVETICA, 12, Font.ITALIC );
           
           Paragraph pdfHeader = new Paragraph("Monthly Report" , bold );
           Paragraph pdfFooter = new Paragraph("                                              Copyright @ By Lnt Infotect Shopping Cart                    " , footerContent );
           pdfHeader.setAlignment(Element.ALIGN_CENTER); 
           document.add(pdfHeader);
           document.add( Chunk.NEWLINE );
           
           Paragraph issuer = new Paragraph("Issued By : Lnt Infotect Shopping Cart PTE LTE");
           Paragraph issued = new Paragraph("Issued On : " + getDay +"/" + getMonth + "/" + getYear  , normal );
           Paragraph loremIpsum = new Paragraph("s a pseudo-Latin text used in web design, typography, layout, " +
           		"and printing in place of English to emphasise design elements over content. " +
           		"It's also called placeholder (or filler) text. It's a convenient tool for mock-ups. " +
           		"It helps to outline the visual elements of a document or presentation, eg typography, " +
           		"font, or layout. Lorem ipsum is mostly a part of a Latin text by the classical author and philosopher Cicero. " +
           		"Its words and letters have been changed by addition or removal, so to deliberately render its content nonsensical; it's not genuine, correct, or comprehensible Latin anymore. While lorem ipsum's still resembles classical Latin, it actually has no meaning whatsoever. As Cicero's text doesn't contain the letters K, W, or Z, alien to latin, these, and others are often inserted randomly to mimic the typographic appearence of European languages, as are digraphs not to be found in the original." +
           		", l");
           document.add(issuer);
           document.add(issued);
           document.add( Chunk.NEWLINE );
           
           PdfPTable table = new PdfPTable(3);
           
           table.addCell("Category");
           table.addCell("Sales");
           table.addCell("Quantity");
        
           String categoryName[] = {"Hat" , "T-Shirt" , "Bottom"};
           String price[] = {getH_price , getT_price , getB_price};
           String quantity[] = {getH_quantity ,getQ_quantity,getB_quantity };
           
           for(int i = 0; i < 3; i++){
           	  table.addCell(categoryName[i]);
                 table.addCell("$" + price[i]);
                 table.addCell(quantity[i]);
           }
           
           document.add(table);
           document.add( Chunk.NEWLINE );
      
           
           
             String footerPage = "<center><strong><bold>  Copyright @ Shopping Cart By US </storng></bold></center>";
             String homePageStyling = "<html>" +
             		"</head>" + "<body> " +
             		"<div id='chartContainer' style='height: 300px; width: 50%;'></div> <br/>" +
             		" Total Sales for this month is<bold>  : $" +  getT_totalSales + "</bold> <br/>" +
             		" Total Quantity Sold for this month is  :<bold> " + getQ_quantity + "</bold> <br/> " + 
             		" Percentage <bold> : " + getP_percent + "</bold> "+	
             		"</body>" +
             		"</html>";
             
             HTMLWorker htmlWorker = new HTMLWorker(document);
             htmlWorker.parse(new StringReader(homePageStyling));
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             
             document.add(loremIpsum);
             
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             document.add( Chunk.NEWLINE );
             /*--- Add Footer ---*/
             document.add(pdfFooter); 
             document.close();
           
           
 
           
           
           
           
       }
               catch (DocumentException exc){
               throw new IOException(exc.getMessage());
               }
       finally {            
           out.close();
       }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
