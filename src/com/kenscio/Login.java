package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd1 = request.getRequestDispatcher("/Welcome");
		try
		{
			String email = request.getParameter("name");
			String pass = request.getParameter("password");
			
			if(Validate.checkUser(email,pass))
			{
				HttpSession session = request.getSession();
	            session.setAttribute("user",email);
	            rd1.forward(request, response);
	            
			}
			
			else
			{
				out.println("Incorrect username or password");
				RequestDispatcher rd2 = request.getRequestDispatcher("html/login.html");
				rd2.include(request, response);
			}
		}
		finally
		{
			out.close();
		}
		
	}

}
