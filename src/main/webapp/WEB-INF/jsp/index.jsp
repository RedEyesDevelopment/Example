<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
        <title>Example :: Spring Application</title>
        <spring:url value="/res/simple.css" var="mainCss" />
        <spring:url value="/res/indexPage/index.gif" var="mainGif" />
        <link href="${mainCss}" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="contentblock">
        <h1>Example - Spring Application</h1>
        <h2><%@include file="/WEB-INF/jsp/includes/greeting.jsp" %><h2>
        <a href="hello.html">Hillel IT School</a>
        <br>
        <img src="${mainGif}" alt="MY HUGE DIIIICK!" style="float:center;width:350px;height:350px;">
        </div>
    </body>
<%@include file="/WEB-INF/jsp/includes/standartFooter.jsp" %>
</html>