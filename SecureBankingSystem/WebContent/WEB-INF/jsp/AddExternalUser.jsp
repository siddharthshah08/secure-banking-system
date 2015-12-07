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
<form name ="addextuser" method="post">

<input name="extfname" value="first name" class = "form-control" style="position:absolute;width:200px;left:450px;top:205px;z-index:2" placeholder = "First Name">
<input name="extlname" value="last name" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:205px;z-index:2" placeholder = "Last Name">
<input name="exttxtadd1" value="address1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:255px;z-index:2" placeholder = "Address Line #1">
<input name="exttxtadd2" value="address2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:305px;z-index:2" placeholder = "Address Line #2">
<input name="exttxtcity" value="city" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:355px;z-index:2" placeholder = "City">
<input name="exttxtstate" value="state" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:355px;z-index:2" placeholder = "State">
<input name="exttxtzipcode" value="zip code" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:405px;z-index:2" placeholder = "Zip Code">
<input name="exttxtphone" value="phone" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:455px;z-index:2" placeholder = "Phone #">
<input name="exttxtcell" value="cell" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:505px;z-index:2" placeholder = "Cell #">
<input name="exttxtemail" value="email" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:555px;z-index:2" placeholder = "Email">
<input name="extsecurityQues1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:605px;z-index:2" placeholder = "Security Question 1" value="What is the first Car you own?" readonly>
<input name="extsecurityAns1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:655px;z-index:2" placeholder = "Security Answer 1">
<input name="extsecurityQues2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:705px;z-index:2" placeholder = "Security Question 2" value="What is the first crush?" readonly>
<input name="extsecurityAns2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:755px;z-index:2" placeholder = "Security Answer 2">
<input name="extsecurityQues3" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:805px;z-index:2" placeholder = "Security Question 3" value="What is the first crush1?" readonly>
<input name="extsecurityAns3" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:855px;z-index:2" placeholder = "Security Answer 3">
<input name="TypeOfUser" value="usertype" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:855px;z-index:2" placeholder = "Type of User">


<input name="AddExtuser" type="submit" value="Add" style="position:absolute;width:200px;left:450px;top:905px;z-index:4;" class = "btn btn-primary" onclick="document.forms[0].action = 'ExternalUserAddedSuccessfully.html';return true;"/>
<input name="ExtCancel" type="submit" value="Cancel" style="position:absolute;width:200px;left:670px;top:905px;z-index:4;" class = "btn btn-primary" onclick="document.forms[0].action = 'CancelInternal.html';return true;"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,<%= uname %></a>
  <a id = "adduserLink" href="addInternalUser.html" class="list-group-item">Add Internal User</a>
  <a id = "modifyLink" href="modifyDeleteInternalUser.html" class="list-group-item">Modify / Delete Internal User</a>
  <a id = "editprofLink" href="EditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "reportLink" href="ReportAnIssue.html" class="list-group-item">Report an Issue</a>
  <a id = "todoLink" href="ToDo.html" class="list-group-item">To do Items</a>
  <a id=  "newustLink" href="addExternalCustomer.html" class="list-group-item active">Add New Customer</a>
  <a id=  "viewAllTrans" href="ViewAllTransaction.html" class="list-group-item">View Transactions</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>
</body>
</head>

</html>




