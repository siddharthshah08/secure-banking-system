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
<form name ="merchantClaimamt" action="MerAmtClaSuc.html" method="post" onsubmit="return checkTest();">

<input name="crdNum" class = "form-control" style="position:absolute;width:400px;left:470px;top:205px;z-index:2" value="Card Number" placeholder = "Card Number">
<input name="custName" type="text" value="Customer Name" class = "form-control" style="position:absolute;width:400px;left:470px;top:255px;z-index:2" placeholder = "Name">
<input name="txtCCV" type="text" class = "form-control" value="CVV" style="position:absolute;width:400px;left:470px;top:305px;z-index:2" placeholder = "CCV Number">
<input name="txtexpireDate" type="text" value="Expiry date" class = "form-control" style="position:absolute;width:400px;left:470px;top:355px;z-index:2" placeholder = "Expire Date mm/dd/yyyy">
<input name="claimAmt" type="text" value="Amount" class = "form-control" style="position:absolute;width:400px;left:470px;top:405px;z-index:2" placeholder = "Amount $">


<input name="submitAmt" type="submit" value="Submit" style="position:absolute;width:180px;left:470px;top:455px;z-index:4;" class = "btn btn-primary"/>
<input name="Cancel" type="button" value="Cancel" style="position:absolute;width:180px;left:690px;top:455px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "claimamt" href="#" class="list-group-item active">Claim Amount</a>
  <a id = "merviewtran" href="Transactionlist.html" class="list-group-item">View Transaction</a>
  <a id = "mereditprofLink" href="MerEditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "merreportLink" href="MerIssueReportedSuccessfully.html" class="list-group-item">Report an Issue</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>

<div>${message}</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




