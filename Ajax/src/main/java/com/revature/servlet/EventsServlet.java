package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;

import com.revature.dao.Requests;
import com.revature.dao.Users;
import com.revature.dao.service;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
@WebServlet("/events")
public class EventsServlet extends HttpServlet{
	static service service = new service();
	//get events per employee
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN Events -- GET");
		HttpSession session = req.getSession();
		Users employee = (Users) session.getAttribute("employee"); // get logged user from session
		System.out.println("hi "+employee.getUsername());
		ArrayList<Requests> events = service.getReimbursementsByEmployee(employee.getUsername());
		if( events.isEmpty()) {
			System.out.println("no events");
		}
		else {
		System.out.println(events.get(0).toString());
		}
		ObjectMapper mapper = new ObjectMapper();
		String eventString = mapper.writeValueAsString(events);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(eventString);
	}
	//create user account
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	//update account
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
