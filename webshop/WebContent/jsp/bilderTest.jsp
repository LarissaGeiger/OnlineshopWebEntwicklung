<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" 
   uri = "http://java.sun.com/jsp/jstl/functions" %>
<table>


	<tr>
	
		<c:forEach items="${produkt}" var="parameter">
		<c:set var="string1" value ="${titel}" />
		<c:set var="string2" value="${fn:toLowerCase(string1)}" />
			<th><a href="jsp/produktDetailPage.jsp?page=${parameter.pageName}&titel=${titel}">
					${parameter.name}</a></th>
		</c:forEach>

	</tr>
	<tr>

		<c:forEach items="${produkt}" var="parameter">
			<td><img src="BilderLesenServlet?id=${parameter.bildID}"
				width="213" height="162"></td>
		</c:forEach>
	</tr>

</table>
