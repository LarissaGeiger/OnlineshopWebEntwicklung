<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="de">
<head>

<title>Pluto - Ihr Elektronikfachmarkt in der Nähe</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/startseite.css">
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
		<h1>Pluto - Ihr Elektronikfachmarkt in der Nähe</h1>
		<p>
			<input type="text" name="suchfeld" size="70" maxlength="50"
				placeholder="Geben Sie hier Ihren Suchbegriff ein">
		</p>
		<!-- <select name="Kategorie wählen">
			<c:forEach items="${kategorie}" var="parameter">
				<option value="${parameter}"><a href="${parameter.name}" ></a></option>
			</c:forEach>
			
		</select> -->
		<nav>
			<!--https://www.w3schools.com/howto/howto_css_dropdown.asp -->
			<div class="dropdown">
				<button class="dropdown">Kategorie wählen</button>
				<div class="dropdown-content">
					<c:forEach items="${kategorie}" var="parameter">
						<a href="Titel?titel=${parameter.name}">${parameter.name} </a>
					</c:forEach>
				</div>
			</div>
			<!-- Ende  -->
		</nav>
		<a href="html/anmeldung.html">Anmelden</a>
	</header>