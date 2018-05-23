<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="kategorieLesen" /> 
	<include page="AngeboteLesen" /> 

<!--jsp:include page="header.jsp" -->
<div>
	<h2>Tagesaktuelle Angebote</h2>
	<c:forEach items="${angebot}" var="parameter">
					<th>c:out value  ${parameter.angebot}</th>
				</c:forEach>
	<!-- <img src="BilderLesenServlet?bez=appleMac"> --> 
	<table>
		<!-- Tabelle 4x2 -->
		<thead>
			<tr>
				<c:forEach items="${kategorie}" var="parameter">
					<th><a href="html/${parameter.name}.jsp" option value="${parameter}">Im Bereich ${parameter.name} </option></a></th>
				</c:forEach>


<!-- 
				<th><a href="html/kategorieFernseher.html"> Im Bereich
						Fernseher</a></th>
				<th><a href="html/kategorieNotebooks.html">Im Bereich
						Notebooks</a></th>
				<th><a href="html/kategorieSmartphones.html">Im Bereich
						Smartphones</a></th>
				<th><a href="html/kategorieKameras.html">Im Bereich Kameras</a></th> -->
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="img/fernseher.jpg" width="213" height="162"
					alt="Fernseher"></td>
				<td><img src="img/notebook.jpg" width="213" height="162"
					alt="Notebook"></td>
				<td><img src="img/smartphone.jpg" width="213" height="162"
					alt="Smartphone"></td>
				<td><img src="img/kameras.jpg" width="213" height="162"
					alt="Kameras"></td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="footer.jsp" />
