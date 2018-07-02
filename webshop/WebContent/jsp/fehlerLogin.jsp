<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Loginfehler</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>

	<c:if test="${empty myKunde}">
		<h1 class="fehler">Eingabefehler</h1>


		<p>Ihre eingegebene Anmeldedaten sind nicht korrekt!</p>
		<p>Checken Sie ihre Emailadresse und Passwort</p>
		<p>
			<a href="html/anmeldung.html">Erneut versuchen</a>
		</p>
		<p>
			<a href="index.jsp">Zur Startseite</a>
		</p>
	</c:if>

	<c:if test="${not empty myKunde}">
		<h1 class="fehler">Eingabefehler</h1>


		<p>Ihre eingegebene Emailadresse existiert bereits!</p>
		<p>
			<a href="html/registrierung.html">Erneut registrieren</a>
		</p>
		<p>
			<a href="index.jsp">Zur Startseite</a>
		</p>

	</c:if>



</body>
</html>