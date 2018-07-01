<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Angebote sehen</title>
<link rel="stylesheet" href="css/admin.css">

</head>
<body>
	<h1>Angebote</h1>
	<nav>
		<a href="index.jsp">Abmelden</a> <a href="html/admin/admin.html">Übersicht</a>
	</nav>

	<c:choose>
		<c:when test="${empty angebote}">
			<p>Derzeit sind keine Produkte im Angebot.</p>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach items="${angebote}" var="parameter">
					<tr>
						<td>${parameter.name}:<br> Artikelnummer:
							${parameter.artikelnr}
						</td>
						<td><img src="BilderLesenServlet?id=${parameter.bildID}"
							width="213" height="162" alt="${parameter.name}"></td>
					<tr>
				</c:forEach>
			</table>

		</c:otherwise>


	</c:choose>
</body>
</html>