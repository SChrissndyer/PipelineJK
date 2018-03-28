package com.revature.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.revature.util.ConnectionFactory;

public class RequestDaoImpl implements RequestDao {
	public RequestDaoImpl(){
		super();
	}
	
	public void addReimbursement(Requests a) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO REQUEST_CHECK (WHO_REQUESTED,TYPE_ID,GRADING_FORMAT,START_DATE,END_DATE,LOCATION,DESCRIPTION,COST,RESLATION_TO_WORK,TIME,T1_APP,T2_APP,T3_APP,FINAL_APP) VALUES(?,?,?,(TO_DATE(?,'YYYY-MM-DD')), (TO_DATE(?,'YYYY-MM-DD')),? ,?, ?,? ,?, ?,?,?,?)";
		
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
			String sql1="SELECT RANK FROM USERS WHERE USER_ID=?";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			ps1.setInt(1, a.getUserid());
			ResultSet rs = ps1.executeQuery();
			PreparedStatement ps = conn.prepareStatement(sql);
			int rank=0;
			
			while(rs.next()){
				rank=rs.getInt(1);
			}
			//Savepoint s = conn.setSavepoint("myFirstSavepoint");
			if (rank==1) {
		
			ps.setInt(1, a.getUserid());
			ps.setInt(2, a.getType());
			ps.setString(3, a.getGradingFormat());
			ps.setString(4, a.getStartD().toString());
			ps.setString(5, a.getEndD().toString());
			ps.setString(6, a.getLoaction());
			ps.setString(7, a.getDescpition());
			ps.setFloat(8, a.getCost());
			ps.setString(9, a.getWhy());
			ps.setString(10, a.getTimeofday());
			ps.setInt(11, a.getT1());
			ps.setInt(12, a.getT2());
			ps.setInt(13, a.getT3());
			ps.setInt(14, a.getTfinal());
		
			ps.executeUpdate();
			}
			else if(rank==2){
				
				ps.setInt(1, a.getUserid());
				ps.setInt(2, a.getType());
				ps.setString(3, a.getGradingFormat());
				ps.setString(4, a.getStartD().toString());
				ps.setString(5, a.getEndD().toString());
				ps.setString(6, a.getLoaction());
				ps.setString(7, a.getDescpition());
				ps.setFloat(8, a.getCost());
				ps.setString(9, a.getWhy());
				ps.setString(10, a.getTimeofday());
				ps.setInt(11, 1);
				ps.setInt(12, a.getT2());
				ps.setInt(13, a.getT3());
				ps.setInt(14, a.getTfinal());
			
				ps.executeUpdate();
				}
			else if(rank==3){
			
				ps.setInt(1, a.getUserid());
				ps.setInt(2, a.getType());
				ps.setString(3, a.getGradingFormat());
				ps.setString(4, a.getStartD().toString());
				ps.setString(5, a.getEndD().toString());
				ps.setString(6, a.getLoaction());
				ps.setString(7, a.getDescpition());
				ps.setFloat(8, a.getCost());
				ps.setString(9, a.getWhy());
				ps.setString(10, a.getTimeofday());
				ps.setInt(11, 1);
				ps.setInt(12, 1);
				ps.setInt(13, a.getT3());
				ps.setInt(14, a.getTfinal());
			
				ps.executeUpdate();
				}
			
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
	public Requests getReimbursementsBykey(int a, int b,String c, String d) {
		return null;
		
	}

