<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form:form action="updateAcc" method="post" modelAttribute="account">
<form:hidden path="accountId"/>
<font color="green"><p>${updateSucc}</p></font>
<table border="1">
<tr>
<td>First Name:</td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td>Last Name:</td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td>Email:</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>Password:</td>
<td><form:input path="pswd"/></td>
</tr>
<tr>
<td>DOB:</td>
<td><form:input path="dob"/></td>
</tr>
<tr>
<td>Mobile:</td>
<td><form:input path="mobile"/></td>
</tr>
<tr>
<td>Gender:</td>
<td><form:input path="gender"/></td>
</tr>
<tr>
<td>SSN:</td>
<td><form:input path="ssn"/></td>
</tr>
<tr>
<td>Role:</td>
<td><form:input path="role"/></td>
</tr>
<tr>
<td><input type="submit" value="Update"></td>
</tr>
</table>
</form:form>
</body>
</html>