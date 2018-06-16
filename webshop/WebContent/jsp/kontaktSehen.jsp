<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Administrationsoberfläche</title>
</head>
<body>
	<h3>Ergebnis Kontakformular</h3>
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

	<a href="../html/admin/admintKontakt.html">Zurück</a>
</body>
</html>