<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/account.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#userEmail").blur(function() {
			$("#errMsg").text("");
			$.ajax({
				type : "GET",
				url : "uniqueMailCheck?email="+$("#userEmail").val(),
				success : function(data) {
					if(data=="DUPLICATE"){
						$("#errMsg").text("Duplicate Email");
						$("#submitBtn").prop("disabled", true);
					}else{
						$("#submitBtn").prop("disabled", false);
					}
				}
			});

		});

	});
		
		$(function() {
	  $("#datepicker").datepicker({
	  changeMonth:true,
	  changeYear:true,
	  yearRange : "1960:"+ new Date(),
	  maxDate : new Date(),
	  dateFormat : 'dd/mm/yy'
	  });
	});
	
</script>
</head>
<body>

<div class="container">
<form:form action="accountCreation" method="POST" modelAttribute="acc">
<form:hidden path="accountId"/>
<h5 class="successMsg">${successMsg}</h5>
<h5 class="failMsg">${failureMsg}</h5>
<h1>User Registration</h1>
<table>
<tr>
<td>First Name: </td>
<td><form:input path="firstName" class="form-control"/></td>
</tr>

<tr>
<td>Last Name: </td>
<td><form:input path="lastName" class="form-control"/></td>
</tr>

<tr>
<td>Email: </td>
<td><form:input path="email" id="userEmail" class="form-control"/>
<span id="errMsg" style="color: red;"></span>
</td>
</tr>

<tr>
<td>Password: </td>
<td><form:password path="pswd" class="form-control"/></td>
</tr>

<tr>
<td>Phone Number: </td>
<td><form:input path="mobile" class="form-control"/></td>
</tr>

<tr>
<td>DOB: </td>
<td><form:input path="dob" class="form-control" id="datepicker"/></td>
</tr>

<tr>
<td>Gender: </td>
<td>
<form:radiobutton path="gender" value="M" class="radio"/>Male
<form:radiobutton path="gender" value="F" class="radio"/>Fe-Male
</td>
</tr>

<tr>
<td>SSN: </td>
<td><form:input path="ssn" class="form-control"/></td>
</tr>



<tr>
<td>Role: </td>
<td>
<form:select path="role" id="acctype" class="selectbox">
<form:option value="">-select-</form:option>
<form:option value="CaseWorker">Case Worker</form:option>
<form:option value="Admin">Admin</form:option>
</form:select>
</td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Create" id="submitBtn" class="btn"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>