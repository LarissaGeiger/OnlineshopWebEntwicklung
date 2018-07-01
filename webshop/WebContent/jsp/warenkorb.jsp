<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>

<title>Pluto - Ihr Elektronikfachmarkt in der Nähe</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/Warenkorbcss.css" />

<!-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Warenkorbcss.css"
	type="text/css"> -->

</head>




<body>


	<header>
		<h1>Pluto - Ihr Elektronikfachmarkt in der Nähe</h1>


		<nav>
			<a href="index.jsp">Zur Startseite</a>
		</nav>

	</header>


	<h2>Ihr Warenkorb</h2>


	<c:forEach items="${warenkorb.warenkorb}" var="parameter">
		<p>Name: ${parameter.produkt.name}</p>
		<p>Preis ${parameter.produkt.preis}</p>
		<p>Anzahl: ${parameter.anzahl}</p>
		<p>
			<img src="BilderLesenServlet?id=${parameter.produkt.bildID}"
				width="213" height="162">
		</p>
		<p>Gesamtpreis: ${warenkorb.gesamtpreis}</p>

	</c:forEach>

	<footer>
		<a href="html/kontaktformular.html">Kontakt</a> <a
			href="html/ueberUns.html">Über uns</a> <a href="html/impressum.html">Impressum</a>

	</footer>


</body>

</html>