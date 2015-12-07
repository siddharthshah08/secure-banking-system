<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1"> &nbsp; &nbsp; &nbsp; &nbsp; Transaction history</font></div>


<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="ExternalWelcomePage.html" class="list-group-item active">Welcome,</a>
  <a id = "transFund" href="transferfunds.html" class="list-group-item">Transfer Funds</a>
  <a id = "viewStmt" href="Transactionlist.html" class="list-group-item">View Statement</a>
  <a id = "exteditprofLink" href="EUEditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "extreportLink" href="ExReportanIssue.html" class="list-group-item">Report an Issue</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>

<div style="position:absolute;left:440px; top:250px; width:550px; height:150px">
		<table width="500" border="0" bordercolor="black" class ="table table-striped">
		<tr>
		  <td><b>Transaction ID</b></td>
          <td><b>Account Number</b></td>
          <td><b>Destination Account Number</b></td>
          <td><b>Amount</b></td>
          </tr>
      <c:forEach var="person" items="${message}">
        <tr>
          <td>${person.transactionID}</td>
          <td>${person.fromAccountNumber}</td>
          <td>${person.toAccountNumber}</td>
          <td>${person.amount}</td>
        </tr>
      </c:forEach>
      </table>
</div>

<!-- <table width="500" align ="center" border="1" bordercolor="black" style="position:absolute; overflow:hidden; left:220px; top:160px; width:700px; height:479px; z-index:0">

</table> -->




</body>
</head>

</html>




