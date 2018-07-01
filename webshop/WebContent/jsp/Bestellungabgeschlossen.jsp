<!--  Hakan Demen  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="de">
<head>

<title>Pluto - Ihr Elektronikfachmarkt in der Nähe</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="${pageContext.request.requestURI}" />
<link rel="stylesheet" type="text/css" href="../css/Warenkorbcss.css" />


</head>

<body>
	<header>
		<h1>Pluto - Ihr Elektronikfachmarkt in der Nähe</h1>


		<nav>
			<form action="../index.jsp">
				<input type="submit" class="warenkorbbuttons" value="Zur Startseite" />
			</form>
		</nav>

	</header>




	<p class="hakenbild">
		<img src="../img/haken.png" alt="MediaWiki" id="haken">
	</p>

	<p class="center">Vielen Dank für Ihre Bestellung!</p>
	<p class="center">Der zu Bezahlende Preis beträgt:</p>
	<p class="preisbb">${warenkorb.gesamtpreis} €</p>












	<footer>
		<a href="html/kontaktformular.html">Kontakt</a> <a
			href="html/ueberUns.html">Über uns</a> <a href="html/impressum.html">Impressum</a>

	</footer>
</body>
</html>