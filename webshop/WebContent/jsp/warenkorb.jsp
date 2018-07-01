<!-- Hakan Demen -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="de">
<head>

<title>Ihr Warenkorb</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="${pageContext.request.requestURI}" />
<!--   <link rel="stylesheet" type="text/css" href="../css/Warenkorbcss.css" /> -->
<script type="text/javascript" src="../js/warenkorbjs.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Warenkorbcss.css" type="text/css">

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


	<h2>Ihr Warenkorb</h2>



	<div id="tabellewarenkorb">
		<table id="22">

			<tr>

				<th class="th">Artikelnummer</th>
				<th class="th">Produktname</th>
				<th class="th">Produktbild</th>
				<th class="th">Preis / Stk.</th>
				<th class="th">Menge</th>
				<th class="th">Gesamtpreis</th>



				<c:forEach items="${warenkorb.warenkorb}" var="parameter">
					<tr>

						<td>${parameter.produkt.artikelnr}</td>
						<td>${parameter.produkt.name}</td>
						<td><img src="BilderLesenServlet?id=${parameter.produkt.bildID}" class="wkbilder" alt="Produktbild"></td>
						<td>${parameter.produkt.preis}</td>
						<td>${parameter.anzahl}</td>

						<td></td>

						
				</c:forEach>
			<tr>

				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td id="gespreisdick">${warenkorb.gesamtpreis}</td>
			</tr>
		</table>



		<form action="../webshop3/jsp/Bestellungabgeschlossen.jsp">
			<input type="submit" onclick="Function()" value="Bestellung" />
		</form>


	</div>


	<footer>
		<a href="html/kontaktformular.html">Kontakt</a> <a
			href="html/ueberUns.html">Über uns</a> <a href="html/impressum.html">Impressum</a>

	</footer>




</body>

</html>