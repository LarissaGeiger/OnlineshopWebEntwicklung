<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="KategorieLesen" />

<!--jsp:include page="header.jsp" -->
<article>

	<h2>Tagesaktuelle Angebote</h2>
	<jsp:include page="AngeboteLesen" />


	<h3>Unsere Kategorien für Sie</h3>

	<table>
		<!-- Ist Unterteilung in thead und tbody sinnvoll? -->
		<thead>
			<tr>
				<c:forEach items="${kategorie}" var="parameter">
					<th><a href="html/${parameter.name}.jsp">Im Bereich
							${parameter.name}</a></th>
				</c:forEach>


			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${kategorie}" var="parameter">
					<td><img src="BilderLesenServlet?id=${parameter.bildID}"
						width="213" height="162"></td>
				</c:forEach>


			</tr>
		</tbody>
	</table>
</article>
<jsp:include page="footer.jsp" />
