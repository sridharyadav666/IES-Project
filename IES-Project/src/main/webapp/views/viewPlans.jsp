<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="" modelAttribute="plans">
<table border="1">
<thead>
<tr>
<th>S.NO</th>
<th>Plan Name</th>
<th>Plan Description</th>
<th>Plan Start Date</th>
<th>Plan End Date</th>
<th>Action</th>
</tr>
</thead>
<c:forEach var="plan" items="${plans}">

<tbody>
<tr>
<td>${plan.pid}</td>
<td>${plan.planName}</td>
<td>${plan.planDesc}</td>
<td>${plan.startDate}</td>
<td>${plan.endDate}</td>
<td>
<a class="btn" href="editplan?pid=${plan.pid}">Edit</a>
<a href="deleteplan?pid=${plan.pid}" onclick="return confirm('Do you want delete this Plan');">Delete</a>
</td>
</tr>
</tbody>
</c:forEach>
</table>
</form:form>
</body>
</html>