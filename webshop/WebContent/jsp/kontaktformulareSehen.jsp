<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<title>Administrationsoberfläche</title>
</head>
<body>
	<h3>Alle eingegangenen Kontakformulare:</h3>

	<table>
		<tr>
			<th>Id</th>
			<th>Geschlecht</th>
			<th>Vorname</th>
			<th>Nachname</th>
			<th>Email</th>
			<th>Usereingabe</th>


		</tr>
		<c:forEach items="${kontakte}" var="parameter">
			<tr>
				<td>${parameter.id}</td>
				<td>${parameter.geschlecht}</td>
				<td>${parameter.vorname}</td>
				<td>${parameter.nachname}</td>
				<td>${parameter.email}</td>
				<td>${parameter.usereingabe}</td>


			</tr>
		</c:forEach>
	</table>

</body>
</html>