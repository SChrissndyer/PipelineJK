package com.revature.servlet;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("*.view")

public class LoadViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(process(req, resp));
		String page = process(req, resp);
		req.getRequestDispatcher(page).forward(req, resp);
	}
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		switch(req.getRequestURI()) {

		case("/Ajax/loadlanding.view") :

			return "partials/login.html";

		case("/Ajax/loadnav.view") :
			
			return "partials/navbar.html";

		case("/Ajax/loadhome.view") :
			
			return "partials/home.html";

		case("/Ajax/loadApprovals.view") :

			return "partials/approve.html";

		case("/Ajax/loadEmployeeEvents.view") :

			return "partials/events.html";

		case("/Ajax/loadEmployeeReimbursements.view") :

			return "partials/reimbursements.html";
		case("/Ajax/index.view") :
			return "partials/login.html";
		}
		return req.getRequestURI();
	}
}
