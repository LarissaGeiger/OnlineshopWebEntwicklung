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
	
	<br>
	<em>Vorname: </em>${myKunde.vorname}
	<br>
	<em>Nachname: </em>${myKunde.nachname}
	<br>
	<em>Geburtsdatum: </em>${myKunde.gebdatum}
	<br>
	<em>E-mail: </em>${myKunde.email}
	<br>
	<em>Passwort: </em>${myKunde.passwort}
	<br>
	<em>Straße: </em>${myKunde.straße}
	<br>
	<em>telnr: </em>${myKunde.telefonnr}
	<br>
	<em>ort: </em>${myKunde.ort}
	<br>
	<em>hausnr: </em>${myKunde.hausnr}
	<br>
	<em>plz: </em>${myKunde.plz}

</body>
</html>