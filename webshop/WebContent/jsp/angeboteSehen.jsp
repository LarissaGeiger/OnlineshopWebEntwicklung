<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Angebote sehen</title>
<link rel="stylesheet" href="../css/adminForm.css">

</head>
<body>
	<h1>Alle Angebote:</h1>

	<table>
		<c:forEach items="${angebote}" var="parameter">
			<tr>
				<td>${parameter.name}:<br> Artikelnummer:
					${parameter.artikelnr}
				</td>
				<td><img src="BilderLesenServlet?id=${parameter.bildID}"
					width="213" height="162"></td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>