package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.service;
import com.revature.dao.Users;
import com.revature.util.Actions;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("in login servlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = br.readLine();
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		String[] employeeInfo = mapper.readValue(json, String[].class);
		String username = employeeInfo[0];
		String password = employeeInfo[1];
		Users employee = service.login(username, password);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		if(employee!= null) {
		String employeeJSON = mapper.writeValueAsString(employee);
		System.out.print(employeeJSON);
		HttpSession session = req.getSession();
		session.setAttribute("employee", employee);
		out.write(employeeJSON);
		}
		else {
			out.write("null"); //null as JSON string
		}
	}

}