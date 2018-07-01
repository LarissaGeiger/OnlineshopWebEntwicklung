<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Kundenausgabe</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<h1>Gefundene Kundendaten</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>


	<c:choose>
		<c:when test="${empty myKunde}">
			<p>Es konnte kein Kunde unter diesem Nachname gefunden werden.</p>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Id</th>
					<th>Vorname</th>
					<th>Nachname</th>
					<th>Email</th>
					<th>Passwort</th>
					<th>Geburtsdatum</th>
					<th>Telefonnummer</th>
					<th>Straße</th>
					<th>Hausnummer</th>
					<th>Postleitzahl</th>
					<th>Ort</th>
					<th>Admin?</th>
				</tr>
				<c:forEach items="${myKunde}" var="parameter">

					<tr>
						<td>${parameter.id}</td>
						<td>${parameter.vorname}</td>
						<td>${parameter.nachname}</td>
						<td>${parameter.email}</td>
						<td>${parameter.passwort}</td>

						<c:choose>
							<c:when test="${empty parameter.gebdatum}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.gebdatum}</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty parameter.telefonnr}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.telefonnr}</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty parameter.straße}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.straße}</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${parameter.hausnr == '0'}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.hausnr}</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${parameter.plz == '0'}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.plz}</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty parameter.ort}">
								<td>k.A.</td>
							</c:when>
							<c:otherwise>
								<td>${parameter.ort}</td>
							</c:otherwise>
						</c:choose>
						<td><c:choose>
								<c:when test="${parameter.admin != true}">Nein</c:when>
								<c:otherwise>Ja</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>

		</c:otherwise>


	</c:choose>


</body>
</html>