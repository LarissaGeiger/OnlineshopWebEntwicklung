<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>


<h2>${produktDetail.name}Produktbeschreibung</h2>
<table>
	<tr>
		<td><img src="../BilderLesenServlet?id=${produktDetail.bildID}"
			width="213" height="162" alt="${produktDetail.name}"></td>
		<td>


			<ul>
				<c:if test="${titel=='Fernseher'}">

					<li>Preis: ${produktDetail.preis}€</li>
					<li>Farbe: ${produktDetail.farbe}</li>
					<li>Marke: ${produktDetail.marke}</li>
					<li>Bildschirmdiagonale: ${produktDetail.bildschirmdiagonale}
						Zoll</li>
					<li>Displaytechnologie: ${produktDetail.displaytech}</li>
					<br />
				</c:if>

				<c:if test="${titel=='Kameras'}">
					<li>Preis: ${produktDetail.preis}€</li>
					<li>Farbe: ${produktDetail.farbe}</li>
					<li>Marke: ${produktDetail.marke}</li>
					<li>Bildschirmdiagonale: ${produktDetail.sensorauflösung}
						Pixel</li>
					<li>Displaytechnologie: ${produktDetail.displaygröße} Zoll</li>
					<li>Modell: ${produktDetail.modell}</li>
					<br />

				</c:if>


				<c:if test="${titel=='Notebooks'}">
					<li>Preis: ${produktDetail.preis}€</li>
					<li>Farbe: ${produktDetail.farbe}</li>
					<li>Marke: ${produktDetail.marke}</li>
					<li>Bildschirmdiagonale: ${produktDetail.betriebssystem}</li>
					<li>Displaytechnologie: ${produktDetail.arbeitsspeicher} GB</li>
					<br />
				</c:if>


				<c:if test="${titel=='Smartphones'}">
					<li>Preis: ${produktDetail.preis}€</li>
					<li>Farbe: ${produktDetail.farbe}</li>
					<li>Marke: ${produktDetail.marke}</li>
					<li>Bildschirmdiagonale: ${produktDetail.displaygröße} Zoll</li>
					<li>Displaytechnologie: ${produktDetail.betriebssystem}</li>
					<li>Speicherplatz: ${produktDetail.speicherplatz} GB</li>
					<br />
				</c:if>

			</ul>
		</td>
	</tr>

</table>
