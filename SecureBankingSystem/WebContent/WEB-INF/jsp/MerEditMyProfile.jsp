<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form name ="meredtprfl" action="MerEditMyProfileSuccesful.html" method="post" onsubmit="return checkTest();">

<input name="mertxtadd1" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:205px;z-index:2" <c:out value="${addr1}" /> />
<input name="mertxtadd2" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:255px;z-index:2" <c:out value="${addr2}" /> />
<input name="mertxtcity" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:305px;z-index:2" <c:out value="${city}" /> />
<input name="mertxtstate" type="text" class = "form-control" style="position:absolute;width:200px;left:670px;top:305px;z-index:2" <c:out value="${state}" /> />
<input name="mertxtzipcode" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:355px;z-index:2" <c:out value="${zipcode}" /> />
<input name="mertxtphone" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:405px;z-index:2" <c:out value="${phoneNo}" /> />
<input name="mertxtcell" type="text" class = "form-control" style="position:absolute;width:200px;left:450px;top:455px;z-index:2" <c:out value="${cell}" /> />
<input name="mertxtemail" type="text" class = "form-control" style="position:absolute;width:420px;left:450px;top:505px;z-index:2" <c:out value="${email}" /> />

<a href="MerChngPaswd.html" style="position:absolute;left:450px;top:545px;z-index:2">Change Password</a>

<input name="updateMER" type="submit" value="Update" style="position:absolute;width:200px;left:450px;top:600px;z-index:4;" class = "btn btn-primary"/>
<input name="Cancel" type="button" value="Cancel" style="position:absolute;width:200px;left:670px;top:600px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="MerchantWelcomePage.html" class="list-group-item">Welcome,</a>
  <a id = "claimamt" href="MerchantClaimAmount.html" class="list-group-item">Claim Amount</a>
  <a id = "merviewtran" href="Transactionlist.html" class="list-group-item">View Transaction</a>
  <a id = "mereditprofLink" href="MerEditMyProfile.html" class="list-group-item active">Edit My Profile</a>
  <a id = "merreportLink" href="MerReportanIssue.html" class="list-group-item">Report an Issue</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




