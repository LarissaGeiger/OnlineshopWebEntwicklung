<!--  Larissa -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="UTF-8">
<title>${titel}</title>

<link rel="stylesheet" href="../css/produktDetailPage.css">
<script type="text/javascript" src="../js/nav.js"></script>

</head>
<body>
	<header>

		<h1>${titel}</h1>
		<p style="text-align: center">
			<input type="text" name="suchfeld" size="70" maxlength="50"
				placeholder="Geben Sie hier Ihren Suchbegriff ein">
		</p>
		<nav>
			<!--https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_dropdown_navbar_click -->
			<div class="dropdown">
				<button class="dropbtn" onclick="myFunction()">
					Kategorie wählen <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content" id="myDropdown">
					<a href="../index.jsp"> Startseite </a>

					<c:forEach items="${kategorie}" var="parameter">
						<a href="../Titel?titel=${parameter.name}">${parameter.name} </a>
					</c:forEach>

				</div>
			</div>
			<!-- Ende Kommentar  -->
		</nav>

	</header>
	<main>
	<aside>
		<a href="../Titel?titel=${titel}">Zurück zur Kategorie ${titel}</a><br>

	</aside>
<form action ="warenkorb.jsp" method ="get"> 

	<article>

		<jsp:include page="../ProduktDetail" />

		<input type="button"  formaction="warenkorb.jsp" name="Warenkorb" value="In den Warenkorb">
		<a href="../Warenkorbservlet?titel=${titel}&page=${produktDetail.pageName}&name=${produktDetail.name}&preis=${produktDetail.preis}"> In den warenkorb</a>

	</article>

	</main>
</form>


	<%@include file="unterkategorieFooter.jspf"%>