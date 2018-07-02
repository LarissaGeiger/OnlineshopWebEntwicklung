<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Eingabe erfolgreich</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>


	<c:if test="${not empty myKunde}">
		<h1 class="eingabe">Registrierung erfolgreich</h1>

		<p>Sie haben sich erfolgreich registriert!</p>

		<p>
			<a href="index.jsp">Zurück</a> zur Homepage
		</p>
		<p>
			<a href="html/anmeldung.html">Weiter</a> zur Anmeldung
		</p>
	</c:if>
	<c:if test="${not empty myKontakt}">
		<h1 class="eingabe">Eingabe erfolgreich</h1>

		<p>Danke für ihre Nachricht!</p>
		<p>
			<a href="index.jsp">Zurück</a> zur Homepage
		</p>

	</c:if>




</body>
</html>