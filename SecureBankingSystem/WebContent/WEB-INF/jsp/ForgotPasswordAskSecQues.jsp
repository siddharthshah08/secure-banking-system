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
<div style="background-color:#3276b1; width:100%; height:50px">"${message}"</div>
<div style="position:absolute;left:345px; top:136px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">Hi ${uname}<br>Please answer the following Security Question</font></div>
<form id ="frgtPassword" name="form" target="_self" method="post" action="PasswordRecovery.html" style="margin:0px" class="form-inline">
<input name = "username" type = "hidden" value = "${uname}" />
<input name="forgotpasswordsq1"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:260px;z-index:2"/ value = "${secQues1}">
<input name="forgotpasswordsa1"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:310px;z-index:2" placeholder = "Security Answer #1"/>
<input name="forgotpasswordsq2"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:360px;z-index:2"/ value = "${secQues2}">
<input name="forgotpasswordsa2"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:410px;z-index:2" placeholder = "Security Answer #2"/>
<input name="forgotpasswordsq3"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:460px;z-index:2"/ value = "${secQues3}">
<input name="forgotpasswordsa3"  type="text" class="form-control" style="position:absolute;width:400px;left:480px;top:510px;z-index:2" placeholder = "Security Answer #3"/>

<input name="forgotpasswordSQsubmit" type="submit" value="Get Password" style="position:absolute;left:480px;top:550px;width:400px;z-index:4;" class = "btn btn-primary"/>


</form>
</body>
</head>

</html>




