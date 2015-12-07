<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String uname = (String)session.getAttribute("userName"); 
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);  
    if(session.getAttribute("userName")==null)	
    {
    	response.sendRedirect("index.html");
    	return;
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>
 </head >
<body>
<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<form name ="adduser" method="post">

<input name="fname" value="First name" class = "form-control" style="position:absolute;width:200px;left:450px;top:205px;z-index:2" placeholder = "First Name">
<input name="lname" value="Last name" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:205px;z-index:2" placeholder = "Last Name">
<input name="txtadd1" value="Address1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:255px;z-index:2" placeholder = "Address Line #1">
<input name="txtadd2" value="Address2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:305px;z-index:2" placeholder = "Address Line #2">
<input name="txtcity" value="city" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:355px;z-index:2" placeholder = "City">
<input name="txtstate" value="state" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:355px;z-index:2" placeholder = "State">
<input name="txtzipcode" value="zipcode" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:405px;z-index:2" placeholder = "Zip Code">
<input name="txtphone" value="phone" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:455px;z-index:2" placeholder = "Phone #">
<input name="txtcell" value="cell"  type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:505px;z-index:2" placeholder = "Cell #">
<input name="txtemail" value="email" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:555px;z-index:2" placeholder = "Email">
<input name="txtdepartment" value="department" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:605px;z-index:2" placeholder = "Department" value = "${message}">
<input name="txtdesignation" value="designation" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:655px;z-index:2" placeholder = "Designation">
<input name="txtmanager" value="manager" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:705px;z-index:2" placeholder = "Manager">
<input name="SSN" value="ssn" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:755px;z-index:2" placeholder = "SSN">
<input name="salary" value="salary" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:805px;z-index:2" placeholder = "Salary">
<input name="securityQues1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:855px;z-index:2" placeholder = "Security Question 1" value="What is the first Car you own?" readonly>
<input name="securityAns1" value="sec ans 1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:905px;z-index:2" placeholder = "Security Answer 1">
<input name="securityQues2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:955px;z-index:2" placeholder = "Security Question 2" value="What is the first crush?" readonly>
<input name="securityAns2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:1005px;z-index:2" placeholder = "Security Answer 2">
<input name="securityQues3" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:1055px;z-index:2" placeholder = "Security Question 3" value="What is the first cursh1?" readonly
>
<input name="securityAns3" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:1105px;z-index:2" placeholder = "Security Answer 3">

<%-- <td><input id="m${person.userName}"  style="width:70px;"name="modify" type="submit" value= "modify" class = "btn btn-primary" onclick="document.forms[0].method = 'post';document.forms[0].action = 'ModifySubordinate.html?modUserame=${person.userName}';return true;"/></td> --%>
<input name="Adduser" type="submit" value="Add" style="position:absolute;width:200px;left:450px;top:1155px;z-index:4;" class = "btn btn-primary" onclick="document.forms[0].action = 'UserAdddedSuccessfully.html';return true;"/>
<input name="Cancel" type="submit" value="Cancel" style="position:absolute;width:200px;left:670px;top:1155px;z-index:4;" class = "btn btn-primary" onclick="document.forms[0].action = 'CancelInternal.html';return true;"/>

</form>
<form:select path="transaction" id="transaction">
							<form:option value="Credit Card"></form:option>
							<form:option value="Debit Card"></form:option>
				   		 </form:select>
<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "adduserLink" href="addInternalUser.html" class="list-group-item active">Add Internal User</a>
  <a id = "modifyLink" href="modifyDeleteInternalUser.html" class="list-group-item">Modify / Delete Internal User</a>
  <a id = "editprofLink" href="EditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "reportLink" href="ReportAnIssue.html" class="list-group-item">Report an Issue</a>
  <a id = "todoLink" href="ToDo.html" class="list-group-item">To do Items</a>
  <a id=  "newustLink" href="addExternalCustomer.html" class="list-group-item">Add New Customer</a>
  <a id=  "viewAllTrans" href="ViewAllTransaction.html" class="list-group-item">View Transactions</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>
</body>
</head>

</html>





