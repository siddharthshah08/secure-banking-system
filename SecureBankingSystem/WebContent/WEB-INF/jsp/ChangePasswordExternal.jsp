<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>

<script>
function Validate() 
{
	var f = document.getElementById("epw1");
	var s = document.getElementById("epw2");
	 if (f.value != s.value)
         alert("Passwords do not match");
}

</script>
</head >
<body>

<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>


<form name ="eucpw" action="ChangePasswordEx.html" method="post" onsubmit="return checkTest();">

<input name="currentpw" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:205px;z-index:2" placeholder="Current Password" >
<input name="newpw1" id="epw1" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:255px;z-index:2" placeholder="New Passowrd">
<input name="newpw2" id="epw2" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:305px;z-index:2" onblur=Validate() placeholder="Confirm Password" >

<input name="update" type="submit" value="Update" style="position:absolute;width:200px;left:450px;top:400px;z-index:4;" class = "btn btn-primary"/>
<input name="Cancel" type="button" value="Cancel" style="position:absolute;width:200px;left:670px;top:400px;z-index:4;" class = "btn btn-primary"/>

</form>


<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="ExternalWelcomePage.html" class="list-group-item">Welcome,</a>
  <a id = "transFund" href="transferfunds.html" class="list-group-item">Transfer Funds</a>
  <a id = "viewStmt" href="Transactionlist.html" class="list-group-item">View Statement</a>
  <a id = "exteditprofLink" href="EUEditMyProfile.html" class="list-group-item active">Edit My Profile</a>
  <a id = "extreportLink" href="ExReportanIssue.html" class="list-group-item">Report an Issue</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>
</body>
</html>