<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Anmeldung erfolgreich</title>

</head>
<body>
	<h1>Anmeldung erfolgreich</h1>



	<c:if test="${empty myKunde}">
		<p>Sie sind ein Administrator!</p>
		<p>
			<a href="html/admin/admin.html">Hier</a> kommen Sie zur Verwaltung
			der Homepage
		</p>
		<p>
			<a href="index.jsp">Abmelden</a>
		</p>
	</c:if>
	<c:if test="${not empty myKunde}">
		<p>Sie sind angemeldet!</p>
		<p>
			<a href="index.jsp">Weiter</a> zur Homepage
		</p>
		<p>
			<a href="LogoutServlet">Abmelden</a>
		</p>
	</c:if>



</body>
</html>