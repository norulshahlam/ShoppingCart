package com.servlet.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.function.forgetAction;
import com.function.loginValidation;
import com.jdbc.loginQuery;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
private static final long serialVersionUID = 1L;
public loginController() {super();}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* Declaring Session */
		String user_sessionID = new String("userID");
		/* Declaring GetParameters for username , password */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("emailAdd");
		Boolean checkedBox = request.getParameter("remember") != null;
		String loginRS = loginValidation.login(username, password);
		loginQuery lq = new loginQuery();

		// Save Password cookies
		if (checkedBox) 
		{
			Cookie ck_username = new Cookie("us_ck", username);
			/*---Set age to 1hours 60sec * 60 sec ---*/
			ck_username.setMaxAge(60 * 60);
			response.addCookie(ck_username);
		}
		
		if (loginRS.equals("user")) 
		{
			HttpSession session = request.getSession(true);	
			int customer_id = lq.getCustomer_id(username);
			session.setAttribute("customer_id", customer_id);
			session.setAttribute("Username", username);
			response.sendRedirect("Pages/UI/index.jsp");	
		}
		
		else if (loginRS.equals("admin")) 
		{
			HttpSession session  = request.getSession(true);
			session.setAttribute("Username", username);
			response.sendRedirect("Pages/Admin/ManagementMain.jsp");
		} 
		
		else 
		{
			HttpSession session = request.getSession(true);
			HttpSession session_Newusername = request.getSession(true);
			session.setAttribute("Username", username);
			String session_Username = (String)session.getAttribute("Username");
			System.out.println(" data .... " + session_Username);
			
		int loginAttempt;
		
		if(session.getAttribute("loginCount") == null)
		{
			session.setAttribute("loginCount", 0);
			loginAttempt = 0;
		} 
		else if(session_Username.equals("farid")) 
		{
			System.out.println("If user key in same username");
			loginAttempt = (Integer)session.getAttribute("loginCount");
			
		if(loginAttempt  == 3)
		{ 
			session.setMaxInactiveInterval(5);
			session.setAttribute("message", "Your account is blocked, Please contact admin or wait for 2mins");
			response.sendRedirect("Pages/Login/login.jsp");
		} 
			
		else 
		{
			System.out.println("How many attempt left " + loginAttempt);
			loginAttempt++;
			int leftAttempt = 4 - loginAttempt;
			session.setAttribute("message", "You are left with " + leftAttempt + " attempt");
			response.sendRedirect("Pages/Login/login.jsp");
		}
		session.setAttribute("loginCount", loginAttempt);
	} 
		else 
		{
			response.sendRedirect("Pages/Login/login.jsp");
			session.invalidate();
		}
	}
}
}
