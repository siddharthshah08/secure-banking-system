package com.asu.ss.pojo;

public class Transactions {
	
	private String transactionID;
	
	private String fromAccountNumber;
	
	private String toAccountNumber;
	
	private String transactionDate;
	
	private int amount;
	
	public String getTransactionDate() 
	{
		
		return transactionDate;
		
	}

	public void setTransactionDate(String transactionDate) 
	{
	
		this.transactionDate = transactionDate;
		
	}
		
	public String getTransactionID() 
	{
	
		return transactionID;
		
	}

	public void setTransactionID(String transactionID)
	{
		
		this.transactionID = transactionID;
		
	}

	public String getFromAccountNumber()
	{
		
		return fromAccountNumber;
		
	}

	public void setFromAccountNumber(String fromAccountNumber) 
	{
	
		this.fromAccountNumber = fromAccountNumber;
		
	}

	public String getToAccountNumber() 
	{
		
		return toAccountNumber;
		
	}

	public void setToAccountNumber(String toAccountNumber) 
	{
		
		this.toAccountNumber = toAccountNumber;
		
	}

	public int getAmount() 
	{
		
		return amount;
		
	}

	public void setAmount(int amount)
	{
		
		this.amount = amount;
		
	}	
	
}
