<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>
<script type="text/javascript">

function inputFocus(i){
    if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
}
function inputBlur(i){
    if(i.value==""){ i.value=i.defaultValue; i.style.color="#888"; }
}

</script>

</head >
<body>
<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:136px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>

<form id ="loginform" name="form" target="_self" method="post" action="WelcomePage.html" style="margin:0px" class="form-inline">


<input name="username" value="username" type="text" class="form-control" style="position:absolute;width:200px;left:511px;top:250px;z-index:2" onfocus="inputFocus(this)" onblur="inputBlur(this)" />
<input name	="password" value="********" type="password" class="form-control"  style="position:absolute;width:200px;left:512px;top:292px;z-index:3" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>

<div style="position:absolute;width:200px;left:596px;top:340px;z-index:3"><a href="forgotPassword.html" title="">Forgot Password?</a></div>

<input name="login" type="submit" value="Log In" style="position:absolute;left:647px;top:370px;z-index:4;" class = "btn btn-primary"/>

<font color="red ">${message}</font>

</form>
</body>
</head>

</html>




