<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:45:29
    Author     : formation
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"></c:import>
        <contenu>
            <h1>Identification</h1>
        <form:form modelAttribute="utilDTO">
            <label>Identifiant</label>
            <form:input path="identifiant"/>
            <label>M-d-p</label>
            <form:input path="motDePasse"/>
            <input type="submit"/>
        </form:form>
        </contenu>
        <c:import url="_PIED.jsp"></c:import>
</body>
</html>
