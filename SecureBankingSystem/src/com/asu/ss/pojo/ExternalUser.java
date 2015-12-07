package com.asu.ss.pojo;


public class ExternalUser {

	public ExternalUser(String firstName, String lastName, String address1,
			String address2, String phoneNumber, String cellNumber,
			String state, String email, String userName, String city,
			String zipcode, String activeSessionID, String mACaddress,
			String securityQues1, String securityAns1,
			String securityQues2, String securityAns2, String securityQues3,
			String securityAns3, int proirity) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.phoneNumber = phoneNumber;
		this.cellNumber = cellNumber;
		this.state = state;
		this.email = email;
		this.userName = userName;
		this.city = city;
		this.zipcode = zipcode;
		this.activeSessionID = activeSessionID;
		MACaddress = mACaddress;
		this.priority = priority;
		this.securityQues1 = securityQues1;
		this.securityAns1 = securityAns1;
		this.securityQues2 = securityQues2;
		this.securityAns2 = securityAns2;
		this.securityQues3 = securityQues3;
		this.securityAns3 = securityAns3;
	}

	private String firstName;
	
	private String lastName;
	
	private String address1;
	
	private String address2;
	
	private String phoneNumber;
	
	private String cellNumber;
	
	private String state;
	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	private String email;
	
	private String userName;
	
	private String city;
	
	private String zipcode;
	
	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	private String activeSessionID;
	public String getActiveSessionID() {
		return activeSessionID;
	}


	public void setActiveSessionID(String activeSessionID) {
		this.activeSessionID = activeSessionID;
	}


	public String getMACaddress() {
		return MACaddress;
	}


	public void setMACaddress(String mACaddress) {
		MACaddress = mACaddress;
	}


	public int getPriority() {
		return this.priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getSecurityQues1() {
		return securityQues1;
	}


	public void setSecurityQues1(String securityQues1) {
		this.securityQues1 = securityQues1;
	}


	public String getSecurityAns1() {
		return securityAns1;
	}


	public void setSecurityAns1(String securityAns1) {
		this.securityAns1 = securityAns1;
	}


	public String getSecurityQues2() {
		return securityQues2;
	}


	public void setSecurityQues2(String securityQues2) {
		this.securityQues2 = securityQues2;
	}


	public String getSecurityAns2() {
		return securityAns2;
	}


	public void setSecurityAns2(String securityAns2) {
		this.securityAns2 = securityAns2;
	}


	public String getSecurityQues3() {
		return securityQues3;
	}


	public void setSecurityQues3(String securityQues3) {
		this.securityQues3 = securityQues3;
	}


	public String getSecurityAns3() {
		return securityAns3;
	}


	public void setSecurityAns3(String securityAns3) {
		this.securityAns3 = securityAns3;
	}

	private String MACaddress;
	
	private int priority;
	private String securityQues1;
	private String securityAns1;
	private String securityQues2;
	private String securityAns2;
	private String securityQues3;
	private String securityAns3;
	
	public ExternalUser()
	{
	
		
		
	}
	
	
	public void setFirstName(String fName)
	{
		
		this.firstName=fName;
		
	}
	
	public String getFirstName()
	{
		
		return this.firstName;		
	
	}
	
	public void setLastName(String lName)
	{
		
		this.lastName=lName;
		
	}
	
	public String getLastName()
	{
		
		return this.lastName;		
	
	}
	
	
	
	public void setAddress1(String Address1)
	{
		
		this.address1=Address1;
		
	}
	
	public String getAddress1()
	{
		
		return this.address1;		
	
	}
	
	public void setAddress2(String Address2)
	{
		
		this.address2=Address2;
		
	}
	
	public String getAddress2()
	{
		
		return this.address2;		
	
	}
	
	public void setPhoneNumber(String phone)
	{
		
		this.phoneNumber=phone;
		
	}
	
	public String getPhoneNumber()
	{
		
		return this.phoneNumber;		
	
	}
	
	public void setCellNumber(String cell)
	{
		
		this.cellNumber=cell;
		
	}
	
	public String getCellNumber()
	{
		
		return this.cellNumber;		
	
	}
	
	public void setEmail(String e)
	{
		
		this.email=e;
		
	}
	
	public String getEmail()
	{
		
		return this.email;		
	
	}
	
	public void setUserName(String userName)
	{
		
		this.userName=userName;
		
	}
	
	public String getUserName()
	{
		
		return this.userName;
		
	}


}
