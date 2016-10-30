<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/res/footerSection/simpleFooter.css" var="footerCss" />
        <link href="${footerCss}" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="footerblock">Made by Gvozd</div>
<%
java.util.Calendar footerTime = new java.util.GregorianCalendar();

    if ((footerTime.get(footerTime.MONTH) == 3)&&(footerTime.get(footerTime.DAY_OF_MONTH) == 8))
    { %>
<spring:url value="/res/footerSection/heartFlower.gif" var="mainImg" />
   <% }
   else { %>
   <spring:url value="/res/footerSection/simpleFlower.png" var="mainImg" />
    <% } %>
    <div class="footerimage">
<img src="${mainImg}" alt="flower">
</div>
</body>
</html>