<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




	
	<h2>Tagesaktuelle Angebote</h2>
	<table>

		<tr>
			<c:forEach items="${angebot}" var="parameter">
				<th><a href="html/${parameter.name}.jsp">Im Bereich
						${parameter.name}</a></th>
			</c:forEach>

		</tr>
		<tr>
			<c:forEach items="${angebot}" var="parameter">
				<td><img src="BilderLesenServlet?id=${parameter.bildID}"
					width="213" height="162"></td>
			</c:forEach>


		</tr>
	</table>