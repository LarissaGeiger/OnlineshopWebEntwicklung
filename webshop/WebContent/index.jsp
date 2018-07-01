<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />
<div>
	<h2>Tagesaktuelle Angebote</h2>

	<jsp:include page="AngeboteLesen" />

	<h3>Unsere Kategorien für Sie</h3>
	<table>
		<thead>
			<tr>
				<c:forEach items="${kategorie}" var="parameter">
					<th><a href="Titel?titel=${parameter.name}">Im Bereich
							${parameter.name}</a></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${kategorie}" var="parameter">
					<td><img src="BilderLesenServlet?id=${parameter.bildID}"
						width="213" height="162" alt="${parameter.name}"></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="footer.jsp" />