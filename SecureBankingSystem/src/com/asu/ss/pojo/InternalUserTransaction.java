package com.asu.ss.pojo;

public class InternalUserTransaction {

	private String UserName;
	private String actionPerformed;
	private String firstName;
	private String lastName;
	private int id;
	
	public InternalUserTransaction()
	{
		
	}
	
	public InternalUserTransaction(String userName,String actionPerformed,String firstName,String LastName)
	{
		this.UserName=userName;
		this.actionPerformed = actionPerformed;
		this.firstName = firstName;
		this.lastName=LastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getActionPerformed() {
		return actionPerformed;
	}
	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
