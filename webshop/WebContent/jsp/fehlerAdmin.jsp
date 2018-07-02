<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Fehlerseite</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<h1>Eingabefehler</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>

	<c:if test="${not empty angebot}">
		<p>Ihre eingegebene Artikelnummer ist falsch oder existiert nicht.</p>
		<p>
			<a href="html/admin/updateAngebote.html">Erneut versuchen</a>
		</p>
		<p>
			<a href="html/admin/adminAngebot.html">Zurück zur
				Angebote-Übersicht</a>
		</p>
	</c:if>

	<c:if test="${not empty kontakt}">
		<p>Ihre eingegebene ID ist falsch oder existiert nicht.</p>

		<p>
			<a href="html/admin/loeschenKontakt.html">Erneut versuchen</a>
		</p>
		<p>
			<a href="html/admin/adminKontakt.html">Zurück zur
				Kontaktformular-Übersicht</a>
		</p>
	</c:if>
	<c:if test="${not empty produkt}">
		<p>Ihre eingegebene Artikelnummer ist falsch oder existiert nicht</p>
		<p>ODER</p>
		<p>Ihr eingegebener Name der Produktseite existiert bereits.</p>

		<p>
			<a href="html/admin/adminProdukte.html">Zurück zur
				Produkt-Übersicht</a>
		</p>
	</c:if>


	<c:if test="${not empty myKunde}">
		<p>Ihre eingegebene ID ist falsch oder existiert nicht.</p>

		<p>
			<a href="html/admin/adminKunden.html">Zurück zur Kunden-Übersicht</a>
		</p>
	</c:if>




</body>
</html>