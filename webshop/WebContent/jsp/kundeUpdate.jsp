<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Kundenaktualisierung</title>
</head>
<body>
	<h3>Kundendaten erfolgreich aktualisiert:</h3>
	<br>
	<em>Id: </em>${myKunde.id}
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
	<em>Telefonnummer: </em>${myKunde.telefonnr}
	<br>
	<em>Straße: </em>${myKunde.straße}
	<br>
	<em>Hausnummer: </em>${myKunde.hausnr}
	<br>
	<em>Postleitzahl: </em>${myKunde.plz}
	<br>
	<em>Ort: </em>${myKunde.ort}


</body>
</html>