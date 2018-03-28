package com.revature.dao;

public class Users {
	private  int uid;
	private  String username;
	private  String userpassword;
	private  String fname;
	private  String lname;
	private  String depatment;
	private  int rank;
	private  float rev;
	private  String email;
	
	
	
	public Users() {
		super();
	}



	public Users(int uid,String username, String userpassword, String fname, String lname, String depatment, int rank,
			float rev, String email) {
		super();
		this.uid=uid;
		this.username = username;
		this.userpassword = userpassword;
		this.fname = fname;
		this.lname = lname;
		this.depatment = depatment;
		this.rank = rank;
		this.rev = rev;
		this.email = email;
	}



	public int getuid() {
		return uid;
	}
	public void setuid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}



	public String getUserpassword() {
		return userpassword;
	}



	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getDepatment() {
		return depatment;
	}



	public void setDepatment(String depatment) {
		this.depatment = depatment;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	public float getRev() {
		return rev;
	}



	public void setRev(float rev) {
		this.rev = rev;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + uid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((depatment == null) ? 0 : depatment.hashCode());
		result = prime * result + rank;
		result = (int) (prime * result + rev);
		result = prime * result + ((email == null) ? 0 : email.hashCode());;
		return result;

	}
	@Override

	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}
		if (obj == null) {

			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Users other = (Users) obj;
		if (uid != other.uid) {
			return false;
		}
		if (rev != other.rev) {
			return false;
		}
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname)) {
			return false;
		}
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname)) {
			return false;
		}
		if (userpassword == null) {
			if (other.userpassword != null)
				return false;
		} else if (!userpassword.equals(other.userpassword)) {
			return false;
		}
		if (rank != other.rank) {
			return false;
		}
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (depatment == null) {
			if (other.depatment != null)
				return false;
		} else if (!depatment.equals(other.depatment)) {
			return false;
		}
			return true;
	}
	@Override

	public String toString() {

		return "Users [uid="+uid+", firstname=" + fname + ", lastname=" + lname

				+ ", position=" + rank + ", department=" +depatment+", username=" + username + ", password=" + userpassword + ", awardedRe="

				+ rev + ", email=" + email + "]";

	}

	
	

}
