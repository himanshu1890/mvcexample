<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>Add Employee</h2>

	<form:form method="post" modelAttribute="employee">
		<table>
			<tr>
				<td><spring:message code="lbl.firstName" text="First Name"></spring:message></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors>
			</tr>
			<tr>
				<td><spring:message code="lbl.lastName" text="Last Name"></spring:message></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Employee"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>