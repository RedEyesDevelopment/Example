<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
        <title><spring:message code="label.search" /></title>
        <spring:url value="/res/simple.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" type="text/css"/>
</head>
<body>

<form action="SimpleFormHandler.jsp" method="get">

Name:  <input type="text" name="firstName">
    <input type="text" name="lastName"><br>
Sex:
    <input type="radio" checked name="sex" value="male">Male
    <input type="radio" name="sex" value="female">Female
<p>
What Java primitive type best describes your personality:
<select name="javaType">
    <option value="boolean">boolean</option>
    <option value="byte">byte</option>
    <option value="char" selected>char</option>
    <option value="double">double</option>
    <option value="float">float</option>
    <option value="int">int</option>
    <option value="long">long</option>
</select>
<br>
<input type="submit">
</form>
</body>
</html>
