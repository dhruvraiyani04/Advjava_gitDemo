package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveProductServlet")
public class SaveProductServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read
		String productName = request.getParameter("productName");
		Integer price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		Integer qty = Integer.parseInt(request.getParameter("qty"));

		// validation {filter##,servlet}

		// db insert
		try {

			// driver load - memory
			Class.forName("com.mysql.cj.jdbc.Driver");

			// open conection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/24advgen", "root",
					"root");
			// query -> run -> PreparedStatement

			// insert into products (productName,proce,category,qty) values ();
			PreparedStatement pstmt = con.prepareStatement("insert into products (productName,price,category,qty) values (?,?,?,?)");
			pstmt.setString(1, productName);
			pstmt.setInt(2, price);
			pstmt.setString(3, category);
			pstmt.setInt(4, qty);

			// run -> executeUpdate()
			 int record = pstmt.executeUpdate();
			 
			 if(record == 0) {
				 System.out.println("no add");
			 }else {
				 System.out.println("product added");
			 }
			 
			 RequestDispatcher rd = request.getRequestDispatcher("InputProduct.jsp");
			 rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// bye
	}
}