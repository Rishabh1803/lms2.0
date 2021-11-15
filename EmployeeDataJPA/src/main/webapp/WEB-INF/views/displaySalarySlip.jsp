<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slip</title>
</head>
<body>
	<h1>Employee Salary Slip</h1>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Department</th>
			<th>Employee Designation</th>
			<th>Basic Salary</th>
			<th>DA</th>
			<th>HRA</th>
			<th>Total Salary</th>
		</tr>
			<tr>
				<td>${employee.employee.geteId() }</td>
				<td>${employee.employee.geteName() }</td>
				<td>${employee.employee.getDeptt() }</td>
				<td>${employee.employee.getDesig() }</td>
				<td>${employee.employee.getSalary() }</td>
				<td>${employee.getDa() }</td>
				<td>${employee.getHra() }</td>
				<td>${employee.getTotal() }</td>
			</tr>
	</table>
	<br>
	<br>
	<a href="./">Go to Main Page</a>
</body>
</html>