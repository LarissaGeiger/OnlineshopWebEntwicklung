<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Administrationsoberfläche</title>
	</head>
	<body>
		<h1>Fehlerseite</h1>
		
		Der Kunde konnte unter diesem Nachnamen nicht gefunden werden oder existiert nicht.
		Bitte versuchen Sie es erneut.
		
		<jsp:include page="../html/admin/sehenKunden.html"/>
	</body>
</html>