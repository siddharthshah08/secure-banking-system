<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>
<script type="text/javascript">

function disablesubmit()
{
if(document.getElementById("radio1").checked == false && document.getElementById("radio2").checked == false)
{
	document.getElementById("transferfund").disabled = true;
}
}


function checkVal()
{

	
	if(document.getElementById("radio1").checked == true)
		{
			document.getElementById("otherbanktxt").readOnly = true;
			document.getElementById("transferfund").disabled = false;
		}
		
	if(document.getElementById("radio2").checked == true)
		{
			//alert("Boo! Other Bank!");
		document.getElementById("otherbanktxt").readOnly = false;
		document.getElementById("transferfund").disabled = false;

		}

	
}
</script>

</head >
<body onload="disablesubmit()">
<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<!-- <div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">Welcome to SSBank.<br> SSbank provide its customers an unique banking experience. <br>Please select action from the left menu.</font></div> -->
<form name ="fundTrans" action="OTPpage.html" method="post" onsubmit="return checkTest();">

<div class="row" style="position:absolute;width:200px;left:450px;top:205px;z-index:2">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon">
        <input id = "radio1" name = "radiobutton" type="Radio" onclick="checkVal()">
      </span>
      <input name = "radiotxt1" type="text" class="form-control" value = "Transfer within SSBank" readonly style="width:200px">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  </div>
  <div class="row" style="position:absolute;width:200px;left:450px;top:255px;z-index:2">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon">
        <input id = "radio2" name = "radiobutton" type="Radio" onclick="checkVal()">
      </span>
      <input name = "radiotxt2" type="text" class="form-control" value = "Transfer to other Bank" readonly style="width:200px">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  </div>






<input id = "otherbanktxt" name="txtOtherbank" type="text" class = "form-control" style="position:absolute;width:238px;left:450px;top:305px;z-index:2" placeholder = "Other Bank Name">
<input name="acctNum" type="text" class = "form-control" style="position:absolute;width:238px;left:450px;top:355px;z-index:2" placeholder = "Account Number">
<input name="transAmt" type="text" class = "form-control" style="position:absolute;width:238px;left:450px;top:405px;z-index:2" placeholder = "Amount $">
<div>${message}</div>


<input name="transFund" id="transferfund" type="submit" value="Transfer" style="position:absolute;width:119px;left:450px;top:455px;z-index:4;" class = "btn btn-primary"/>
<input name="tranFundCancel" type="button" value="Cancel" style="position:absolute;width:114px;left:575px;top:455px;z-index:4;" class = "btn btn-primary"/>

</form>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "transFund" href="transferfunds.html" class="list-group-item  active">Transfer Funds</a>
  <a id = "viewStmt" href="Transactionlist.html" class="list-group-item">View Statement</a>
  <a id = "exteditprofLink" href="#" class="list-group-item">Edit My Profile</a>
  <a id = "extreportLink" href="#" class="list-group-item">Report an Issue</a>
  <a href="#" class="list-group-item">Logout</a>
</div>



<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">




</table> -->




</body>
</head>

</html>




