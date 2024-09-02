package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateAgeServlet")
public class CalculateAgeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String
		String bYearStr = request.getParameter("birthYear");

		// blank ? space ? null ?
		boolean isError = false; // no Error
		String error = "";
		// required
		if (bYearStr == null || bYearStr.trim().length() == 0) {
//			 blank ? space ? null 
			isError = true;
			error = "Please Enter BirthYear";
		} else if (bYearStr.matches("[0-9]{4}") == false) {
			isError = true;
			error = "Please Enter Valid BirthYear!!";
		}

		if (isError == true) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(error);
		} else {

			Integer birthYear = Integer.parseInt(bYearStr);
			Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);

			if (birthYear >= 1924 && birthYear <= 2023) {

				Integer age = currentYear - birthYear;
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print(age);
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Please Enter Valid BirthYear");
			}

		}

	}
}