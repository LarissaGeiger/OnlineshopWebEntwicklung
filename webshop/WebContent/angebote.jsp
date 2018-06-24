<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>

	<tr>
		<c:forEach items="${angebot}" var="parameter">
			<c:if test="${parameter.kategorieID == 1}">
				<th><a
					href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&titel=Fernseher">
						${parameter.name}</a></th>
			</c:if>
			<c:if test="${parameter.kategorieID == 2}">
				<th><a
					href="jsp/ProduktDetailPage.jsp?page=${parameter.pageName}&titel=Notebooks">
						${parameter.name}</a></th>
			</c:if>
			<c:if test="${parameter.kategorieID == 3}">
				<th><a
					href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&titel=Smartphones">${parameter.name}</a></th>
			</c:if>
			<c:if test="${parameter.kategorieID == 4}">
				<th><a
					href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&titel=Kameras">
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