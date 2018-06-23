<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
<!--  ich hab keine Ahnung aber das passt so nicht -->
	<tr>
		<c:forEach items="${angebot}" var="parameter">
			<c:if test="${parameter.kategorieID == 1}">
				<th><a
					href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&Titel=Fernseher">
						${parameter.name}</a></th>
			</c:if>
			<c:if test="${parameter.kategorieID == 2}"></c:if>
			<th><a
				href="/ProduktDetail?page=${parameter.pageName}">
					${parameter.name}</a></th>
			<c:if test="${parameter.kategorieID == 3}">
				<th><a
					href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&Titel=Smartphones">${parameter.name}</a></th>
			</c:if>
			<c:if test="${parameter.kategorieID == 4}">
				<th><a
					href="jsp/produktDetailPage.jsp/Titel?titel=${titel}&page=${parameter.pageName}">
						${parameter.name}</a></th>
			</c:if>
		</c:forEach>

	</tr>
	<tr>
		<c:forEach items="${angebot}" var="parameter">
			<td><img src="BilderLesenServlet?id=${parameter.bildID}"
				width="213" height="162"></td>
		</c:forEach>


	</tr>
</table>