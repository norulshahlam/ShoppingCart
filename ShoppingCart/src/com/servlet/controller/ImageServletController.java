package com.servlet.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet({ "/ImageServlet", "/imageServlet" })
public class ImageServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int prodNo = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println("prod name " + prodNo);

			final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		    final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
		    final String User = "scott";
		    final String Password = "tiger";
		    try {
		        Class.forName(JDBC_DRIVER);
		        Connection conn = DriverManager.getConnection(DB_URL, User, Password);

		        PreparedStatement pstmt = conn.prepareStatement("SELECT ImgBlob FROM DummyImg WHERE ProductId=?");
		        //pstmt.setLong(1, Long.valueOf(request.getParameter("id")));

		        pstmt.setInt(1, prodNo);
		        ResultSet rs = pstmt.executeQuery();
		        if (rs.next()) {
		            response.getOutputStream().write(rs.getBytes("ImgBlob"));
		
		        }
		        conn.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

}
