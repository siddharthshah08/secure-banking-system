<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.css" />  
<title>SSBank Online Banking System</title>
<!-- <script type="text/javascript" src="bootstrap/js/paging.js"></script>
<script type="text/javascript"><!--
    var pager = new Pager('transaction', 3); 
    pager.init(); 
    pager.showPageNav('pager', 'pageNavPosition'); 
    pager.showPage(1);
</script> -->
</head >
<body>

<div style="background-color:#3276b1; width:100%; height:50px"></div>
<div style="position:absolute;left:345px; top:90px; width:800px; height:150px; z-index:0"><font face="Cambria" size="15px" color="#3276b1">SSBank Online Banking System</font></div>
<div style="position:absolute;left:400px; top:200px; width:500px; height:150px; z-index:0"><font face="Cambria" size="4px" color="#3276b1"> &nbsp; &nbsp; &nbsp; &nbsp; Transaction history</font></div>


<div class="list-group" style="position:absolute;left:170px; top:200px; width:200px; height:150px">
  <a href="#" class="list-group-item">Welcome,</a>
  <a id = "adduserLink" href="addInternalUser.html" class="list-group-item">Add Internal User</a>
  <a id = "modifyLink" href="modifyDeleteInternalUser.html" class="list-group-item">Modify / Delete Internal User</a>
  <a id = "editprofLink" href="EditMyProfile.html" class="list-group-item">Edit My Profile</a>
  <a id = "reportLink" href="ReportAnIssue.html" class="list-group-item">Report an Issue</a>
  <a id = "todoLink" href="ToDo.html" class="list-group-item active">To do Items</a>
  <a id=  "newustLink" href="addExternalCustomer.html" class="list-group-item">Add New Customer</a>
  <a id=  "viewAllTrans" href="ViewAllTransaction.html" class="list-group-item">View Transactions</a>
  <a href="Logout.html" class="list-group-item">Logout</a>
</div>

<div style="position:absolute;left:440px; top:250px; width:550px; height:150px">
<form name = "todoForm" method="post">
		<table id = "transaction" width="500" border="0" bordercolor="black" class ="table table-striped">
		<tr>
		  <td><b>Employee Name</b></td>
          <td><b>Requested Action</b></td>
          <td><b>Comments</b></td>
          <td colspan="2" align="center"><b>Action</b></td>
          </tr>
      <c:forEach var="ToDoItems" items="${message}">
        <tr>
         <td>${ToDoItems.associatedUser}</td>
          <td>${ToDoItems.action}</td>
          <td>${ToDoItems.comments}</td>
          <td><input id="${Number}"  style="width:70px;"name="modify" type="submit" value= "${ToDoItems.action}" class = "btn btn-primary" onclick="document.forms[0].method = 'post';document.forms[0].action = 'DeleteSubordinate.html?delUserame=${ToDoItems.associatedUser}&actionOn=${ToDoItems.action}';return true;"/></td>     
        </tr>
      </c:forEach>
      </table>
     </form>
</div>

</body>
</head>

</html>




