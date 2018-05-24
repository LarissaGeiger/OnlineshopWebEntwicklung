<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="KategorieLesen" />
<include page="AngeboteLesen" />

<!--jsp:include page="header.jsp" -->
<article>

	<h2>Tagesaktuelle Angebote</h2>
	<c:forEach items="${angebot}" var="parameter">
		<th>c:out value ${parameter.angebot}</th>
	</c:forEach>
	<!-- <img src="BilderLesenServlet?bez=appleMac"> -->

	<h3>Unsere Kategorien für Sie</h3>

	<table>

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
					<th><img src="BilderLesenServlet?id=${parameter.bildID}"
						width="213" height="162"></th>
				</c:forEach>

				<!-- <td><img src="img/fernseher.jpg" width="213" height="162"
					alt="Fernseher"></td>
				<td><img src="img/notebook.jpg" width="213" height="162"
					alt="Notebook"></td>
				<td><img src="img/smartphone.jpg" width="213" height="162"
					alt="Smartphone"></td>
				<td><img src="img/kameras.jpg" width="213" height="162"
					alt="Kameras"></td> -->
			</tr>
		</tbody>
	</table>
</article>
<jsp:include page="footer.jsp" />
