package com.revature.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.dao.Requests;
import com.revature.dao.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
@WebServlet("/submitEvent")
public class FormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service service = new service();
		ObjectMapper mapper = new ObjectMapper();
		Requests e = mapper.readValue(req.getInputStream(), Requests.class);
		System.out.println(e.toString());
		Requests event = service.addReimbursement(e);
		System.out.println(event);
		String eventJSON = mapper.writeValueAsString(event);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.write(eventJSON);
	}
}