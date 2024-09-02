package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String no1str = request.getParameter("n1");
		String no2str = request.getParameter("n2");
		
		int no1 = Integer.parseInt(no1str);
		int no2 = Integer.parseInt(no2str);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("Addition: "+(no1+no2))
;		
		
	}
}
