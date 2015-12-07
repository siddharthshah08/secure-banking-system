package com.asu.ss.pojo;

import java.util.Date;

public class Accounts {

	private String accountNumber;
	private String cardNumber; 
	private String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private int balance;
	private int CVV;
	private Date cardExpiry;
	

	public Accounts(String accountNumber) {
		this.accountNumber = accountNumber;		
	}
	
	
	public Accounts(String accountNumber, String userName, String cardNumber, int balance, Date cardExpiry, int CVV) {
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.CVV = CVV;
		this.cardExpiry = cardExpiry;
		
	}
	
	public Accounts()
	{
		super();
	}
	
	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
