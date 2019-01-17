<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Lista pojazdów</title>
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
</head>
<body class="card">
<jsp:include page="shared/header.jsp">
	<jsp:param name="pageName" value="vehicleList"/>
</jsp:include>
<div id="main" class="card-body">
<H1>LISTA POJAZDÓW</H1>
<H3>Implementacja widoku z tagów JSTL(JSP Standard Tags Library)</H3>

<c:if test="${empty vehicleList}">
	Lista pojazdów jest pusta
</c:if>

<c:if test="${not empty vehicleList}">
	Lista zawiera ${fn:length(vehicleList)} pojazdów

	<c:set var="boundMin" value="${20000}"/>
	<c:set var="boundMax" value="${40000}"/>

	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Marka</th>
				<th>Model</th>
				<th>Data produkcji</th>
				<th>Cena</th>
				<th>Opinia</th>
				<th>Opcje</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${vehicleList}" var="vehicle">
			<tr>
				<td>
					<a href="?id=${vehicle.id}">${vehicle.name}</a>
				</td>
				<td>${empty vehicle.model?'Brak danych': vehicle.model}</td>
				<td><fmt:formatDate  value="${vehicle.productionDate}"  type="date" timeStyle="medium"/></td>
				<td><fmt:formatNumber type="CURRENCY" value="${vehicle.price}"  currencySymbol="PLN"/></td>
				<td>
					<c:choose>
						<c:when test="${vehicle.price lt boundMin}">
							TANI
						</c:when>
						<c:when test="${vehicle.price gt boundMax}">
							DROGI
						</c:when>
						<c:otherwise>
							ŚREDNI
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a class="btn btn-danger" href="?did=${vehicle.id}">Usuń</a>
					<a class="btn btn-success" href="vehicleForm.html?id=${vehicle.id}">Edytuj</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

<a class="btn btn-success" href="vehicleForm.html">Dodaj Nowy</a>
</div>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>