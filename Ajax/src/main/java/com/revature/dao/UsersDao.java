package com.revature.dao;

import java.util.ArrayList;





public interface UsersDao {
	
	public void createUser(Users flashCard);
	
	public Users retrieveUserById(String id);
	
	public ArrayList<Users> retrieveAllUser();
	
	public void updateUser(Users flashCard);
		
	public void createUserPreparedStmt(Users flashCard);

	


}
