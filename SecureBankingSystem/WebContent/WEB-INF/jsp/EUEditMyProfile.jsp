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

</head >
<body>
<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<!-- <div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">Welcome to SSBank.<br> SSbank provide its customers an unique banking experience. <br>Please select action from the left menu.</font></div> -->
<form name ="euedtprfl"  action="EUEditMyProfileSuccessful.html" method="post" htmlEscape="true">

<input name="eutxtadd1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:205px;z-index:2" <c:out value="${addr1}" /> placeholder = "Address Line #1">
<input name="eutxtadd2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:255px;z-index:2" value = "${addr2}" placeholder = "Address Line #2">
<input name="eutxtcity" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:305px;z-index:2" value = "${city}" placeholder = "City">
<input name="eutxtstate" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:305px;z-index:2" value = "${state}" placeholder = "State">
<input name="eutxtzipcode" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:355px;z-index:2" value = "${zipcode}" placeholder = "Zip Code">
<input name="eutxtphone" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:405px;z-index:2" value = "${phoneNo}" placeholder = "Phone #">
<input name="eutxtcell" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:455px;z-index:2" value = "${cell}" placeholder = "Cell #">
<input name="eutxtemail" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:505px;z-index:2" value = "${email}" placeholder = "Email">

<a href="ChangePasswordExternal.html" style="position:absolute;left:450px;top:545px;z-index:2">Change Password</a>
<!--  a href="ChangeSecurityQuestion.jsp" style="position:absolute;left:450px;top:575px;z-index:2">Change Security Question</a> -->

<input name="updateEU" type="submit" value="Update" style="position:absolute;width:200px;left:450px;top:600px;z-index:4;" class = "btn btn-primary"/>
<input name="Cancel" type="button" value="Cancel" style="position:absolute;width:200px;left:670px;top:600px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="ExternalWelcomePage.html" class="list-group-item">Welcome,</a>
  <a id = "adduserLink" href="transferfunds.html" class="list-group-item">Transfer Funds</a>
  <a id = "modifyLink" href="Transactionlist.html" class="list-group-item">View Statement</a>
  <a id = "editprofLink" href="EUEditMyProfile.html" class="list-group-item active">Edit My Profile</a>
  <a id = "reportLink" href="ExReportanIssue.html" class="list-group-item">Report an Issue</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




