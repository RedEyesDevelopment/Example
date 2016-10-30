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

<h3><spring:message code="label.places" /></h3>
<c:if test="${!empty placeList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.placeNameId" /></th>
			<th><spring:message code="label.description" /></th>
			<th><spring:message code="label.address" /></th>
			<th><spring:message code="label.telephone" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${placeList}" var="place">
			<tr>
				<td><a href="select/${place.id}">${place.placename}</a></td>
				<td>${place.description}</td>
				<td>${place.address}</td>
				<td>${place.telephone}</td>
				<td><a href="delete/${place.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
<%@include file="/WEB-INF/jsp/includes/standartFooter.jsp" %>
</html>
