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

<%

// Grab the variables from the form.
    String newPlacePlacename = request.getParameter("placename");
    String newPlaceDescription = request.getParameter("description");
    String newPlaceAddress = request.getParameter("address");
    String newPlaceTelephone = request.getParameter("telephone");
%>
<%-- Print out the variables. --%>
<% Place newPlace = new Place();
newPlace.setPlacename(newPlacePlacename);
newPlace.setDescription(newPlaceDescription);
newPlace.setAddress(newPlaceAddress);
newPlace.setTelephone(newPlaceTelephone);
placeService.addPlace(newPlace);
newPlace = null;
%>

<% response.sendRedirect("list.html"); %>
</body>
</html>
