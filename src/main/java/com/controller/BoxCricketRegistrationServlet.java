package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoxCricketRegistrationServlet")
public class BoxCricketRegistrationServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentName = request.getParameter("studentName");
		String playerType = request.getParameter("playerType");

		request.setAttribute("studentNameValue", studentName);
		request.setAttribute("playerTypeValue", playerType);

		// required

		boolean isError = false; // no error

		if (studentName == null || studentName.trim().length() == 0) {
			request.setAttribute("studentNameError", "Please Enter Student Name");// set error for jsp
			isError = true;
		} else {
			// studentName is present !!!
			// do we have only => a-z A-Z -> valid
			// regEx

			String alphaRegEx = "[a-zA-Z]{2,}";// 1 --- N

			if (studentName.matches(alphaRegEx) == false) {
				isError = true;
				request.setAttribute("studentNameError", "Plase Enter Valid Student Name");
			}

		}

		if (playerType == null || playerType.trim().length() == 0) {
			isError = true;
			request.setAttribute("playerTypeError", "Please Select Player Type");
		}

		if (isError == true) {
			// go back -> input
			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistration.jsp");
			rd.forward(request, response);

		} else {
			// success ->

			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistrationSuccess.jsp");
			rd.forward(request, response);
		}
	}
}