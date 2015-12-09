package com.kenscio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		
		String email = request.getParameter("email");
		String pass  = request.getParameter("password");
		String name  = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver connected...");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","madan007");
			System.out.println("conected....");
			PreparedStatement ps=con.prepareStatement("insert into customer (username,password,emailid,phone) values(?,?,?,?)");
			
	        ps.setString(1, name);
	        ps.setString(2, pass);
	        ps.setString(3, email);
	        ps.setString(4, phone);
	        
	        int i=ps.executeUpdate();
	        
	        if(i > 0)
	        {
	        	out.println("Successfully registered...!!");
	        }
		}
		
		catch(SQLException e)
		
		{
			System.out.println("Exception " + e);
			
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Exception " + e);
		}
		
		
		
	}
	    
		
}
