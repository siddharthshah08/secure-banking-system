<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String uname = request.getParameter("username"); 
    /* session.setAttribute("userName",uname);
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0); */  
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

</head >
<body>

<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1">You are not authorized to perform this operation.</font></div>
<%-- <div>${modeluserName} , ${department} , ${priority}</div> --%>

<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,<%= uname %></a>
  <a id = "adduserLink" href="addInternalUser.html" class="list-group-item">Add Internal User</a>
  <a id = "modifyLink" href="modifyDeleteInternalUser.html" class="list-group-item active">Modify / Delete Internal User</a>
  <a id = "editprofLink" href="EditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "reportLink" href="ReportAnIssue.html" class="list-group-item">Report an Issue</a>
  <a id = "todoLink" href="ToDo.html" class="list-group-item">To do Items</a>
  <a id=  "newustLink" href="addExternalCustomer.html" class="list-group-item">Add New Customer</a>
  <a id=  "viewAllTrans" href="ViewAllTransaction.html" class="list-group-item">View Transactions</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>
</body>
</head>
</html>
