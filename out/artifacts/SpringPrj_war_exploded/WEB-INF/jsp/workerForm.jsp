<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap-material-design/4.1.1/assets/css/docs.min.css" />
    <link rel="stylesheet" type="text/css"
          href="statics/css/main.css" />
</head>
<body class="card">
<c:import url="shared/header.jsp">
    <c:param name="pageName" value="workerForm"></c:param>
</c:import>
<div id="main" class="card-body container">
    <form:form modelAttribute="worker">
        <div class="form-group">
            <label for="firstName" class="bmd-label-floating">Imie:</label>
            <form:input path="firstName" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="firstName" cssClass="error text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="lastName" class="bmd-label-floating">Nazwisko:</label>
            <form:input path="lastName" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
            <form:errors path="lastName" cssClass="error text-danger" element="div"/>
        </div>
        <div class="form-group">
        <label for="salary" class="bmd-label-floating">Zarobki:</label>
        <form:input path="salary" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
        <form:errors path="salary" cssClass="error text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="employmentDate" class="bmd-label-floating">Data zatrudnienia:</label>
            <form:input path="employmentDate" cssClass="form-control" type="date" cssErrorClass="form-control is-invalid"/>
            <form:errors path="employmentDate" cssClass="error text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="workerType.id" class="bmd-label-floating">Typ Pracwonika:</label>
            <form:select path="workerType.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
                <form:option value="-1">--wybierz typ pracownika--</form:option>
                <form:options items="${workerType}" itemLabel="name" itemValue="id"/>
            </form:select>
            <form:errors path="workerType.id" cssClass="error text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="workerWorkArea.id" class="bmd-label-floating">Miejsce pracy:</label>
            <form:select path="workerWorkArea.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
                <form:option value="-1">--wybierz miejsce pracy--</form:option>
                <form:options items="${workerWorkArea}" itemLabel="name" itemValue="id"/>
            </form:select>
            <form:errors path="workerWorkArea.id" cssClass="error text-danger" element="div"/>
        </div>




        <button type="submit" class="btn btn-primary btn-raised">Zapisz</button>
    </form:form>

</div>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>



