package com.revature.dao;
import java.util.ArrayList;
import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;

import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.dao.Users;
import com.revature.dao.Requests;

public class service {
	static UsersDao userapp = new UsersDaoImpl();
	static RequestDao requestapp = new RequestDaoImpl();
	
	public static Users login(String username, String password) {

		Users employee = userapp.retrieveUserById(username);

		if(employee== null) return null;

		else if (employee.getUserpassword().equals(password)) {

			return employee;

		}

		else return null;

	}
	
	public Requests addReimbursement(Requests r) {
		 requestapp.addReimbursement(r);
		return r;
		

	}

	public boolean usernameExists(String username) {
		Users employee = userapp.retrieveUserById(username);
		if(employee == null) return false;
		else return true;
	}
	public ArrayList<Requests> getReimbursementsByPending(String a){

		return requestapp.getReimbursementsByPendingforpersontoapp(a);

	}

	public ArrayList<Requests> getReimbursementsByEmployee( String username){

		return requestapp.getReimbursementsByEmployee(username);

	}

}