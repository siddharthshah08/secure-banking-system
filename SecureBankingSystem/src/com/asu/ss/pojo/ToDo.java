package com.asu.ss.pojo;

public class ToDo {

	public ToDo(String actioneer, String associatedUserName,
			int isDone, String action, String comments) {
		super();
		this.actioneer = actioneer;
		this.associatedUserName = associatedUserName;
		this.isDone = isDone;
		this.action = action;
		this.comments = comments;
	}


	private int ID;
	
	public ToDo(String reportTo, int isDone, String userName, String description, String comments)
	{
		
		this.actioneer=reportTo;
		
		this.isDone=isDone;
		
		this.associatedUserName=userName;
		
		this.action=description;
		
		this.comments=comments;
		
	}
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	private String actioneer;
	public String getActioneer() {
		return actioneer;
	}


	public void setActioneer(String actioneer) {
		this.actioneer = actioneer;
	}


	public int getIsDone() {
		return isDone;
	}


	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	private String associatedUserName;
	public String getAssociatedUserName() {
		return associatedUserName;
	}

	public void setAssociatedUserName(String associatedUserName) {
		this.associatedUserName = associatedUserName;
	}


	private int isDone;
	private String action;
	private String comments;
	
	
	public ToDo(){
		
	}


	
}
