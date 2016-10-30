<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<spring:url value="/res/greetingSection/simpleGreeting.css" var="greetingCss" />
        <link href="${greetingCss}" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="greetingblock">
<%
java.util.Calendar currTime = new java.util.GregorianCalendar();


if (currTime.get(currTime.HOUR_OF_DAY) < 12)
{ %>
<spring:message code="label.greeting-morning" />
<% }
else if (currTime.get(currTime.HOUR_OF_DAY) < 18)
{ %>
<spring:message code="label.greeting-day" />
<% }
else
{ %>
<spring:message code="label.greeting-evening" />
<% } %>
</div>
</body>
</html>