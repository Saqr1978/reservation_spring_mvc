<%-- 
    Document   : ajouter
    Created on : 31 mai 2017, 16:42:40
    Author     : formation
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cheminAjout">
    <spring:url value="/chambre/ajouter"/>
</c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
            <h1>Ajout chambre</h1>
        <form:form modelAttribute="chambre" action="${cheminAjout}">
            <label>Ajout chambre:</label>
            <form:input path="nom"/>
            <label>Prix chambre:</label>
            <form:input path="prix"/>
            <label>Hotel:</label>
            <form:select items="${hotels}" itemLabel="nom" itemValue="id" path="hotel.id"/>
            <input type="Submit"/>
        </form:form>
    </body>
</html>
