<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="KategorieLesen" />

<!--jsp:include page="header.jsp" -->
<div>
	<h2>Tagesaktuelle Angebote</h2>
	<!--<c:forEach items="${angebot}" var="parameter">
		<th>c:out value ${parameter.angebot}</th>
	</c:forEach>-->

	<jsp:include page="AngeboteLesen" />

	<h3>Unsere Kategorien für Sie</h3>
	<table>
		<!-- Tabelle 4x2 -->
		<thead>
			<tr>


				<c:forEach items="${sessionScope.kategorie}" var="parameter">
					<th><a href="Titel?titel=${parameter.name}">Im Bereich
							${parameter.name}</a></th>
				</c:forEach>



			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${sessionScope.kategorie}" var="parameter">
					<td><img src="BilderLesenServlet?id=${parameter.bildID}"
						width="213" height="162"></td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="footer.jsp" />
