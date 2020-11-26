<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Accounts Page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function deactivateConfirm() {
		return confirm("Are You Sure, You Want to Deactivate Account ?");

	}
	function activeConfirm() {
		return confirm("Are You Sure, You Want to Activate Account ?");

	}
	//using Jquery
	$(document).ready(function()
	{
	    $('#userType').change(function(){		   
	       window.location.href = '/getAllAcc?role=' + $(this).val();
	    });
	});

	//using Javascript
	/*function ListTables()
	{
		var val=document.getElementById("userType").value;
		 window.location.href = '/accounts?role=' + val;
	}*/
</script>
</head>
<body>
	<div align="center">
		<u><h2>VIEW ACCOUNTS</h2></u>
		<select id="userType" name="role">
		   <option >-Selest- </option>
			<option value="Admin"  >Admin</option>
			<option value="CaseWorker" >Caseworker</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/accReg">   + Add New Account</a><br/>
		<font color="green">${succMsg}</font> <font color="red">${errorMsg}</font>
		<br><br/>
		<table border="1">
			<tr>
				<th>S.No</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountId}</td>
					<td>${account.firstName}</td>
					<td>${account.lastName}</td>
					<td>${account.email}</td>
					<td>${account.role}</td>
					<c:choose>
					<c:when test="${account.accStatus =='Active'}">
					<td><a href="/editAccount?accountId=${account.accountId}">Edit</a> &nbsp;&nbsp; <a
						href="/deactivateAccount?accountId=${account.accountId}"
						onclick="return deactivateConfirm()">Deactivate</a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editAccount?accountId=${account.accountId}">Edit</a>&nbsp;&nbsp;<a
						href="/activateAccount?accountId=${account.accountId}"
						onclick="return activeConfirm()">Active</a></td>
						
						</c:otherwise>
						</c:choose>
				</tr>

			</c:forEach>
		</table><br><br>
		<a href="home" >back to Home</a>

	</div>

</body>
</html>