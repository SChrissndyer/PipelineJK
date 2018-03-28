package com.revature.dao;

import java.util.ArrayList;

public interface RequestDao {

	void addReimbursement(Requests a);

	public Requests getReimbursementsBykey(int a, int b,String c, String d);

	ArrayList<Requests> getReimbursementsByPendingforpersontoapp(String username);



	ArrayList<Requests> getReimbursementsByEmployee(String username);

	
	
	
}
