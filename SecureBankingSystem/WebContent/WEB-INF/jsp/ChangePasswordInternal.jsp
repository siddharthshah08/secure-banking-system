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

<script type="text/javascript" src="/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
function Validate() 
{
	var f = document.getElementById("pw1");
	var s = document.getElementById("pw2");
	 if (f.value != s.value)
         alert("Passwords do not match");
}
	
</script>

</head >
<body>
<div style="background-color:#3276b1; width:100%; height:50px">${message}</div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<!-- <div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">Welcome to SSBank.<br> SSbank provide its customers an unique banking experience. <br>Please select action from the left menu.</font></div> -->
<form name ="iuedtprfl" action="ChangePassword.html" method="post" onsubmit="return checkTest();">

<input name="currentpw" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:205px;z-index:2" placeholder="Current Password" >
<input name="newpw1" id="pw1" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:255px;z-index:2" placeholder="New Passowrd">
<input name="newpw2" id="pw2" type="password" class = "form-control" style="position:absolute;width:200px;left:450px;top:305px;z-index:2" onblur=Validate() placeholder="Confirm Password" >


<!-- a href="ChangePassword.jsp" style="position:absolute;left:450px;top:545px;z-index:2">Change Password</a> -- >
<!-- <a href="ChangeSecurityQuestion.jsp" style="position:absolute;left:450px;top:570px;z-index:2">Change Security Question</a> -->

<input name="update" type="submit" value="Update" style="position:absolute;width:200px;left:450px;top:400px;z-index:4;" class = "btn btn-primary"/>
<input name="Cancel" type="button" value="Cancel" style="position:absolute;width:200px;left:670px;top:400px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "adduserLink" href="addInternalUser.html" class="list-group-item">Add Internal User</a>
  <a id = "modifyLink" href="modifyDeleteInternalUser.html" class="list-group-item">Modify / Delete Internal User</a>
  <a id = "editprofLink" href="EditMyProfile.html" class="list-group-item  active">Edit My Profile</a>
  <a id = "reportLink" href="ReportanIssue.html" class="list-group-item">Report an Issue</a>
  <a id = "todoLink" href="#" class="list-group-item">To do Items</a>
  <a id="newustLink" href="#" class="list-group-item">Add New Customer</a>
  <a id = "logout" href="Logout.html" class="list-group-item">Logout</a>
</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




