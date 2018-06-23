<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="kundenFehler.jsp"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<title>Administrationsoberfläche</title>
</head>
<body>
	<h3>Gefundene Kundendaten:</h3>

	<table>
		<tr>
			<th>Id</th>
			<th>Vorname</th>
			<th>Nachname</th>
			<th>Email</th>
			<th>Geburtsdatum</th>
			<th>Telefonnummer</th>
			<th>Passwort</th>
			<th>Straße</th>
			<th>Hausnummer</th>
			<th>Postleitzahl</th>
			<th>Ort</th>
			<th>Admin?</th>
		</tr>
		<c:forEach items="${kunden}" var="parameter">
			<tr>
				<td>${parameter.id}</td>
				<td>${parameter.vorname}</td>
				<td>${parameter.nachname}</td>
				<td>${parameter.email}</td>
				<td>${parameter.gebdatum}</td>
				<td>${parameter.telefonnr}</td>
				<td>${parameter.passwort}</td>
				<td>${parameter.straße}</td>
				<td>${parameter.hausnr}</td>
				<td>${parameter.plz}</td>
				<td>${parameter.ort}</td>
				<td><c:choose>
						<c:when test="${parameter.admin != true}">Nein</c:when>
						<c:otherwise>Ja</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>