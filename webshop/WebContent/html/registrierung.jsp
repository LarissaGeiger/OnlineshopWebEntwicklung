<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ergebnis Registrierung</title>
</head>
<body>
	<h3>Empfangene Kundendaten</h3>
	<br>
	<em>Vorname: </em>${myKunde.vorname}
	<br>
	<em>Nachname: </em>${myKunde.nachname}
	<br>
	<em>Geburtsdatum: </em>${myKunde.geburtsdatum}
	<br>
	<em>E-mail: </em>${myKunde.email}
	<br>
	<em>Passwort: </em>${myKunde.passwort}


</body>
</html>