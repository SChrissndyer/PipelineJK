package com.revature.dao;

import java.sql.Date;

public class Requests {
	private int userid;
	private int type;
	private String gradingFormat;
	private String startD;
	private String endD;
	private String loaction;
	private String descpition;
	private Float cost;
	private String why;
	private String timeofday;
	private int t1;
	private int t2;
	private int t3;
	private int tfinal;
	
	public Requests() {
		super();
	}
	public Requests(int userid, int type, String gradingFormat, String startD,
			String endD, String loaction, String descpition,Float cost,
	 String why,String timeofday, int t1, int t2, int t3,int tfinal
	) {
		super();
		this.userid=userid;
		this.type=type;
		this.gradingFormat =gradingFormat;
		this.startD=startD;
		this.endD=endD;
		this.loaction=loaction;
		this.descpition=descpition;
		this.cost=cost;
		this.why=why;
		this.timeofday=timeofday;
		this.t1=t1;
		this.t2=t2;
		this.t3=t3;
		this.tfinal=tfinal;
	}
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int p) {
		this.userid = p;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getStartD() {
		return startD;
	}
	public void setStartD(String startD) {
		this.startD = startD;
	}
	public String getEndD() {
		return endD;
	}
	public void setEndD(String endD) {
		this.endD = endD;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	public String getDescpition() {
		return descpition;
	}
	public void setDescpition(String descpition) {
		this.descpition = descpition;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	public String getTimeofday() {
		return timeofday;
	}
	public void setTimeofday(String timeofday) {
		this.timeofday = timeofday;
	}
	public int getT1() {
		return t1;
	}
	public void setT1(int t1) {
		this.t1 = t1;
	}
	public int getT2() {
		return t2;
	}
	public void setT2(int t2) {
		this.t2 = t2;
	}
	public int getT3() {
		return t3;
	}
	public void setT3(int t3) {
		this.t3 = t3;
	}
	public int getTfinal() {
		return tfinal;
	}
	public void setTfinal(int tfinal) {
		this.tfinal = tfinal;
	}
	@Override

	public int hashCode() {

		final int prime = 31;

		int result = 1;
		result =  (prime * result + userid);
		result = prime * result +type;
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((startD == null) ? 0 : startD.hashCode());
		result = prime * result + ((endD == null) ? 0 : endD.hashCode());
		result = prime * result + ((loaction == null) ? 0 : loaction.hashCode());
		result = prime * result + ((descpition == null) ? 0 : descpition.hashCode());
		result = (int) (prime * result + cost);
		result = prime * result + ((why == null) ? 0 : why.hashCode());
		result = prime * result + ((timeofday == null) ? 0 : timeofday.hashCode());
		result =  (prime * result + t1);
		result =  (prime * result + t2);
		result =  (prime * result + t3);
		result =  (prime * result + tfinal);
		
		return result;

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Requests other = (Requests) obj;
		
		if (userid != other.userid)

			return false;

		if (type != other.type)

			return false;
		if (gradingFormat == null) {

			if (other.gradingFormat != null)

				return false;

		} else if (!gradingFormat.equals(other.gradingFormat))

			return false;

		if (startD == null) {

			if (other.startD != null)

				return false;

		} else if (!startD.equals(other.startD))

			return false;

		if (endD == null) {

			if (other.endD != null)

				return false;

		} else if (!endD.equals(other.endD))

			return false;

		if (loaction == null) {

			if (other.loaction != null)

				return false;

		} else if (!loaction.equals(other.loaction))

			return false;

		if (descpition == null) {

			if (other.descpition != null)

				return false;

		} else if (!descpition.equals(other.descpition))

			return false;

		if (cost != other.cost)

			return false;

		if (why == null) {

			if (other.why != null)

				return false;

		} else if (!why.equals(other.why))

			return false;
		
		if (timeofday == null) {

			if (other.timeofday != null)

				return false;

		} else if (!timeofday.equals(other.timeofday))

			return false;

		if (t1 != other.t1)

			return false;

		if (t2 != other.t2)

			return false;
		if (t3 != other.t3)

			return false;
		if (tfinal != other.tfinal)

			return false;

		return true;

	}

	@Override

	public String toString() {
		
		return "Requests [userid="+userid+", type=" + type + ", grading Format=" + gradingFormat + ", startD=" + startD

				+ ", endD=" + endD + ", loaction=" + loaction + ", descpition=" + descpition

				+ ", cost=" + cost + ", why=" + why + ", timeofday="

				+ timeofday + ", t1=" + t1 +", t2=" + t2 +", t3=" + t3 +", tfinal=" + tfinal + "]";

	}
	
}
