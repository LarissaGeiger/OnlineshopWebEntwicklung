<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Löschen erfolgreich</title>

<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<h1>Löschen</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>


	<c:if test="${not empty kontakt}">
		<p>Ihr Kontaktformular wurde erfolgreich gelöscht!</p>
		<p>
			<a href="html/admin/loeschenKontakt.html">Weitere
				Kontaktformulare löschen </a>
		</p>
		<p>
			<a href="html/admin/adminKontakt.html">Zurück zur
				Kontakformular-Übersicht</a>
		</p>
	</c:if>
	<c:if test="${not empty myKunde}">
		<p>Die Kundendaten wurden erfolgreich gelöscht!</p>
		<p>
			<a href="html/admin/loeschenKunden.html">Weitere Kunden löschen </a>
		</p>
		<p>
			<a href="html/admin/adminKunden.html">Zurück zur Kunden-Übersicht</a>
		</p>
	</c:if>
	<c:if test="${not empty produkt}">
		<p>Das Produkt wurde erfolgreich gelöscht!</p>
		<p>
			<a href="html/admin/loeschenProdukt.html">Weitere Produkte
				löschen </a>
		</p>
		<p>
			<a href="html/admin/adminProdukte.html">Zurück zur
				Produkte-Übersicht</a>
		</p>
	</c:if>

</body>
</html>