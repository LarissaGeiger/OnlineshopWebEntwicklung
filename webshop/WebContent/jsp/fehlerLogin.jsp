<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Loginfehler</title>
<link rel="stylesheet" href="css/startseite.css">
</head>
<body>

	<c:if test="${empty myKunde}">
		<h1>Eingabefehler</h1>


		<p>Ihre eingegebene Daten sind nicht korrekt!</p>
		<p>Prüfen Sie ihre Emailadresse und Passwort</p>
		<p>
			<a href="html/anmeldung.html">Erneut versuchen</a>
		</p>
	</c:if>

	<c:if test="${not empty myKunde}">
		<h1>Eingabefehler</h1>


		<p>Ihre eingegebene Emailadresse existiert bereits!</p>
		<p>
			<a href="html/registrierung.html">Erneut registrieren</a>
		</p>

	</c:if>



</body>
</html>