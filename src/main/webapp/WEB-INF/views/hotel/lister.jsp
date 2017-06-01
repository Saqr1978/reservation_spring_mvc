<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:45:29
    Author     : formation
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <a href="<spring:url value="/hotel/ajouter"/>">Ajouter</a>
        <contenu>
            <table>
                <c:forEach items="${listeHotels}" var="h">
                    <tr>
                        <td>${h.nom}</td>
                        <td>${h.adresse.rue}</td>
                        <td>
                            <a href='<spring:url value="/hotel/supprimer/${h.id}"/>'>Supprimer</a>
                            <a href='<spring:url value="/hotel/modifier/${h.id}"/>'>Modifier</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </contenu>
        <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
