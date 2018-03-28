package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import com.revature.util.ConnectionFactory;

public class UsersDaoImpl implements UsersDao {

	public void createUser(Users flashCard) {
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "INSERT INTO USERS (USER_NAME,USER_PASSWORD,FNAME,LNAME,DEPARTMENT,RANK,REIMBURSEMENT_AMOUNT_LEFT,EMAIL) VALUES('"+flashCard.getUsername()+ "','"+flashCard.getUserpassword()+"', '"+flashCard.getFname()+"', '"+flashCard.getLname()+"', '"+flashCard.getDepatment()+"', '"+flashCard.getRank()+"', '"+flashCard.getRev()+"', '"+flashCard.getEmail()+"')";
			
			int rowsAffected = statement.executeUpdate(sql);
			
			System.out.println("Rows updated " + rowsAffected);
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Users retrieveUserById(String id) {
		Users fc = new Users();
		
		String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
		
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				fc.setuid(rs.getInt(1));
				fc.setUsername(rs.getString(2));
				fc.setUserpassword(rs.getString(3));
				fc.setFname(rs.getString(4));
				fc.setLname(rs.getString(5));
				fc.setDepatment(rs.getString(6));
				fc.setRank(rs.getInt(7));
				fc.setRev(rs.getFloat(8));
				fc.setEmail(rs.getString(9));
				
				
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fc;
	}

	public ArrayList<Users> retrieveAllUser() {
		
		ArrayList<Users> users = new ArrayList<Users>();
		
		String sql = "SELECT * FROM USERS";
		
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Users fc = new Users();
				
				fc.setUsername(rs.getString(2));
				fc.setUserpassword(rs.getString(3));
				fc.setFname(rs.getString(4));
				fc.setLname(rs.getString(5));
				fc.setDepatment(rs.getString(6));
				fc.setRank(rs.getInt(7));
				fc.setRev(rs.getFloat(8));
				fc.setEmail(rs.getString(9));
				users.add(fc);
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	public void updateUser(Users flashCard) {
		String sql = "UPDATE USERS SET USER_NAME=?,USER_PASSWORD=?,FNAME=?,LNAME=?,DEPARTMENT=?,RANK=?,REIMBURSEMENT_AMOUNT_LEFT=?,EMAIl=?  WHERE USER_NAME=?";
		
		try {
			
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
			
			//Savepoint s = conn.setSavepoint("myFirstSavepoint");
			
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, flashCard.getUsername());
			ps.setString(2, flashCard.getUserpassword());
			ps.setString(3, flashCard.getFname());
			ps.setString(4, flashCard.getLname());
			ps.setString(5, flashCard.getDepatment());
			ps.setInt(6, flashCard.getRank());
			ps.setFloat(7, flashCard.getRev());
			ps.setString(8, flashCard.getEmail());
			ps.setString(9, flashCard.getUsername());
			
			ps.executeUpdate();
			
			//conn.rollback(s);
			
			conn.commit();
			
			conn.setAutoCommit(true);
			
			conn.close();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void createUserPreparedStmt(Users flashCard) {
		
		String sql = "INSERT INTO USERS (USER_NAME,USER_PASSWORD,FNAME,LNAME,DEPARTMENT,RANK,REIMBURSEMENT_AMOUNT_LEFT,EMAIl) VALUES(?, ?,? ,?, ?,? ,?, ?)";
		
		try {
			
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
			
			//Savepoint s = conn.setSavepoint("myFirstSavepoint");
			
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, flashCard.getUsername());
			ps.setString(2, flashCard.getUserpassword());
			ps.setString(3, flashCard.getFname());
			ps.setString(4, flashCard.getLname());
			ps.setString(5, flashCard.getDepatment());
			ps.setInt(6, flashCard.getRank());
			ps.setFloat(7, flashCard.getRev());
			ps.setString(8, flashCard.getEmail());
			
			ps.executeUpdate();
			
			//conn.rollback(s);
			
			conn.commit();
			
			conn.setAutoCommit(true);
			
			conn.close();
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
