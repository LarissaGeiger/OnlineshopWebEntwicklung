<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Aktualisierung erfolgreich</title>

<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<h1>Aktualisierung</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>


	<c:if test="${not empty angebot}">
		<p>Ihr Angebot wurde erfolgreich aktualisiert!</p>
		<p>
			<a href="html/admin/updateAngebote.html">Weitere Produktangebote
				aktualisieren</a>
		</p>
		<p>
			<a href="html/admin/adminAngebot.html">Zurück zur
				Angebote-Übersicht</a>
		</p>
	</c:if>
	<c:if test="${not empty myKunde}">
		<p>Ihre Kundendaten wurden erfolgreich aktualisiert!</p>
		<p>
			<a href="html/admin/updateAngebote.html">Weitere Kundendaten
				aktualisieren</a>
		</p>
		<p>
			<a href="html/admin/adminAngebot.html">Zurück zur
				Kunden-Übersicht</a>
		</p>
	</c:if>



</body>
</html>