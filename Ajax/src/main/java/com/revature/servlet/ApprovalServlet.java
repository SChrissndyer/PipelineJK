package com.revature.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Requests;
import com.revature.dao.Users;

import javax.servlet.annotation.WebServlet;
@WebServlet("/apprReimbursements")
public class ApprovalServlet extends HttpServlet{
	static service service = new service();
	//get events per employee
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN Reimbursments -- GET");
		HttpSession session = req.getSession();
		Users employee = (Users) session.getAttribute("employee");
		System.out.println(employee.toString());
		ArrayList<Requests> reimbursements = service.getReimbursementsByPending(employee.getUsername());
		ObjectMapper mapper = new ObjectMapper();
		String reimbursementString = mapper.writeValueAsString(reimbursements);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(reimbursementString);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}