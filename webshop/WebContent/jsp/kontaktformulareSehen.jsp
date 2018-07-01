<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Kontaktformularausgabe</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<h1>Alle eingegangenen Kontakformulare</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>
	<c:choose>
		<c:when test="${empty kontakte}">
			<p>Es konnten keine Kontaktformulare von registrierten Kunden
				gefunden werden.</p>
		</c:when>
		<c:otherwise>
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
		</c:otherwise>


	</c:choose>
</body>
</html>