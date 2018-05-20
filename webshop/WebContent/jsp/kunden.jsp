<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Kundenliste</title>
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
		<c:forEach var="myKunde" items="${kunden}" varStatus="status">
			<tr>
				<td>${myKunde.id}</td>
				<td>${myKunde.vorname}</td>
				<td>${myKunde.nachname}</td>
				<td>${myKunde.gebdatum}</td>
				<td>${myKunde.email}</td>
				<td>${myKunde.passwort}</td>
				<td>${myKunde.telefonnr}</td>
				<td>${myKunde.straße}</td>
				<td>${myKunde.hausnr}</td>
				<td>${myKunde.plz}</td>
				<td>${myKunde.ort}</td>
				<td>${myKunde.admin}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>