	public ArrayList<Requests> getReimbursementsByPendingforpersontoapp(String a) {
		String sqlwho="SELECT RANK,DEPARTMENT FROM USERS WHERE USER_NAME=?";
		String sql = "select REQUEST_CHECK.*  from REQUEST_CHECK NATURAL join (select UNDERLING from USER_WORKS_FOR where BOSS=(select user_id from users where USER_NAME =?)) where T1_APP =-1 AND REQUEST_CHECK.WHO_REQUESTED= UNDERLING";
		String sql1 = "select REQUEST_CHECK.*  from REQUEST_CHECK NATURAL join (select user_id  from users where department =?) where T1_APP =1 and T2_APP =-1 and REQUEST_CHECK.WHO_REQUESTED= user_id";
		ArrayList<Requests> fcfinal= new ArrayList<Requests>();
		try {
			
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
				
			PreparedStatement ps = 
					conn.prepareStatement(sqlwho);
			ps.setString(1, a);
			ResultSet rs = ps.executeQuery();
			int rank=0;
			String dep="";
			while(rs.next()){
				rank=rs.getInt(1);
				dep=rs.getString(2);
			}
			if( rank==2) {
				PreparedStatement ps1 = 
						conn.prepareStatement(sql);
				ps1.setString(1, a);
				
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()){
					Requests fc=new Requests();
					fc.setUserid(rs1.getInt(1));
					fc.setType(rs1.getInt(2));
					fc.setGradingFormat(rs1.getString(3));
					fc.setStartD(rs1.getString(4).substring(0,10));
					fc.setEndD(rs1.getString(5).substring(0,10));
					fc.setLoaction(rs1.getString(6));
					fc.setDescpition(rs1.getString(7));
					fc.setCost(rs1.getFloat(8));
					fc.setWhy(rs1.getString(9));
					fc.setTimeofday(rs1.getString(10));
					fc.setT1(rs1.getInt(11));
					fc.setT2(rs1.getInt(12));
					fc.setT3(rs1.getInt(13));
					fc.setTfinal(rs1.getInt(14));
					
					fcfinal.add(fc);
					System.out.println(fc.toString());
					
					
				}
				
				
			}
			else if(rank==3) {
				PreparedStatement ps2 = 
						conn.prepareStatement(sql1);
				ps2.setString(1, dep);
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()){
					Requests fc=new Requests();
					fc.setUserid(rs2.getInt(1));
					fc.setType(rs2.getInt(2));
					fc.setGradingFormat(rs2.getString(3));
					fc.setStartD(rs2.getString(4).substring(0,10));
					fc.setEndD(rs2.getString(5).substring(0,10));
					fc.setLoaction(rs2.getString(6));
					fc.setDescpition(rs2.getString(7));
					fc.setCost(rs2.getFloat(8));
					fc.setWhy(rs2.getString(9));
					fc.setTimeofday(rs2.getString(10));
					fc.setT1(rs2.getInt(11));
					fc.setT2(rs2.getInt(12));
					fc.setT3(rs2.getInt(13));
					fc.setTfinal(rs2.getInt(14));
					fcfinal.add(fc);
					
					
				}
				
			}
			
			//conn.rollback(s);
			
			conn.commit();
			
			conn.setAutoCommit(true);
			
			conn.close();
		
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fcfinal;
	}

	public ArrayList<Requests> getReimbursementsByEmployee(String username) {
		String sql = "select REQUEST_CHECK.*  from REQUEST_CHECK NATURAL join (select user_id from users where USER_NAME =?) where REQUEST_CHECK.WHO_REQUESTED= user_id";
		ArrayList<Requests> fcfinal= new ArrayList<Requests>();
		try {
			
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
			
			//Savepoint s = conn.setSavepoint("myFirstSavepoint");
			
			PreparedStatement ps1 = 
						conn.prepareStatement(sql);
				ps1.setString(1, username);
				
				ResultSet rs = ps1.executeQuery();
				
				while(rs.next()){
					Requests fc=new Requests();
					fc.setUserid(rs.getInt(1));
					fc.setType(rs.getInt(2));
					fc.setGradingFormat(rs.getString(3));
					fc.setStartD(rs.getString(4).substring(0,10));
					fc.setEndD(rs.getString(5).substring(0,10));
					fc.setLoaction(rs.getString(6));
					fc.setDescpition(rs.getString(7));
					fc.setCost(rs.getFloat(8));
					fc.setWhy(rs.getString(9));
					fc.setTimeofday(rs.getString(10));
					fc.setT1(rs.getInt(11));
					fc.setT2(rs.getInt(12));
					fc.setT3(rs.getInt(13));
					fc.setTfinal(rs.getInt(14));
					
					fcfinal.add(fc);
				}
			//conn.rollback(s);
			
			conn.commit();
			
			conn.setAutoCommit(true);
			
			conn.close();
		
			ps1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fcfinal;
	}
	public void updateReimbursement(Requests a) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE REQUEST_CHECK SET WHO_REQUESTED=?,TYPE_ID=?,GRADING_FORMAT=?,START_DATE=(TO_DATE(?,'YYYY-MM-DD')),END_DATE=(TO_DATE(?,'YYYY-MM-DD')),LOCATION,DESCRIPTION=?,COST=?,RESLATION_TO_WORK=?,TIME=?,T1_APP=?,T2_APP=?,T3_APP=?,FINAL_APP=? WHERE WHO_REQUESTED=?AND TYPE_ID=? AND START_DATE=(TO_DATE(?,'YYYY-MM-DD')) AND TIME=?";
				try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Savepoint s = conn.setSavepoint("myFirstSavepoint");
		
		
			ps.setInt(1, a.getUserid());
			ps.setInt(2, a.getType());
			ps.setString(3, a.getGradingFormat());
			ps.setString(4, a.getStartD().toString());
			ps.setString(5, a.getEndD().toString());
			ps.setString(6, a.getLoaction());
			ps.setString(7, a.getDescpition());
			ps.setFloat(8, a.getCost());
			ps.setString(9, a.getWhy());
			ps.setString(10, a.getTimeofday());
			ps.setInt(11, a.getT1());
			ps.setInt(12, a.getT2());
			ps.setInt(13, a.getT3());
			ps.setInt(14, a.getTfinal());
			ps.setInt(15, a.getUserid());
			ps.setInt(16, a.getType());
			ps.setString(17, a.getStartD().toString());
			ps.setString(18, a.getTimeofday());
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
