<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../KategorieLesen" />

<!doctype html>
<html lang="de">
<head>

<title><c:choose>
		<c:when test="${kategorie.kategorieName == Fernseher }"> Fernseher
		</c:when>
		<c:when test="${kategorie.kategorieName == Kameras }">Kameras</c:when>

	</c:choose></title>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/kategorie.css">
</head>
<!-- 

- Kategorie Fernseher
	- Samsung Fernseher
		- Samsung TV
		- Samsung TV2
	- Panasonic Fernseher
		- Panasonic TV
	- LG Fernseher
		- LG TV
- Kategorie Notebooks
	- lenovo
		- Lenovo V
		- Lenovo Yoga
	- HP
		- HP Pavilion
		- HP Envy
	- Apple
		- MacBook
		- MacBook Air
- Kategorie Smartphones
	- Iphone
		- iphone 5
		- iphone 6
		- iphone X
	- Samsung Smartphones
		- galaxy 3
		- galaxy 6
- Kategorie Kamera
	- Spiegelreflex Kamera
		- canonSpiegel
		- nikonSpiegel
		- nikonRetroSpiegel
	- Digital Kamera
		- sonyDigital
		- samsungDigital
		- panasonicDigital

- Impressum
- Über Uns
- Registrierung
	- registrierungServlet
	- kundeBean
	- registrierung.jsp
- Kontakformular
	- kontakformularServlet
	- kontakBean
	- kontakformular.jsp


nav muss noch auf allen Seiten gleich gemacht werden -> Test auf index.html
 -->


<body>

	<header>
		<h1>
			<c:choose>
				<c:when test="${kategorie.kategorieName == Fernseher }"> Fernseher
		</c:when>
				<c:when test="${kategorie.kategorieName == Kameras }">Kameras</c:when>

			</c:choose>
		</h1>
		<p>
			<input type="text" name="suchfeld" size="70" maxlength="50"
				placeholder="Geben Sie hier Ihren Suchbegriff ein">
		</p>


		<nav>
		<!-- hier fehlt noch die Logik im Servlet um eingebunden zu werden -->
			<c:forEach items="${kategorie}" var="parameter">
				<a href="html/${parameter.kategorieName}.html" 
					value="${parameter}">${parameter.kategorieName}
				</a>
			</c:forEach>
		</nav>
	</header>