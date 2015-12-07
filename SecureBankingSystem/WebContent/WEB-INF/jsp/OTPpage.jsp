<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" media="screen" href="/prac/bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>


</head >
<body>
<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">Please click on this <a href="#OTPpage.jsp"><u>Get Access Code</u></a> link to receive an access code on your email</font></div>
<form id="OTPForm" name ="otpfundTrans" target="_self" method="post" action="FundTransferSuccessful.html">


<input name="txtOtherbank" type="password" class = "form-control" style="position:absolute;width:238px;left:450px;top:305px;z-index:2">


<input name="otptransFund" type="submit" value="Transfer" style="position:absolute;width:119px;left:450px;top:355px;z-index:4;" class = "btn btn-primary"/>
<input name="otptranFundCancel" type="button" value="Cancel" style="position:absolute;width:114px;left:575px;top:355px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "transFund" href="#" class="list-group-item  active">Transfer Funds</a>
  <a id = "viewStmt" href="#" class="list-group-item">View Statement</a>
  <a id = "exteditprofLink" href="#" class="list-group-item">Edit My Profile</a>
  <a id = "extreportLink" href="#" class="list-group-item">Report an Issue</a>
  <a href="#" class="list-group-item">Logout</a>
</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




