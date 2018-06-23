<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="UTF-8">
<title>${titel}</title>

<link rel="stylesheet" href="../css/fernseher.css">
</head>
<body>
	<header>

		<h1>${titel}</h1>
		<p style="text-align: center">
			<input type="text" name="suchfeld" size="70" maxlength="50"
				placeholder="Geben Sie hier Ihren Suchbegriff ein">
		</p>
		<nav>
			<select name="Kategorie wählen">
				<c:forEach items="${kategorie}" var="parameter">
					<option value="${parameter}">${parameter.name}</option>
				</c:forEach>

			</select>
		</nav>

	</header>
	<main>
	<aside>
		<a href="../Titel?titel=${titel}">Zurück zur Kategorie ${titel}</a><br>

	</aside>

	<article>

		<jsp:include page="../ProduktDetail" />

		<input type="button" name="Warenkorb" value="In den Warenkorb">

	</article>

	</main>



			<%@include file="unterkategorieFooter.jspf"%>
	