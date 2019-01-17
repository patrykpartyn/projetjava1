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
<H1>Dane pojazdu</H1>
Id: <b>${vehicle.id}</b><br/>
    Czas utworzenia wpisu: <b><fmt:formatDate  value="${vehicle.creationDate}" type="both" timeStyle="medium"/></b><br/>
Marka: <b>${empty vehicle.name?'Brak danych': vehicle.name}</b><br/>
Model: <b>${empty vehicle.model?'Brak danych': vehicle.model}</b><br/>
Cena: <b><fmt:formatNumber type="CURRENCY" value="${vehicle.price}"  currencySymbol="PLN"/></b><br/>
Data produkcji <b><fmt:formatDate  value="${vehicle.productionDate}"  type="date" timeStyle="medium"/></b><br/>
    Typ pojazdu: <b>${vehicle.vehicleType.name}</b><br/>

<a class="btn btn-success" href="/vehicleList.html">Wstecz</a>
</div>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>