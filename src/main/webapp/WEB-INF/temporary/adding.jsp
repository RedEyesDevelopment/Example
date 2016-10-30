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
<form action="addingHandler" method="get">

<spring:message code="label.placeNameId" />:  <input type="text" name="placename"><br>
<spring:message code="label.description" />:  <input type="text" name="description"><br>
<spring:message code="label.address" />:  <input type="text" name="address"><br>
<spring:message code="label.telephone" />:  <input type="text" name="telephone"><br>
<br>
<input type="submit">
</form>

</body>
<%@include file="/WEB-INF/jsp/includes/standartFooter.jsp" %>
</html>
