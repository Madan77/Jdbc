package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

public class Welcome extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		RequestDispatcher rd1 = request.getRequestDispatcher("html/firstpage.html");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
		HttpSession s = request.getSession();
        String name = (String)s.getAttribute("user");
        out.println("hello"+""+name);
		rd1.forward(request, response);
		}
		finally
		{
			out.close();
		}
	}
}

