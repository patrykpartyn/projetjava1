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
    <jsp:param name="pageName" value="home"/>
</jsp:include>
<div id="main" class="card-body">
        To moja strona domowa
        <br/>
        ${message} (<= ta wiadomość jest wynikiem realizacji zadania 2)
        <br/>
        <a href="vehicleList.html">Lista komponentów JB wyświetlonych z użyciem JSTL (Zadanie 4)</a><br/>
        </div>
        <jsp:include page="shared/footer.jsp"/>
    </body>
    </html>