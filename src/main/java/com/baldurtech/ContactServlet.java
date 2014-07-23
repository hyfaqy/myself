package com.baldurtech;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{

		response.getWriter().println("Contact");
		
	}
}