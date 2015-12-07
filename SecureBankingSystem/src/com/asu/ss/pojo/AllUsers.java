package com.asu.ss.pojo;

public class AllUsers {

	private String userName;
	private String password;
	private String userType;
	private int isBlocked;
	
	
	public int getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(int isBlocked) {
		this.isBlocked = isBlocked;
	}

	public AllUsers()
	{
		
	}
	
	/**
	 * @param args
	 */
	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}

}
