<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>

<h2><spring:message code="label.title" /></h2>

<c:if test="${(searchable!=null)}">
	<table class="placedata">
	<c:set var="place" value="${searchable}" scope="page" />
		<tr>
			<td><spring:message code="label.placeNameId" /></td>
			<td>${place.placename}</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><spring:message code="label.description" /></td>
			<td>${place.description}</td>
		</tr>
		<tr>
            <td><spring:message code="label.address" /></td>
            <td>${place.address}</td>
        </tr>
        <tr>
            <td><spring:message code="label.telephone" /></td>
			<td>${place.telephone}</td>
		</tr>
	</table>
</c:if>

</body>
<%@include file="/WEB-INF/jsp/includes/standartFooter.jsp" %>
</html>
