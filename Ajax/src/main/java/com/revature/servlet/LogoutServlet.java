package com.revature.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in logout servlet");
		HttpSession session = req.getSession(false);
		if(session != null){
			session.removeAttribute("employee");
			session.invalidate();
			System.out.println("Session invalidated!");
		}
		resp.sendRedirect("index.html");
	}
}
