package com.asu.ss.pojo;


public class InternalUser {
	
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;
	private String cellNumber;
	private String department;
	private String manager;
	private int salary;
	private String SSN;
	private String email;
	private String userName;
	private String activeSessionID;
	private String MACaddress;
	private int firstDelete;
	private int secondDelete;
	private String securityQues1;
	private String securityAns1;
	private String securityQues2;
	private String securityAns2;
	private String securityQues3;
	private String securityAns3;
	private String Designation;
	
	public String getDesignation() {
		return Designation;
	}


	public void setDesignation(String designation) {
		Designation = designation;
	}


	public InternalUser(String firstName, String lastName, String address1,String address2,
			String city, String state, String zipcode, String phoneNumber, String cellNumber,
			String department, String manager, int salary, String sSN,
			String email, String userName, String activeSessionID,
			String mACaddress, int firstDelete,
			int secondDelete, String designation, String securityQues1,
			String securityAns1, String securityQues2, String securityAns2,
			String securityQues3, String securityAns3) 
	{

		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2=address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.cellNumber=cellNumber;
		this.cellNumber=cellNumber;
		this.department = department;
		this.manager = manager;
		this.salary = salary;
		SSN = sSN;
		this.email = email;
		this.userName = userName;
		this.activeSessionID = activeSessionID;
		MACaddress = mACaddress;
		this.firstDelete = firstDelete;
		this.secondDelete = secondDelete;
		this.Designation=designation;
		this.securityQues1 = securityQues1;
		this.securityAns1 = securityAns1;
		this.securityQues2 = securityQues2;
		this.securityAns2 = securityAns2;
		this.securityQues3 = securityQues3;
		this.securityAns3 = securityAns3;
	}
	
	
	public InternalUser()
	{
		
		
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address1) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getFirstDelete() {
		return firstDelete;
	}

	public void setFirstDelete(int firstDelete) {
		this.firstDelete = firstDelete;
	}

	public int getSecondDelete() {
		return secondDelete;
	}

	public void setSecondDelete(int secondDelete) {
		this.secondDelete = secondDelete;
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

	
	
}
