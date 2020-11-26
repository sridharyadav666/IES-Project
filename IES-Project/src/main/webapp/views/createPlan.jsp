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
<form:form action="createPlan" method="POST" modelAttribute="plan">
<table>
<tr>
<td>Plan Name</td>
<td><form:input path="planName"/></td>
</tr>
<tr>
<td>Plan Description</td>
<td><form:input path="planDesc"/></td>
</tr>
<tr>
<td>Start Date</td>
<td><form:input path="startDate"/></td>
</tr>
<tr>
<td>End Date</td>
<td><form:input path="endDate"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Create"></td>
</tr>
</table>
</form:form>
</body>
</html>