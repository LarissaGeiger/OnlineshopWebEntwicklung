<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ergebnis Kontakformular</title>
</head>
<body>
	<h3>Ihre Eingaben</h3>
	<br>
	<em>Geschlecht: </em>${myKontakt.geschlecht}
	<br>
	<em>Vorname: </em>${myKontakt.vorname}
	<br>
	<em>Nachname: </em>${myKontakt.nachname}
	<br>
	<em>E-mail: </em>${myKontakt.email}
	<br>
	<em>Nachricht: </em>${myKontakt.usereingabe}

</body>
</html>