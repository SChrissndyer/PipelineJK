package com.revature.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.revature.dao.Requests;
import com.revature.dao.Users;
import com.revature.dao.UsersDaoImpl;

public class Actions {
	
	public boolean login(String a,String b) {
		UsersDaoImpl app= new UsersDaoImpl();
		 ArrayList<Users> all = app.retrieveAllUser();
		 for(Users i:all) {
			 if( i.getUsername().equals(a)&&i.getUserpassword().equals(b)) {
				 return true;
			 }
		 }
		
		
		return false;
		
		
	}
	
	public ArrayList<String> getYourRequest(){
		UsersDaoImpl app= new UsersDaoImpl();
		 ArrayList<Users> all = app.retrieveAllUser();
		 ArrayList<String> alla = new ArrayList<String>();
		 for (Users p: all) {
			 alla.add(p.getUsername()+" "+p.getUserpassword());
		 }
		 
		
		return alla;
		
	}

}
