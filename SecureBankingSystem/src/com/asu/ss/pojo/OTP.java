package com.asu.ss.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class OTP {
	
	private String userName;
	
	private String transactionID;
	
	private String OTP;
	
	private Timestamp dateOTPCreated;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public Timestamp getDateOTPCreated() {
		return dateOTPCreated;
	}

	public void setDateOTPCreated(Timestamp date) {
		this.dateOTPCreated = date;
	}	

}
