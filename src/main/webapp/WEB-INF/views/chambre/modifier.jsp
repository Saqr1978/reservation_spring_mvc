<%-- 
    Document   : modifier
    Created on : 31 mai 2017, 16:43:55
    Author     : formation
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cheminModif">
    <spring:url value="/chambre/modifier"/>
</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
            <h1>Modification chambre</h1>
        <form:form modelAttribute="chambre" action="${cheminModif}">
            <label>Ajout chambre:</label>
            <form:input path="nom"/>
            <label>Prix chambre:</label>
            <form:input path="prix"/>
            <label>Hotel:</label>
            <form:select path="hotel.id" items="${hotels}" itemLabel="nom" itemValue="id" />
            <input type="Submit"/>
        </form:form>
    </body>
</html>
