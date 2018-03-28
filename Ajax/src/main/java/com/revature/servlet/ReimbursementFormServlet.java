package com.revature.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.dao.Requests;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.service;
import javax.servlet.annotation.WebServlet;
@WebServlet("/submitRe")
public class ReimbursementFormServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service service = new service();
		ObjectMapper mapper = new ObjectMapper();
		Requests r = mapper.readValue(req.getInputStream(), Requests.class);
		System.out.println(r.toString());
		Requests reimbursement = service.addReimbursement(r);
		System.out.println(reimbursement);
		
		String reimbursementJSON = mapper.writeValueAsString(reimbursement);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.write(reimbursementJSON);
	}
}